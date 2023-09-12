package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.HygResponse;
import com.example.entity.CopyEntity;
import com.example.service.SqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/6
 * \* Description:
 * \* @author 王祥栋
 */
@RestController
@Slf4j
public class SqlController {
    @Autowired
    private SqlService service;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        String str = "110";
        List<String> strings = Arrays.asList(str.split("-"));
        System.out.println(strings);
    }

    /**
     * 获取出生日期
     *
     * @return 返回字符串类型
     */
    public static String getBirthFromIdCard(String idCard) {
        if (idCard.length() != 18 && idCard.length() != 15) {
            return "请输入正确的身份证号码";
        }
        if (idCard.length() == 18) {
            String year = idCard.substring(6).substring(0, 4);// 得到年份
            String month = idCard.substring(10).substring(0, 2);// 得到月份
            String day = idCard.substring(12).substring(0, 2);// 得到日
            return (year + "-" + month + "-" + day);
        } else if (idCard.length() == 15) {
            String year = "19" + idCard.substring(6, 8);// 年份
            String month = idCard.substring(8, 10);// 月份
            String day = idCard.substring(10, 12);// 得到日
            return (year + "-" + month + "-" + day);
        }
        return null;
    }

    /**
     * 测试sql
     *
     * @param flag 标记
     * @return
     */
    @PostMapping("/test01/sql")
    public HygResponse test01Sql(@RequestParam("flag") Boolean flag) {
        log.info("标记为:-{}-", flag);
        List<CopyEntity> copyEntities = service.test01Sql(flag);
        return HygResponse.Success(copyEntities);
    }

    /**
     * 测试sql---v2
     *
     * @return
     */
    @PostMapping("/test02/sql")
    public HygResponse test02Sql() {
        return service.test02Sql();
    }

    /**
     * 测试sql---v2
     *
     * @return
     */
    @PostMapping("/test03/sql")
    public HygResponse test03Sql() {
        return service.test03Sql();
    }


    /**
     * 测试参数
     *
     * @return
     */
    @GetMapping("/test01/params")
    public HygResponse test01Params() {
        Long delete = stringRedisTemplate.opsForHash().delete("1", "2","3");
        System.out.println(delete);
        //
        //AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        //CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //certAlipayRequest.setServerUrl(URL);
        //certAlipayRequest.setAppId(APPID);
        //certAlipayRequest.setPrivateKey(APP_PRIVATE_KEY);
        //certAlipayRequest.setFormat("JSON");
        //certAlipayRequest.setCharset(CHARSET);
        //certAlipayRequest.setSignType(SIGN_TYPE);
        //certAlipayRequest.setCertPath(app_cert_pathAPP_CERT_PATH);
        //certAlipayRequest.setAlipayPublicCertPath(alipay_cert_path);
        //certAlipayRequest.setRootCertPath(alipay_root_cert_path);
        //DefaultAlipayClient alipayClientWxd = new DefaultAlipayClient(certAlipayRequest); // 提交数据至支付宝时请使用 alipayClient.certificateExecute(request);
        //alipayClient.certificateExecute(certAlipayRequest);
        //    String response = "小程序前端返回的加密信息";
        //    //1. 获取验签和解密所需要的参数
        //    Map<String, String> openapiResult = JSON.parseObject(response,new TypeReference<Map<String, String>>() {}, Feature.OrderedField);
        //    String signType = "RSA2";
        //    String charset = "UTF-8";
        //    String encryptType = "AES";
        //    String sign = openapiResult.get("sign");
        //    String content = openapiResult.get("response");
        //    //判断是否为加密内容
        //    boolean isDataEncrypted = !content.startsWith("{");
        //    boolean signCheckPass = false;
        //    //2. 验签
        //    String signContent = content;
        //    String signVeriKey = "你的小程序对应的支付宝公钥（为扩展考虑建议用appId+signType做密钥存储隔离）";
        //    String decryptKey = "你的小程序对应的加解密密钥（为扩展考虑建议用appId+encryptType做密钥存储隔离）";//如果是加密的报文则需要在密文的前后添加双引号
        //    if (isDataEncrypted) {
        //        signContent = "\"" + signContent + "\"";
        //    } try {
        //        signCheckPass = AlipaySignature.rsaCheck(signContent, sign, signVeriKey, charset, signType);
        //    } catch (AlipayApiException e) {
        //        // 验签异常, 日志
        //    } if (!signCheckPass) {
        //        //验签不通过（异常或者报文被篡改），终止流程（不需要做解密）
        //        throw new Exception("验签失败");
        //    }
        //    //3. 解密
        //    String plainData = null;
        //    if (isDataEncrypted) {
        //        try {
        //            plainData = AlipayEncrypt.decryptContent(content, encryptType, decryptKey, charset);
        //        } catch (AlipayApiException e) {
        //            //解密异常, 记录日志
        //            throw new Exception("解密异常");
        //        }} else {
        //        plainData = content;
        //    }
        //    return HygResponse.Success();
        //}
        //AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        //AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        //request.setGrantType("authorization_code");
        //request.setCode("4b203fe6c11548bcabd8da5bb087a83b");
        //AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
        //if(response.isSuccess()){
        //    System.out.println("调用成功");
        //} else {
        //    System.out.println("调用失败");
        //}
        return null;
    }

    //public String findUserId(String authCode) throws AdminException, AlipayApiException {
    //    AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.url, AlipayConfig.app_id, AlipayConfig.private_key, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.public_key, AlipayConfig.signtype);
    //    AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
    //    request.setGrantType("authorization_code");
    //    request.setCode(authCode);
    //    request.setRefreshToken("201208134b203fe6c11548bcabd8da5bb087a83b");
    //    AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
    //    String accessToken = response.getAccessToken();
    //    if (response.isSuccess()) {
    //        log.info("调用成功");
    //        log.info("支付宝用户唯一id：" + response.getUserId());
    //        log.info("token令牌:" + response.getAccessToken());
    //        //访问令牌。通过该令牌调用需要授权类接口
    //        return response.getUserId();
    //    }
    //    return null;
    //}
}

