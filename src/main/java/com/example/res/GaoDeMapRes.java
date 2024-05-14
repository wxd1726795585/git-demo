package com.example.res;
import lombok.Data;

import java.util.List;

@Data
public class GaoDeMapRes {
    /**
     * 返回结果状态值，值为0或1，0表示请求失败；1表示请求成功
     */
    private String status;

    /**
     * 返回状态说明，status为0时，info返回错误原因；否则返回“OK”。详情参阅info状态表
     */
    private String info;

    /**
     * 返回距离信息列表
     */
    private List<Result> results;

    /**
     * 距离信息对象
     */
    @Data
    public static class Result {
        /**
         * 起点坐标，起点坐标序列号（从１开始）
         */
        private String origin_id;

        /**
         * 终点坐标，终点坐标序列号（从１开始）
         */
        private String dest_id;

        /**
         * 路径距离，单位：米
         */
        private String distance;

        /**
         * 预计行驶时间，单位：秒
         */
        private String duration;

        /**
         * 仅在出错的时候显示该字段。大部分显示“未知错误”
         */
        private String info;

        /**
         * 仅在出错的时候显示此字段。
         * 在驾车模式下：
         * 1，指定地点之间没有可以行车的道路
         * 2，起点/终点 距离所有道路均距离过远（例如在海洋/矿业）
         * 3，起点/终点不在中国境内
         */
        private String code;
    }
}
