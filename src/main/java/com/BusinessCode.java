package com;

/**
 * \* Created with WXD.
 * \* Date:  2023/4/17
 * \* Description:
 * \* @author 王祥栋
 */
public enum BusinessCode {

    SUCCESS("000000", "success"),
    WARN("100000", "前端直接提示的, 指导用户进一步操作的信息(自定义)"),
    WARN_ALERT("100100", "前端直接提示的, 指导用户进一步操作的信息"),
    WARN_DATA("100200", "前端弹窗,data为弹窗展示数据"),
    FATAL("500000", "服务器异常, 请稍候重试"),
    SERVICE_RESTART("500001", "服务重启中, 请稍候重试"),
    SERVICE_BUSYNESS("500002", "系统繁忙, 请稍候重试"),
    ERROR_AUTH("400101", "无权访问"),
    ERROR_PARAMS("400201", "参数非法"),
    ERROR_SLIDER_CAPTCHA_INIT_ERR("400211", "滑块验证初始化错误"),
    ERROR_RISK("400301", "异常请求"),
    ERROR_OPERATE("400401", "异常操作"),
    ERROR_SIGN("400501", "验签失败"),
    ERROR_TIMESTAMP("400601", "时间戳异常"),
    ERROR_IP_WHITE_LIST("400701", "请先配置白名单"),
    USER_NOT_LOGIN("20100", "登录获取更好体验~"),
    USER_NON_EXISTENT("20101", "用户不存在"),
    USER_LOGIN_TIME_OUT("20102", "登录超时"),
    USER_STATUS_ERROR("20103", "用户状态异常"),
    SMS_CODE_IS_ERROR("200504", "验证码不正确"),
    NO_LOGIN_MSG("100001", "返回前端错误码，获取此码不请求后端呢接口（全民营销）"),
    ALREADY_EXISTS("100002", "记录已存在"),
    PARAM_VALIDATION("100003", "联系电话错误(与历史联系方式不符)"),
    MOBILE_ALREADY_EXISTS("100004", "当前手机号已经被其他自由职业者注册"),
    FACE_WARN("100500", "前端H5页面直接展示失败原因"),
    NOT_IDENTITY_CARD("300100", "当前自由职业者证件类型非身份证"),
    NOT_VERIFIED_SUCCESS("300200", "当前自由职业者未实名认证成功"),
    ALREADY_EXIST_ID_PHOTO("300300", "当前自由职业者已存在证件照"),
    OCR_FAILED("300400", "图片认证失败");

    private final String code;
    private final String desc;

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    private BusinessCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
