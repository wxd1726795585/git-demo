package com.example.utils;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class ImageToBase64Utils {

    private static String strNetImageToBase64;
    private static String strLocalImageToBase64;
    public static void main(String[] args) {
        //第一个:把网络图片装换成Base64
        String netImagePath = "http://fc-feed.cdn.bcebos.com/0/pic/8015cec4ee757a20f0b1f28b6b6daf9a.jpg";
        //下面是网络图片转换Base64的方法
        String imageToBase64 =NetImageToBase64(netImagePath);

        //下面是本地图片转换Base64的方法
        // String imagePath = "C:\\Users\\Administrator\\IdeaProjects\\testdemo\\src\\main\\resources\\static\\testPictrue.jpg";


        // String imageToBase64 = LocalImageToBase64(imagePath);
        System.out.println(imageToBase64);
    }

    /**
     * 网络图片转换Base64的方法
     *
     * @param netImagePath
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);


            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            strNetImageToBase64 = encoder.encode(data.toByteArray());
            System.out.println("网络图片转换Base64:" + strNetImageToBase64);
            // 关闭流
            is.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return strNetImageToBase64;
    }


    /**
     * 本地图片转换Base64的方法
     *
     * @param imgPath
     * @return
     */

    public static String LocalImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(data)));
        strLocalImageToBase64=encoder.encode(Objects.requireNonNull(data));
        return strLocalImageToBase64;
    }
}
 