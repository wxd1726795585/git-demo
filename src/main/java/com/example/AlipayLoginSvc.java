//package com.example;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.alibaba.fastjson.parser.Feature;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.internal.util.AlipayEncrypt;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.alipay.api.request.AlipayOpenAppQrcodeCreateRequest;
//import com.alipay.api.request.AlipaySystemOauthTokenRequest;
//import com.alipay.api.response.AlipayOpenAppQrcodeCreateResponse;
//import com.alipay.api.response.AlipaySystemOauthTokenResponse;
//import com.ijpay.alipay.AliPayApi;
//import com.ijpay.alipay.AliPayApiConfig;
//import com.ijpay.alipay.AliPayApiConfigKit;
//import org.apache.commons.lang3.StringUtils;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.Map;
//
///**
// * @author yz
// * @className AlipayLoginSvc
// * @description
// * @date 2020/7/31 9:56
// */
//@RequestMapping("/alipayLogin")
//@Service
//@Validated
//public class AlipayLoginSvc {
//    private final static Logger LOGGER = LoggerFactory.getLogger(AlipayLoginSvc.class);
//
//    /**
//     * 解密成功MSG
//     */
//    private final static String DECRYPT_SUCCESS_MSG = "Success";
//    @Autowired
//    private AliPayMiniAppConfig aliPayMiniAppConfig;
//
//    /**
//     * AES接口加密秘钥
//     */
//    @NotEmpty
//    @Value("${alipay.miniapp.aesEncryptKey}")
//    private String miniAesEncryptKey;
//
//    /**
//     * @param oauthTokenRequest {@link AlipaySystemOauthTokenRequest}
//     * @return {@link OutDTO<AlipaySystemOauthTokenResponse>}
//     * @description 通过code换取授权访问令牌
//     * @author yz
//     * @date 2020/7/31 10:36
//     */
//    public OutDTO<AlipaySystemOauthTokenResponse> codeToToken4Mini(@RequestBody AlipaySystemOauthTokenRequest oauthTokenRequest) {
//        if (StringUtils.isAnyBlank(oauthTokenRequest.getCode(), oauthTokenRequest.getGrantType())) {
//            return Response.invalid(null);
//        }
//
//        try {
//            //设置支付配置
//            AliPayApiConfigKit.setThreadLocalAliPayApiConfig(aliPayMiniAppConfig.getConfig());
//            AlipaySystemOauthTokenResponse response = AliPayApi.certificateExecute(oauthTokenRequest);
//
//            if (response.isSuccess()) {
//                return Response.success(response);
//            }
//        } catch (AlipayApiException e) {
//            LOGGER.error("支付宝code换取token授权失败！", e);
//        }
//        return Response.error("授权失败！", null);
//    }
//
//    /**
//     * @param encryptedStrMap 加密字符串Map
//     * @return {@link org.jservice.message.simplejson.dt.out.OutDTO<java.lang.String>}
//     * @description 解密手机号
//     * @author yz
//     * @date 2020/8/1 10:50
//     */
//    public OutDTO<String> decryptPhoneNo(@RequestBody Map<String, String> encryptedStrMap) {
//        String encryptedStr = encryptedStrMap.get("encryptedStr");
//        if (StringUtils.isBlank(encryptedStr)) {
//            return Response.invalid();
//        }
//        AliPayApiConfig config;
//        try {
//            config = aliPayMiniAppConfig.getConfig();
//        } catch (AlipayApiException e) {
//            LOGGER.error("获取配置失败！", e);
//            return Response.error("系统错误！");
//        }
//        try {
//            String decryptStr = doDecrypt(encryptedStr, config);
//            //转为map
//            Map decryptMap = JSON.parseObject(decryptStr, Map.class);
//            if (DECRYPT_SUCCESS_MSG.equals(decryptMap.get("msg"))) {
//                return Response.success((String) decryptMap.get("mobile"));
//            } else {
//                LOGGER.error("手机号获取失败！{}", decryptMap.get("msg"));
//                return Response.error("手机号获取失败！");
//            }
//        } catch (Exception e) {
//            return Response.error(e.getMessage());
//        }
//    }
//
//    /**
//     * @param encryptedStr 加密字符串
//     * @param config       支付宝配置
//     * @return {@link String}
//     * @description 解密方法
//     * @author yz
//     * @date 2020/8/1 10:47
//     */
//    private String doDecrypt(String encryptedStr, AliPayApiConfig config) throws Exception {
//        //1. 获取验签和解密所需要的参数
//        Map<String, String> openapiResult = JSON.parseObject(encryptedStr, new TypeReference<Map<String, String>>() {
//                },
//                Feature.OrderedField);
//        String content = openapiResult.get("response");
//        String sign = openapiResult.get("sign");
//
//        //2.判断报文是否加密
//        //若报文没有加密，则 response 的值为 json，而加密情况 response 是 Base64 字符串。
//        //所以可以通过 response 的值是否是括号符开头：”{“来进行判断 。
//        boolean isDataEncrypted = !content.startsWith("{");
//
//        //3.验签
//        boolean signCheckPass;
//        String signContent = isDataEncrypted ? "\"" + content + "\"" : content;
//        //如果是加密的报文则需要在密文的前后添加双引号
//        try {
//            signCheckPass = AlipaySignature.rsaCertCheck(signContent, sign, config.getAliPayCertPath(), "UTF-8",
//                    "RSA2");
//        } catch (AlipayApiException e) {
//            LOGGER.error("验签失败", e);
//            throw new BusiException("验签失败!");
//        }
//        if (!signCheckPass) {
//            //验签不通过（异常或者报文被篡改），终止流程（不需要做解密）
//            throw new BusiException("验签失败!");
//        }
//
//        //4. 解密
//        try {
//            //未加密直接返回原内容,否则解密后返回
//            return isDataEncrypted ? AlipayEncrypt.decryptContent(content, "AES", miniAesEncryptKey,
//                    config.getCharset()) : content;
//        } catch (AlipayApiException e) {
//            //解密异常, 记录日志
//            LOGGER.error("解密异常", e);
//            throw new BusiException("解密异常");
//        }
//    }
//
//    /**
//     * 生成支付宝小程序码
//     *
//     * @author yz
//     * @date 2020/8/4 9:25
//     */
//    public OutDTO<String> getAlipayQrCode(@RequestBody Map<String,String> bizContentMap) throws AlipayApiException {
//        AliPayApiConfigKit.setThreadLocalAliPayApiConfig(aliPayMiniAppConfig.getConfig());
//        AlipayOpenAppQrcodeCreateRequest request = new AlipayOpenAppQrcodeCreateRequest();
//        String bizContent = JSON.toJSONString(bizContentMap);
//        request.setBizContent(bizContent);
//        AlipayOpenAppQrcodeCreateResponse response = AliPayApi.certificateExecute(request);
//
//        if(response.isSuccess()){
//            return Response.success(response.getQrCodeUrl());
//        } else {
//            return Response.error("调用失败");
//        }
//    }
//}