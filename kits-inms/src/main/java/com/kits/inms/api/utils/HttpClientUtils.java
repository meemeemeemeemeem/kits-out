package com.kits.inms.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kits.inms.api.entity.HttpClientException;
import com.kits.inms.bs.exception.ApiException;

@SuppressWarnings("unchecked")
public class HttpClientUtils {

    public static ObjectMapper  objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送http请求
     * @param data 数据 
     * @param key 密钥
     * @param url 地址
     * @param r
     * @return
     * @throws ApiException 
     */
    @SuppressWarnings("rawtypes")
	public static Object sendHttp(Object data, String key, String url, Class r) throws ApiException {
        Map<String, String> map = new HashMap<String, String>();
        try {
            //时间搓
            String timestamp = String.valueOf(new Date().getTime());
            //随机字符串
            String nonce = getRand(32);
            //data json数据
            String json = toJson(data);
            map.put("timestamp", timestamp);
            map.put("nonce", nonce);
            map.put("data", json);
            //获取签名数据
            map.put("sign", signMd5(map, key));
            //获取最终发送JSON字符串
            String send = toJson(map);
            System.out.println("请求URL：" + url);
            logger.info("请求URL：" + url);
            System.out.println("发送报文信息：" + send);
            logger.info("发送报文信息：" + send);
            //发送到服务器
            byte[] buf = HttpClientPost.sendHttp(send.getBytes("UTF-8"), url);
            if (buf != null && buf.length > 0) {
                String ret = new String(buf, "UTF-8");
                logger.error("反馈报文:" + ret);
                //处理反馈信息
                ret = getReturnValue(ret, key);
                //格式化数据
                return formatJson(ret, r);
            }
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("转化JSON失败");
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("转化JSON失败");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("格式化数据失败");
        }

        return null;
    }

    /**
     * 发送http请求
     * @param data 数据 
     * @param key 密钥
     * @param url 地址
     * @param r
     * @return
     * @throws ApiException 
     */
    public static String sendHttp(Object data, String key, String url) throws ApiException {
        Map<String, String> map = new HashMap<String, String>();
        try {
            //时间搓
            String timestamp = String.valueOf(new Date().getTime());
            //随机字符串
            String nonce = getRand(32);
            //data json数据
            String json = toJson(data);
            map.put("timestamp", timestamp);
            map.put("nonce", nonce);
            map.put("data", json);
            //获取签名数据
            map.put("sign", signMd5(map, key));
            //获取最终发送JSON字符串
            String send = toJson(map);
            logger.info("发送报文信息：" + send);
            //发送到服务器
            byte[] buf = HttpClientPost.sendHttp(send.getBytes("UTF-8"), url);
            if (buf != null && buf.length > 0) {
                String ret = new String(buf, "UTF-8");
                logger.error("反馈报文:" + ret);
                //处理反馈信息
                return getReturnValue(ret, key);
            }
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("转化JSON失败");
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("转化JSON失败");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new HttpClientException("格式化数据失败");
        }

        return null;
    }

