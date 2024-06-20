package com.example.req;

import com.example.enums.CheckVisitTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @author yangshengchao on 2023/11/30
 * @desc 图片及摘要对象
 */
@Data
public class MimsUploadMrPictureDTO {
    /**
     * 图片地址
     */
    private String url;
    /**
     * 摘要
     */
    private String digest;
    /**
     * 相似图片信息
     */
    private List<SimilarImageInfoDTO> similarImageInfoDTOList;

    /**
     * 拜访日期识别结果
     */
    private Boolean visitDateRecognitionResult = Boolean.FALSE;
    /**
     * 位置信息识别结果
     */
    private Boolean locationNameRecognitionResult = Boolean.FALSE;
    /**
     * 客户名称识别结果
     */
    private Boolean visitCustomerNameRecognitionResult = Boolean.FALSE;

    /**
     * 根据枚举类型设置对应的字段
     *
     * @param typeEnum 枚举类型
     */
    public void setRecognitionResult(CheckVisitTypeEnum typeEnum) {
        switch (typeEnum) {
            case SHOP_NAME:
                setVisitCustomerNameRecognitionResult(Boolean.TRUE);
                break;
            case SHOP_ADDRESS:
                setLocationNameRecognitionResult(Boolean.TRUE);
                break;
            case DATE:
            case TIME_PERIOD:
                setVisitDateRecognitionResult(Boolean.TRUE);
                break;
            default:
                throw new IllegalArgumentException("Unknown CheckVisitTypeEnum: " + typeEnum);
        }
    }
}








