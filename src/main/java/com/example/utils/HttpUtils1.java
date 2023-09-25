package com.example.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * JFinal-weixin Http请求工具类
 *
 * @author L.cm
 */
public final class HttpUtils1 {
    private static final OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build();

    private HttpUtils1() {
    }

    /**
     * 同步POST&JSON
     *
     * @param url  url
     * @param json json
     * @return String
     * @throws IOException IOException
     */
    public static String postJson(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(body).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * 同步GET
     *
     * @param url url
     * @return String
     * @throws IOException IOException
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * 同步GET
     *
     * @param url url
     * @return String
     * @throws IOException IOException
     */
    public static String getToWanMeiBaiHuo(String url,String ssoSessionId) throws IOException {
        Request request = new Request.Builder().url(url).get().addHeader("ssoSessionId",ssoSessionId).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    //-----------------------------------------------------------------------------------


    /**
     * 通用同步请求
     *
     * @param request 请求
     * @return {@link Response}
     * @throws IOException IOException
     */
    public static Response execute(Request request) throws IOException {
        return okHttpClient.newCall(request).execute();
    }

    /**
     * 通过token发送请求获取信息
     *
     * @param url       下游接口地址
     * @param token     下游传递过来
     * @param oathToken 请求下游地址获取的token(用于加在请求头)
     * @return 用户信息
     * @throws IOException
     */
    public static String postJson2(String url, String token, String oathToken) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), token);
        Request request = new Request.Builder().url(url).post(body).addHeader("Authorization", "bearer " + oathToken).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 通过token发送请求获取信息
     *
     * @param url       下游接口地址
     * @param token     下游传递过来
     * @param oathToken 请求下游地址获取的token(用于加在请求头)
     * @return 用户信息
     * @throws IOException
     */
    public static String postJsonWanMeiBaiHuo(String url, String token, String oathToken) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), token);
        Request request = new Request.Builder().url(url).post(body).addHeader("Authorization", "bearer " + oathToken).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
