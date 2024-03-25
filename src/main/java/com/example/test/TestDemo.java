package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/4
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class TestDemo {
    private static final List<String> REGION_SUFFIX = Arrays.asList("(市辖区)", "（市辖区）");

    public static void main(String[] args) {
        String str1= "222222";
       String str = "11111" + (str1.contains("2")?"3":str1);
        System.out.println(str);
        }




    public static int findLastChineseCharacterIndex(String str) {
        // 正则表达式匹配汉字
        String regex = "[\u4e00-\u9fa5]";

        // 从字符串末尾开始查找最后一个汉字的索引
        for (int i = str.length() - 1; i >= 0; i--) {
            if (String.valueOf(str.charAt(i)).matches(regex)) {
                return i;
            }
        }

        // 如果字符串中没有汉字，则返回-1
        return -1;
    }

    public static String processParam(String param1, String param2) {
        if (param1.matches(".*\\d[a-zA-Z]$")) { // 如果以数字加字母结尾
            String lastChar = param1.substring(param1.length() - 1);
            return param2 + lastChar;
        } else if (param1.matches(".*[a-zA-Z]$")) { // 如果以字母结尾
            String lastChar = param1.substring(param1.length() - 1);
            return param2 + lastChar;
        } else {
            return param2;
        }
    }




    public static void test002() {
        int i = 1 / 0;
    }

    public static int upload(String strURL, File[] allFile) {
        int status = 200;

        for (int i = 0; i < allFile.length; ++i) {
            String localFile = allFile[i].getAbsolutePath();

            if (!(allFile[i].exists())) {
                continue;

            }

            long startPos = 0L;

            HttpClient headclient = new DefaultHttpClient();

            HttpHead httphead = new HttpHead(strURL);

            try {
                httphead.addHeader("Content-Type", "application/octet-stream");

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                headclient.getConnectionManager().shutdown();

            }

            HttpURLConnection conn = null;

            try {
                conn = (HttpURLConnection) new URL(strURL).openConnection();

                RandomAccessFile fis = new RandomAccessFile(new File(localFile), "r");

                if (startPos < fis.length()) {
                    conn.setRequestMethod("PUT");

                    conn.setDoOutput(true);

                    conn.setDoInput(true);

                    conn.setRequestProperty("Content-Type", "application/octet-stream");

                    conn.setRequestProperty("File-Name", allFile[i].getName());

                    OutputStream os = conn.getOutputStream();

                    int rn = 0;

                    byte[] buf = new byte[4096];

                    while ((rn = fis.read(buf, 0, 4096)) > 0) {
                        os.write(buf, 0, rn);

                    }

                    os.close();

                    status = conn.getResponseCode();

                }

                fis.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                try {
                    conn.getResponseCode();

                } catch (IOException e1) {
                    e1.printStackTrace();

                }

                e.printStackTrace();

            }

        }

        return status;

    }


}