    /**
     * 读取http流中的数据
     * @param request
     * @param key
     * @param url
     * @param r
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static Object read(HttpServletRequest request, String key, Class r) {
        DataInputStream in = null;
        try {
            in = new DataInputStream(request.getInputStream());
            Integer iCount = 0;
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            while (true) {
                //临时数据
                byte[] buf = new byte[1024];
                int i = in.read(buf);
                //判断是否关闭数据流
                if (i < 0)
                    break;
                //用于拷贝实际值
                byte[] tmp = new byte[i];
                //拷贝属性
                System.arraycopy(buf, 0, tmp, 0, i);
                //写入数据中
                bs.write(tmp);
                iCount += i;
                //判断是否结束
                if (iCount == in.available())
                    break;
            }
            //如果数据不为空，则处理数据
            if (bs.size() != 0) {
                //数据
                String data = new String(bs.toByteArray(), "UTF-8");
                logger.info("接收到报文信息：" + data);
                //处理数据
                String ret = getReturnValue(data, key);
                return formatJson(ret, r);
            }
        } catch (HttpClientException e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
        	e.printStackTrace();
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            	
            }
        }
        return null;
    }

    /**
     * 写值
     * @param response
     * @param data
     * @param key
     * @param url
     */
    public static void writeObject(HttpServletResponse response, Object data, String key) {
        ServletOutputStream out = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            //时间搓
            String timestamp = String.valueOf(new Date().getTime());
            //随机字符串
            String nonce = getRand(32);
            //data json数据
            String json = toJson(data);
            map.put("timestamp", timestamp);
            map.put("nonce", nonce);
            map.put("data", json);
            //获取签名数据
            map.put("sign", signMd5(map, key));
            //获取最终发送JSON字符串
            String send = toJson(map);
            logger.info("反馈报文信息:" + send);
            out = response.getOutputStream();
            //回写信息
            out.write(send.getBytes("UTF-8"));
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * 读取反馈数据
     * @param ret
     * @param key
     * @param t
     * @return
     */
    @SuppressWarnings("rawtypes")
	public static String getReturnValue(String ret, String key) {
        try {
            Map map = objectMapper.readValue(ret, Map.class);
            //校验MD5
            String signMd5 = signMd5(map, key);
            if ((null == signMd5 || "".equals(signMd5.trim()) && !signMd5.equals(map.get("sign")))) {
                throw new HttpClientException("报文数据签名无效：数据签名不一致" + signMd5);
            }
            return (String) map.get("data");
        } catch (JsonParseException e) {
        	e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        } catch (JsonMappingException e) {
        	e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        } catch (IOException e) {
        	e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        }
    }

    /**
     * 格式化数据
     * @param o
     * @param t
     * @return
     */
    @SuppressWarnings("rawtypes")
	private static Object formatJson(String data, Class t) {
        try {
            if (t == null) {
                return data;
            } else if (String.class.isAssignableFrom(t)) {
                return data;
            } else {
                //判断是数组还是object
                if (data.startsWith("[")) {
                    //组合类型List<t>
                    JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, t);
                    return objectMapper.readValue(data, javaType);
                } else {
                    return objectMapper.readValue(data, t);
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpClientException("返回报文格式不正确");
        }
    }

    /**
     * 获取JSON字符串
     * @param data
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static String toJson(Object o) throws JsonGenerationException, JsonMappingException, IOException {
        return objectMapper.writeValueAsString(o);
    }

    /**
     * https发送信息
     * @param data
     * @param apisecret
     * @param url
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String signMd5(Map<String, String> data, String key) throws UnsupportedEncodingException {
        String[] keys = new String[1];
        //键值
        keys = data.keySet().toArray(keys);
        //字典排序
        Arrays.sort(keys);
        //签名值字符串
        StringBuffer str = new StringBuffer();
        for (String k : keys) {
            String value = String.valueOf(data.get(k));
            if (value != null && !"sign".equals(k)) {
                if (str.length() != 0) {
                    str.append("&");
                }
                //拼接
                str.append(k).append("=").append(value);
            }
        }
        if (key != null) {
            str.append("&key=").append(key);
        }
        return getMd5(str.toString().getBytes("UTF-8"));
    }

    /**
     * MD5签名
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
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到一个n位的随机数 第一位不能为0
     * 
     * @param n
     *            位数
     * @return
     */
    private static String getRand(int n) {
        Random rnd = new Random();
        int x = rnd.nextInt(10);
        /** 过滤第一位为0 */
        while (x == 0) {
            x = rnd.nextInt(10);
        }
        String pass = String.valueOf(x);
        for (int i = 1; i < n; i++) {
            pass = pass + String.valueOf(rnd.nextInt(10));
        }
        return pass;
    }
}