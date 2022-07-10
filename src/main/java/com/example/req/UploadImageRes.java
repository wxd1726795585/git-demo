package com.example.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: wyb
 * @date: 2019/7/23 15:36
 * @description:
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadImageRes {

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件地址
     */
    private String fileUrl;
}
