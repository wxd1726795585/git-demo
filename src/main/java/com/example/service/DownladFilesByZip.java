/*
package com.example.service;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

*/
/**
 * \* Created with WXD.
 * \* Date:  2022/1/10
 * \* Description:
 *//*

@Slf4j
public class DownladFilesByZip {
    public void downloadAllFile(HttpServletResponse response, String processInstanceId) {
        String downloadName = "xxx附件.zip";
        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(downloadName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new HrmsException("下载文件名编码时出现错误.", e);
        }

        OutputStream outputStream = null;
        ZipOutputStream zos = null;
        try {
            outputStream = response.getOutputStream();
            zos = new ZipOutputStream(outputStream);
            // 将文件流写入zip中
            downloadTolocal(zos,processInstanceId);

        } catch (IOException e) {
            log.error("downloadAllFile-xxx下载全部附件失败，processInstanceId=[{}],错误信息=[{}]",processInstanceId,e);
        }finally {
            if(zos != null) {
                try {
                    zos.close();
                } catch (Exception e2) {
                    log.info("关闭输入流时出现错误",e2);
                }
            }
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    log.info("关闭输入流时出现错误",e2);
                }
            }

        }

    }

    private void downloadTolocal(ZipOutputStream zos,String processInstanceId) throws IOException {
        Map<String, String> pm = new HashMap<String, String>();
        pm.put("processInstanceId", processInstanceId);
        //获取文件信息（此处为业务代码，可根据自己的需要替换）
        List<Map<String,String>> fileInfoList = this.findByStatement("getAllFileInfo",pm);

        for (Map<String, String> map : fileInfoList) {
            String fileId = map.get("fileId");
            //文件名称（带后缀）
            String fileName = map.get("fileName");
            InputStream is = null;
            BufferedInputStream in = null;
            byte[] buffer = new byte[1024];
            int len;
            //创建zip实体（一个文件对应一个ZipEntry）
            ZipEntry entry = new ZipEntry(fileName);
            try {
                //获取需要下载的文件流
                is = ossFileManager.getFile(fileId);
                in = new BufferedInputStream(is);
                zos.putNextEntry(entry);
                //文件流循环写入ZipOutputStream
                while ((len = in.read(buffer)) != -1 ) {
                    zos.write(buffer, 0, len);
                }
            } catch (Exception e) {
                logger.info("xxx--下载全部附件--压缩文件出错",e);
            }finally {
                if(entry != null) {
                    try {
                        zos.closeEntry();
                    } catch (Exception e2) {
                        logger.info("xxx下载全部附件--zip实体关闭失败",e2);
                    }
                }
                if(in != null) {
                    try {
                        in.close();
                    } catch (Exception e2) {
                        logger.info("xxx下载全部附件--文件输入流关闭失败",e2);
                    }
                }
                if(is != null) {
                    try {
                        is.close();
                    }catch (Exception e) {
                        logger.info("xxx下载全部附件--输入缓冲流关闭失败",e);
                    }
                }


            }

        }
    }

}
*/
