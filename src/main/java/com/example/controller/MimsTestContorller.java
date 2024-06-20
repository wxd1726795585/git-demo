package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * \* Created with WXD.
 * \* Date:  2024/5/18
 * \* Description:
 * \* @author 王祥栋
 */
@Slf4j
@RestController
public class MimsTestContorller {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public int getFileCountFromZip(@RequestPart("file") MultipartFile file) throws IOException {
        log.info("接收到文件：{}", file.getOriginalFilename());
        int fileCount = 0;

        try (ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream(), Charset.forName("UTF-8"))) {
            ZipEntry entry;
            while ((entry =  zipInputStream.getNextEntry()) != null) {
                log.info("压缩文件中包含文件：{}", entry.getName());
                if (!entry.isDirectory()) {
                    fileCount++;
                } else {
                    // 如果有目录，则抛出异常
                    throw new IllegalArgumentException("Zip文件中包含目录！");
                }
            }
        }

        return fileCount;
    }
    }
