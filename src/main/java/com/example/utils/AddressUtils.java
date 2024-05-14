package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.example.base.BusinessException;
import com.example.res.GaoDeMapRes;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Jinhao
 * @create 2022/06/15 10:33
 * @description 地址:https://lbs.amap.com/api/webservice/guide/api/georegeo
 */
@Slf4j
public class AddressUtils {

    /**
     * 高德地图开发者,应用key-肖金浩个人key
     */
    public final static String GD_AK = "90465d57263eb7086ce18b7e010e6481";

    /**
     * 通过经纬度获取地址信息请求地址-高德
     */
    public final static String GD_GET_ADDRESS_BY_LOCATION_URL = "https://restapi.amap.com/v3/geocode/regeo";


    /**
     * 通过经纬度获取地址信息请求地址-高德
     */
    public final static String GD_GET_LOCATION_BY_ADDRESS_URL = "https://restapi.amap.com/v3/geocode/geo";

    /**
     * 百度地图开发者,应用key-肖金浩个人key
     */
    public final static String BD_AK = "jE7rzvs8El42VDuGwcG0Ylh6XXXrYItY";

    /**
     * 通过经纬度获取地址信息请求地址-百度
     */
    public final static String BD_GET_ADDRESS_BY_LOCATION_URL = "https://api.map.baidu.com/reverse_geocoding/v3/";

    /**
     * 距离测量-百度
     */
    public final static String DISTANCE_MEASUREMENT_URL = "https://restapi.amap.com/v3/distance";





    /**
     * 高德地图距离测算
     *
     * @param origins     出发点
     * @param destination 目的地
     * @return 位置描述
     */
    public static String gaoDeMapDistanceMeasurement(String origins, String destination) {
        String url = DISTANCE_MEASUREMENT_URL + "?key=" + "710983adeb8b76d901c1140512e3ac60" + "&output=json&origins=" + origins + "&destination=" + destination +"&type=0";
        System.out.println(url);
        String response;
        try {
            response = HttpUtils.get(url);
        } catch (IOException e) {
            log.error("请求高德地图网络异常,e:", e);
            throw new BusinessException("请求高德地图网络异常");
        }
        log.info("高德地图地理编码响应报文:{}", response);
        GaoDeMapRes gaoDeMapResponse = JSON.parseObject(response, GaoDeMapRes.class);
        // 判断成功
        if (!gaoDeMapResponse.getStatus() .equals("1") ) {
            log.error("高德地图地理编码失败:{}", response);
            throw new BusinessException("解析地理位置失败");
        }

        System.out.println(gaoDeMapResponse);
        return gaoDeMapResponse.getResults().get(0).getDistance();
    }

    public static void main(String[] args) {
        gaoDeMapDistanceMeasurement("116.490637,39.974961", "116.48921,39.975748");
    }




}
