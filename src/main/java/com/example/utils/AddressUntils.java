package com.example.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class AddressUntils {
    private final static Logger logger = LoggerFactory.getLogger(AddressUntils.class);

    public static void main(String[] args) {
        // lat 31.2990170   纬度
        //log 121.3466440    经度
        String add = AddressUntils.getAdd("121.3466440", "31.2990170");
        logger.info(add);

    }

    /**
     * 根据经纬度获取省市区
     *
     * @param log
     * @param lat
     * @return
     */
    public static String getAdd(String log, String lat) {
        //lat 小  log  大
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + log + "&type=010";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
            //解析结果
            JSONObject jsonObject = JSONObject.parseObject(res);
            JSONArray jsonArray = jsonObject.getJSONArray("addrList");
            JSONObject jsadd = jsonArray.getJSONObject(0);
            res = jsadd.getString("admName");//返回省市区
        } catch (Exception e) {
            logger.error("获取地址信息异常{}", e.getMessage());
            return null;
        }
        return res;
    }


}