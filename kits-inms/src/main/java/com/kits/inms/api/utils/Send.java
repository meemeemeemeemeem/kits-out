package com.kits.inms.api.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kits.inms.api.entity.BaseModel;
import com.kits.inms.api.entity.BaseResponse;
import com.kits.inms.bs.exception.ApiException;

public class Send {
	public static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 发送请求并对结果进行处理
	 * @param data
	 * @param url
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
    //public static BaseResponse send(Map<String, Object> req, String url) throws ApiException {
	public static BaseResponse send(List<Map<String, Object>> data, String url) throws ApiException {
		//List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		//data.add(req);
		String key = "111111";
		Class c = BaseModel.class;
		
		//发送请求
		//Object obj = Send.sendHttp(data, key, url, c);
		List<BaseModel> list = (List<BaseModel>) sendHttp(data, key, url, c);
		//对结果进行转换
		BaseModel bm = list.get(0);
		String code = bm.getRetcode();
		if("1".equals(code)) {
			code = "200";
		}else {
			code = "500";
		}
		String msg = bm.getRetmsg();
		String data1 = bm.getDataInfo();
		
		return new BaseResponse(code, msg, data1);
    }
	
	/**
     * 发送http请求
     * @param data 数据 
     * @param key 密钥
     * @param url 地址
     * @param c 
     * @return
	 * @throws ApiException 
     */
    @SuppressWarnings("rawtypes")
	public static Object sendHttp(Object data, String key, String url, Class c) throws ApiException {
        Map<String, String> map = new HashMap<String, String>();
        try {
            //时间戳
            String timestamp = String.valueOf(new Date().getTime());
            //随机字符串
            String nonce = getRand(32);
            //请求参数：转换为Json字符串
            String json = toJson(data); 
            map.put("timestamp", timestamp);
            map.put("nonce", nonce);
            map.put("data", json);
            map.put("sign", signMd5(map, key));//获取签名数据
            
            //获取最终发送JSON字符串
            String send = toJson(map);
            System.out.println("请求URL：" + url);
            //logger.info("请求URL：" + url);
            System.out.println("发送报文信息：" + send);
            //logger.info("发送报文信息：" + send);
            
            //发送到服务器
            byte[] buf = HttpClientPost.sendHttp(send.getBytes("UTF-8"), url);
            if (buf!=null && buf.length>0) {
                String ret = new String(buf, "UTF-8");
                //logger.error("反馈报文:" + ret);
                //读取反馈信息
                ret = getReturnValue(ret, key);
                //格式化反馈信息
                return formatJson(ret, c);
            }
        } catch (Exception e) {
        	e.printStackTrace();
            //logger.error(e.getMessage(), e);
            throw new ApiException(e.getMessage());
        }
        return null;
    }
    
    /**
     * 根据参数n获取对应位数的随机字符串
     * @param n
     * @return
     */
    private static String getRand(int n) {
        Random rnd = new Random();
        int x = rnd.nextInt(10);
        //第一个字符不能为0
        while (x==0) {
            x = rnd.nextInt(10);
        }
        
        String pass = String.valueOf(x);
        for (int i=1; i<n; i++) {
            pass = pass + String.valueOf(rnd.nextInt(10));
        }
        return pass;
    }
    
    /**
     * 将Object数据转化为Json字符串
     * @param o
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String toJson(Object o) throws JsonGenerationException, JsonMappingException, IOException {
        return objectMapper.writeValueAsString(o);
    }
    
    /**
     * 获取签名数据
     * @param data
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String signMd5(Map<String, String> data, String key) throws UnsupportedEncodingException {
        String[] keys = new String[1];
        keys = data.keySet().toArray(keys);
        //排序
        Arrays.sort(keys);
        
        //
        StringBuffer sb = new StringBuffer();
        for (String k : keys) {
            String value = String.valueOf(data.get(k));
            if (value!=null && !"sign".equals(k)) {
                if (sb.length()!=0) {
                    sb.append("&");
                }
                sb.append(k).append("=").append(value);
            }
        }
        if (key!=null) {
            sb.append("&key=").append(key);
        }
        return getMd5(sb.toString().getBytes("UTF-8"));
    }
	
    /**
     * MD5加密
     * @param bytes
     * @return
     */
    private static String getMd5(byte[] bytes) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            StringBuffer buf = new StringBuffer();
            for (byte b : bytes) {
                buf.append((int) b).append(",");
            }
            mdInst.update(bytes);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i=0; i<md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
   
    /**
     * 读取反馈数据
     * @param ret
     * @param key
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getReturnValue(String ret, String key) throws ApiException {
        try {
            Map map = objectMapper.readValue(ret, Map.class);
            
            //校验MD5
            String signMd5 = signMd5(map, key);
            if ((null==signMd5 || "".equals(signMd5.trim()) && !signMd5.equals(map.get("sign")))) {
                throw new ApiException("报文数据签名无效：数据签名不一致" + signMd5);
            }
            return (String) map.get("data");
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ApiException(e.getMessage());
        }
    }

    /**
     * 格式化反馈信息
     * @param data
     * @param c
     * @return
     * @throws ApiException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static Object formatJson(String data, Class c) throws ApiException {
        try {
            if (c==null) {
                return data;
            } else if (String.class.isAssignableFrom(c)) {
                return data;
            } else {
                //判断是数组还是object
                if (data.startsWith("[")) {
                    //组合类型List<c>
                    JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, c);
                    return objectMapper.readValue(data, javaType);
                } else {
                    return objectMapper.readValue(data, c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException(e.getMessage());
        }
    }
    
    
    
}