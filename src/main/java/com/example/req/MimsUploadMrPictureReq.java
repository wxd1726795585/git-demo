package com.example.req;

import lombok.Data;

/**
 * \* Created with WXD.
 * \* Date:  2023/11/30
 * \* Description:上传图片地址请求参数
 * \* @author 王祥栋
 */
@Data
public class MimsUploadMrPictureReq {
    /**
     * 图片地址
     */
    private String url;
    /**
     * 摘要
     */
    private String digest;
}
