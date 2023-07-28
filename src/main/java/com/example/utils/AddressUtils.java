package com.example.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jinhao
 * @create 2022/06/15 10:33
 * @description
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
     * 百度地图开发者,应用key-肖金浩个人key
     */
    public final static String BD_AK = "jE7rzvs8El42VDuGwcG0Ylh6XXXrYItY";

    /**
     * 通过经纬度获取地址信息请求地址-百度
     */
    public final static String BD_GET_ADDRESS_BY_LOCATION_URL = "https://api.map.baidu.com/reverse_geocoding/v3/";


}
