package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/4
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class TestDemo  {

    public static void test002(){
        int i = 1/0;
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


