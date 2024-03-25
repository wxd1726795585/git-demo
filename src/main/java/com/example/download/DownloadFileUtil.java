package com.example.download;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 从url下载文件 可以批量下载电子回单
 *
 * @author yutongwang
 * @date 2022/10/28 2:33 下午
 * @description
 */
public class DownloadFileUtil {

    public static void main(String[] args){
        //从excel读取要下载的文件名称和地址
        String pathName = "D:\\download\\任务确认单.xls";
        //下载完成好保存的目录
        String afterPathName = "D:\\download";
        String url = "https://di-deal.hvyogo.com/web-deal/common/file/download?key=";
        long l = System.currentTimeMillis();
        EasyExcel.read(pathName, FileObject.class, new PageReadListener<FileObject>(dataList -> {
            dataList.parallelStream().forEach(fileObject -> {
                //循环下载
                String param = "";
                try {
                    param = URLEncoder.encode(fileObject.getAddress(),"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                downLoadFromUrl(fileObject.getFileName(), url.concat(param), afterPathName);
                System.out.println(fileObject.getFileName());
            });
        })).sheet().doRead();
        System.out.println("下载完毕,用时"+(System.currentTimeMillis()-l));

    }

    /**
     * 从网络Url中下载文件
     *
     * @param fileName 下载之后的文件名称
     * @param urlStr  文件地址
     * @param savePath 保存路径
     * @throws IOException
     */
    public static String downLoadFromUrl(String fileName, String urlStr, String savePath) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            // 获取字节数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return saveDir + File.separator + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                conn.disconnect();
            }
        }
        return "";

    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }




}
