package com.example.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/****************************************
 * @name HttpClientUtil
 * @description http请求工具类
 * @author ruanzx
 * @since 2018-06-14
 ***************************************/
public final class HttpClientUtilDemo {

    private HttpClientUtilDemo(){}

    /**
     * 默认字符集为UTF-8
     */
    private static String charset  = "UTF-8";

    /**
     * 默认每个路由最大连接数，默认5。
     */
    private static int defaultMaxPerRoute = 5;

    /**
     * 最大连接数，默认20。
     */
    private static int maxTotal = 20;

    /**
     * 连接超时时间(毫秒)，默认5秒
     */
    private static int connectTimeOut = 5000;

    /**
     * 等待数据超时时间(毫秒)，默认10秒
     */
    private static int socketTimeOut = 120000;

    /**
     * 关闭N秒内不活动的连接，默认30秒内不活动连接将被关闭。
     */
    private static int idleTimeOut = 30;

    /**
     * 连接管理监视器
     */
    private static Timer httpConncetionMonitor;

    /**
     * http连接管理器
     */
    private static PoolingHttpClientConnectionManager httpConnectionManager = new PoolingHttpClientConnectionManager();

    /**
     * 初始化操作
     */
    static{
        httpConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        httpConnectionManager.setMaxTotal(maxTotal);
        httpConncetionMonitor = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                // 关闭失效的连接
                httpConnectionManager.closeExpiredConnections();
                // 关闭N秒内部活动的连接
                httpConnectionManager.closeIdleConnections(idleTimeOut, TimeUnit.SECONDS);
            }
        };
        // 每5秒检测一次
       // httpConncetionMonitor.schedule(task, 5000, 10000);
    }

    /**
     * httppost请求
     * @param url 请求URL
     * @param content 请求传输内容
     * @param params 请求传输参数
     * @param charset 字符编码（默认UTF-8）
     * @return
     * @throws Exception
     */
    public static String doPost(String url, JSONObject params, String charset, String... contentType) throws Exception {

        if(StringUtils.isBlank(url)){
            throw new Exception("url is empty");
        }

        if(StringUtils.isBlank(charset)){
            charset = HttpClientUtilDemo.charset;
        }

        String postUrl = url;

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String result = null;

        try {
            HttpEntity entity = new StringEntity(params.toString(), charset);

            client = getHttpClient(postUrl);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(RequestConfig.custom().setConnectTimeout(connectTimeOut)// 设置请求超时时间
                    .setSocketTimeout(socketTimeOut)// 设置等待数据超时时间
                    .setConnectionRequestTimeout(connectTimeOut).build()); //设置从连接池获取连接的超时时间
            if (contentType.length > 0) {
                httpPost.setHeader("Content-Type", contentType[0] + "; charset=UTF-8");
            } else {
                httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");
            }

            httpPost.setEntity(entity);
            response = client.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            result = EntityUtils.toString(respEntity, charset);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (response != null) response.close();
            } catch (IOException e) {
                throw e;
            }
        }

        return result;
    }

    /**
     * httpGet
     * @param url	请求url
     * @param params
     * @param charset	编码
     * @return
     * @throws Exception
     */
    public static String doGet(String url,JSONObject params, String charset) throws Exception {

        if(StringUtils.isBlank(url)){
            throw new Exception("url is empty");
        }

        if(StringUtils.isBlank(charset)){
            charset = HttpClientUtilDemo.charset;
        }

        //设置参数

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        String result = null;

        try {
            HttpEntity entity = new StringEntity(params.toString(), charset);
            client = HttpClientBuilder.create().build();
            String str = EntityUtils.toString(entity);
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(RequestConfig.custom().setConnectTimeout(connectTimeOut)// 设置请求超时时间
                    .setSocketTimeout(socketTimeOut)// 设置等待数据超时时间
                    .setConnectionRequestTimeout(connectTimeOut).build()); //设置从连接池获取连接的超时时间
            httpGet.setURI(new URI(httpGet.getURI().toString()+ "?" + str));
            response = client.execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            result = EntityUtils.toString(respEntity, charset);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (response != null) response.close();
            } catch (IOException e) {
                throw e;
            }
        }

        return result;
    }


    /**
     * form-data方式提交
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String httpPostWithForm(String url,Map<String,String> param) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        //表单方式
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        for(String key : param.keySet()){
            pairList.add(new BasicNameValuePair(key, param.get(key)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));


        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }

    /**
     * 获取httpclient
     * @param url 预留后续判断是否https用
     * @return
     */
    private static CloseableHttpClient getHttpClient(String url) {
        return HttpClients.custom().setConnectionManager(httpConnectionManager).setRetryHandler(new DefaultHttpRequestRetryHandler(0,false)).build();
    }
}
