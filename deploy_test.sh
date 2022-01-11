#!/bin/bash
is_down=true
timeout=5
total=120
version=`curl -sf  --connect-timeout 5 http://inms.whknow.kits/inms/version`
commit_sha=`curl -sf  --connect-timeout 5 http://inms.whknow.kits/inms/commitSha`
echo "开始打包..."
mvn package
mkdir /docker && mv Dockerfile /docker/Dockerfile && mv /builds/whknow/ng/inms/kits/target/inms.war /docker/inms.war
echo "开始构建docker镜像..."
docker build /docker --build-arg VERSION=${CI_COMMIT_REF_NAME} --build-arg COMMIT_SHA=${CI_COMMIT_SHA} --build-arg KITSLA_HOST=${KITSLA_HOST} -t docker.whknow.kits/repository/kits/kits-inms:${CI_COMMIT_SHA}
echo "开始推送docker镜像..."
docker push docker.whknow.kits/repository/kits/kits-inms:${CI_COMMIT_SHA}
echo "开始更新应用镜像..."
sshpass -p ${K8S_MASTER_PASSWORD} ssh -o StrictHostKeychecking=no ${K8S_MASTER_USER}@${K8S_MASTER_HOST} \
     "/usr/bin/kubectl set image deployment/kits-inms-test-deployment kits-inms-test=docker.whknow.kits/repository/kits/kits-inms:${CI_COMMIT_SHA} --namespace=kits"

while [[ ${version} != ${CI_COMMIT_REF_NAME} ]] || [[ ${commit_sha} != ${CI_COMMIT_SHA} ]]; do
  version=`curl -sf  --connect-timeout 5 http://inms.whknow.kits/inms/version`
  commit_sha=`curl -sf  --connect-timeout 5 http://inms.whknow.kits/inms/commitSha`
  if [[ ${total} -eq 0 ]];then
    echo "启动超时"
    curl ${DINGTALK_ROBOT_URL}  -H "Content-Type: application/json"  -d "{'msgtype': 'text',  'text': { 'content': '测试机启动超时,请相关人员排查' } }"
    exit 1
  fi
  total=`expr ${total} - ${timeout}`
  sleep 5
done
echo "启动成功"
curl -X POST ${DINGTALK_ROBOT_URL} \
  -H 'Content-Type: application/json' \
  -d '{
  "msgtype": "markdown",
  "markdown": {
    "title": "测试机更新",
    "text": "#### 测试机已更新,版本:'${CI_COMMIT_REF_NAME}'\n\n[测试机地址](http://inms.whknow.kits)\n[日志地址](http://kibana.whknow.kits/app/kibana#/discover?_g=%28refreshInterval:%28pause:!f,value:5000%29,time:%28from:now-15m,mode:quick,to:now%29%29&_a=%28columns:!%28message%29,index:bd5aeda0-8868-11e9-bb42-8ba155a144ba,interval:auto,query:%28language:lucene,query:'\'''\''%29,sort:!%28'\''@timestamp'\'',desc%29%29)\n[最后提交](http://gitlab.whknow.kits/whknow/ng/inms/commit/'${CI_COMMIT_SHA}')\n\n"
  }
}'