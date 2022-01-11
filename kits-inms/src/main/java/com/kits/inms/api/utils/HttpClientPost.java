package com.kits.inms.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.kits.inms.bs.exception.ApiException;

/**
 * http处理
 * Filename:    HttpClientPost.java  
 * Description:   
 * Copyright:   Copyright (c) 2012-2013 All Rights Reserved.
 * Company:     
 * @author:     zhangcheng
 * @version:    1.0  
 * Create at:   2019-09-05
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * -------------------------------------------------------------  
 * 2019-09-05      zhangcheng      1.0         1.0 Version  
 */
@SuppressWarnings("deprecation")
public class HttpClientPost {
    /**
     * 通过http协议发送数据
     * @param buf
     * @param url
     * @return
     * @throws ApiException 
     */
    public static byte[] sendHttp(byte[] buf, String url) throws ApiException {
        HttpClient httpClient = new HttpClient();
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
        if (buf!=null && buf.length!=0) {
            post.setRequestEntity(new ByteArrayRequestEntity(buf));
        }
        try {
            httpClient.executeMethod(post);
            return post.getResponseBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("发送数据失败：" + e.getMessage());
        } finally {
            post.releaseConnection();
        }
    }

    /**
     * 通过http协议发送数据
     * @param buf
     * @param url
     * @return
     * @throws ApiException 
     */
    public static byte[] sendHttp(NameValuePair[] data, String url) throws ApiException {
        HttpClient httpClient = new HttpClient();
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Content-Type", "application/xml; charset=utf-8");
        if (data!=null) {
            post.setRequestBody(data);
        }
        try {
            httpClient.executeMethod(post);
            return post.getResponseBody();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("发送数据失败：" + e.getMessage());
        } finally {
            post.releaseConnection();
        }
    }

    /** 
     * 根据地址获得数据的字节流 
     * @param strUrl 网络连接地址 
     * @return 
     */
    public static Object[] getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
            String filename = conn.getHeaderField("Content-disposition");
            Object[] o = new Object[2];
            o[0] = filename;
            o[1] = btImg;
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 
     * 从输入流中获取数据 
     * @param inStream 输入流 
     * @return 
     * @throws Exception 
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 发送http数据
     * @param requsetString
     * @param requestData
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws ClientProtocolException
     * @throws IOException
     */
    @SuppressWarnings("resource")
	public static byte[] sendHttps(byte[] data, String url) 
    		throws NoSuchAlgorithmException, KeyManagementException, ClientProtocolException, IOException {
    	X509TrustManager trustManager = new X509TrustManager() {
    		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    			
            }
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            	
            }
            public X509Certificate[] getAcceptedIssuers() {
            	return null;
            }
    	};
        SSLContext sslcontext = SSLContext.getInstance("SSL");
        sslcontext.init(null, new TrustManager[] { trustManager }, null);
        SSLSocketFactory sf = new SSLSocketFactory(sslcontext);
        sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        DefaultHttpClient httpclient = new DefaultHttpClient();
        httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sf, 443));

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Authorization", "basic dGNsb3VkYWRtaW46dGNsb3VkMTIz");
        httpPost.setHeader("Content-type", "application/xml");
        httpPost.setEntity(new ByteArrayEntity(data));
        
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity resEntity = response.getEntity();
        InputStream reader = resEntity.getContent();

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        byte[] buf = new byte[1];
        while (reader.read(buf) != -1) {
            bs.write(buf);
        }
        httpclient.getConnectionManager().shutdown();

        return bs.toByteArray();
    }

    /**
     * 带CA格式发送信息
     * @param data
     * @param url
     * @param capath
     * @param pwd
     * @return
     */
    public static byte[] sendHttpByCa(byte[] data, String url, String capath, String pwd) {
        CloseableHttpClient httpclient = null;
        FileInputStream instream = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            instream = new FileInputStream(new File(capath));
            try {
                keyStore.load(instream, pwd.toCharArray());
            } finally {
                instream.close();
            }
            
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, pwd.toCharArray()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, 
            		null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new ByteArrayEntity(data));

            CloseableHttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity!=null) {
                InputStream reader = entity.getContent();
                byte[] buf = new byte[1];
                ByteArrayOutputStream bs = new ByteArrayOutputStream();    
                while (reader.read(buf) != -1) {
                    bs.write(buf);
                }
                EntityUtils.consume(entity);
                return bs.toByteArray();
            }
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpclient!=null) {
                    httpclient.close();
                }
            } catch (Exception e) {
            	
            }
            try {
                if (instream!=null) {
                    instream.close();
                }
            } catch (Exception e) {
            	
            }
        }
        return null;
    }
    
    
    
}