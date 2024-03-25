package com.example.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/11/20
 * \* Description:
 * \* @author 王祥栋
 */
@Data
public class OnlineTrainReq {
    /**
     * 培训日期
     */
    @NotBlank(message = "培训日期不能为空")
    private String trainDate;

    /**
     * 培训开始时间
     */
    @NotBlank(message = "培训开始时间不能为空")
    private String trainStartTime;

    /**
     * 培训结束时间
     */
    @NotBlank(message = "培训结束时间不能为空")
    private String trainEndTime;

    /**
     * 产品ID
     */
    private Integer productId;

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 培训主题
     */
    @NotBlank(message = "培训主题不能为空")
    @Length(min = 1, max = 30, message = "培训主题最多30个字")
    private String trainSubject;


    /**
     * 培训对象
     */
    @NotBlank(message = "培训对象不能为空")
    @Length(min = 1, max = 30, message = "培训对象最多30个字")
    private String trainObject;

    /**
     * 培训目的
     */
    @NotBlank(message = "培训目的不能为空")
    @Length(min = 1, max = 30, message = "培训目的最多30个字")
    private String trainAim;

    /**
     * 培训课件名称
     */
    private String trainCoursewareName;

    /**
     * 现场照片地址
     */
    @NotEmpty(message = "现场照片地址不能为空")
    @Size(min = 2, max = 4, message = "现场照片介于2-4张")
    private List<String> scenePicturesUrls;
    /**
     * 活动总结
     */
    @NotBlank(message = "活动总结不能为空")
    @Size(min = 10, max = 500, message = "活动总结文字介于10-500之间")
    private String activitySummarize;
    /**
     * 项目ID
     */
    @NotBlank(message = "项目ID不能为空")
    private String projectId;
    /**
     * 主键ID
     */
    private String id;
    /**
     * 证件号码
     */
    private String mrIdentNo;
    /**
     * 手机号码
     */
    private String mrMobile;
    /**
     * 姓名
     */
    private String mrName;
    /**
     * 服务商ID
     */
    private String mrId;
    /**
     * 操作人ID
     */
    private String operatorId;
    /**
     * 操作人姓名
     */
    private String operatorName;
}
