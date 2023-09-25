package com.example.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/14
 * \* Description:
 * \* @author 王祥栋
 */
public class HttpClientUtils {
    public static void main(String[] args) {
        File file1 = new File("path/to/file1");
        File file2 = new File("path/to/file2");
        String otherParameter = "some value";
        String urlString = "http://example.com/upload";

        try {
            uploadFiles(urlString, file1, file2, otherParameter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void uploadFiles(String urlString, File file1, File file2, String otherParameter) throws IOException {
        // 创建URL对象
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---BOUNDARY");

        // 打开连接
        connection.connect();

        try (
                OutputStream outputStream = connection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true)
        ) {
            // 发送其他参数
            writer.append("---BOUNDARY\r\n")
                    .append("Content-Disposition: form-data; name=\"otherParameter\"\r\n")
                    .append("\r\n")
                    .append(otherParameter)
                    .append("\r\n");

            // 发送第一个文件流
            writer.append("---BOUNDARY\r\n")
                    .append("Content-Disposition: form-data; name=\"file1\"; filename=\"" + file1.getName() + "\"\r\n")
                    .append("Content-Type: application/octet-stream\r\n")
                    .append("\r\n")
                    .flush();
            try (FileInputStream inputStream = new FileInputStream(file1)) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }

            // 发送第二个文件流
            writer.append("\r\n")
                    .append("---BOUNDARY\r\n")
                    .append("Content-Disposition: form-data; name=\"file2\"; filename=\"" + file2.getName() + "\"\r\n")
                    .append("Content-Type: application/octet-stream\r\n")
                    .append("\r\n")
                    .flush();
            try (FileInputStream inputStream = new FileInputStream(file2)) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
            }

            // 发送结束标志
            writer.append("\r\n")
                    .append("---BOUNDARY--\r\n")
                    .flush();
        }

        // 获取服务器的响应
        int responseCode = connection.getResponseCode();
        // 处理响应结果

        // 关闭连接
        connection.disconnect();
    }
}
