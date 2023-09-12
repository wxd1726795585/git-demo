/*
package com.example.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadExample {
    public static void main(String[] args) {
        String filePath = "文件的全路径地址"; // 替换为你的文件路径
        String fileName = "下载文件名"; // 替换为你的文件名

        // 创建 HttpServletResponse 对象（假设你正在编写一个 Servlet）
        HttpServletResponse response = null;

        try {
            // 设置响应头部信息
            response.setHeader("Content-Disposition", getContentDisposition(fileName));
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Length", String.valueOf(getFileSize(filePath)));

            // 读取文件内容并写入响应输出流
            FileInputStream fis = new FileInputStream(new File(filePath));
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }

            // 关闭流
            os.flush();
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取文件大小
    private static long getFileSize(String filePath) {
        File file = new File(filePath);
        return file.length();
    }

    // 根据浏览器类型和文件名，获取 Content-Disposition 头部的值
    private static String getContentDisposition(String fileName, String userAgent) throws IOException {
        String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replace("+", "%20");
        if (userAgent.contains("Firefox")) {
            return "attachment; filename*=\"utf-8''" + encodedFileName + "\"";
        } else if (userAgent.contains("Chrome")) {
            return "attachment; filename=\"" + encodedFileName + "\"";
        } else if (userAgent.contains("Safari")) {
            return "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
        } else {
            return "attachment; filename=\"" + encodedFileName + "\"";
        }
    }
}*/
