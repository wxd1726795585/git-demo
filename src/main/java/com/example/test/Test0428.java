package com.example.test;


import jdk.internal.util.Preconditions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/4/28
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0428 {


    // 地球半径，单位是千米
    private static final double EARTH_RADIUS = 6371.0;

    /**
     * 使用Haversine公式计算地球上两点间的距离。
     *
     * @param lat1 第一个点的纬度
     * @param lon1 第一个点的经度
     * @param lat2 第二个点的纬度
     * @param lon2 第二个点的经度
     * @return 两点间的距离，单位千米
     */
    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将角度转换为弧度
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // 应用haversine公式
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // 返回最终结果
    }

    /**
     * 经纬度:116.497072, 39.981029  电子城科技大厦   	116.495459,39.984307 瀚海国际大厦
     *
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

    public  static String test(){
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5");
        stringList.forEach(s -> {
            if (s.equals("3")){
                return;
            }
            System.out.println(s);
        });
        return "success";
    }
}


