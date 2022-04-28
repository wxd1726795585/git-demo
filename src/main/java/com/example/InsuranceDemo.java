package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import com.alibaba.fastjson.JSON;
import com.example.res.XiaoChuiInsuredRes;
import com.example.utils.HttpClientUtilDemo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class InsuranceDemo {

    private static final String from = "hyg";
    private static final String account = "hyg";
    private static final String passwords = "hyg123";
    private static final String url = "http://47.107.77.196:8010/TpaPlatForm/restfull/tpasop/riderExternalInterface";

    /**
     * 骑手增减操作
     * @throws Exception
     */
    public static void riderOperate() throws Exception{
        //请求消息JSON
        JSONObject reqJson = new JSONObject();
        //头部消息
        JSONObject header = new JSONObject();
        //来源渠道
        header.put("from", from);
        //请求类型
        //增加
        header.put("requestType", "riderOperate");

        //消息体
        JSONObject body = new JSONObject();
        //骑手数组
        JSONArray riderArray = new JSONArray();
        //骑手JSON
        JSONObject riderObj = new JSONObject();
          //riderObj.put("riderId", "36e55f0cb2ef469db5703b41857f9373");
        //保单号
        riderObj.put("policyNo", "hyg测试保单");
        //站点编号
        riderObj.put("sourceNo", "hyg");
        riderObj.put("identityCard", "211103197711052517");
        riderObj.put("riderName", "测试人");
        //1增加  2删除
        riderObj.put("operationStatus", "1");
        riderObj.put("opType", "1");//暂时只支持T+1类型
        riderObj.put("officeHours", "");
        riderObj.put("closingTime", "");
        riderObj.put("remark", "测试");

        //骑手JSON
        /*JSONObject riderObj1 = new JSONObject();
        riderObj1.put("riderId", "");
        riderObj1.put("policyNo", "hyg测试保单");
        riderObj1.put("sourceNo", "hyg");
        riderObj1.put("identityCard", "130626199209241216");
        riderObj1.put("riderName", "肖金浩");
        riderObj1.put("operationStatus", "1");
        riderObj1.put("opType", "1");//暂时只支持T+1类型
        riderObj1.put("officeHours", "");
        riderObj1.put("closingTime", "");
        riderObj1.put("remark", "测试");*/

        riderArray.add(riderObj);
        //riderArray.add(riderObj1);
        //设置骑手数组
        body.accumulate("riderArray", riderArray);
        //签名
        header.put("sign", md5(body.toString() + "hyg" + account + passwords));
        //设置头部消息
        reqJson.put("header", header);
        //设置消息体
        reqJson.put("body", body);
        //String post = HttpUtils.post(url, reqJson);
        String doPost = HttpClientUtilDemo.doPost(url, reqJson, "UTF-8");
        XiaoChuiInsuredRes xiaoChuiInsuredRes = com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSONObject.toJSONString(JSON.parseObject(doPost)), XiaoChuiInsuredRes.class);
        System.out.println(xiaoChuiInsuredRes);
    }

    /**
     * 骑手增减列表查询
     * @throws Exception
     */
    public static void queryRiderInfo() throws Exception{
        //请求消息JSON
        JSONObject reqJson = new JSONObject();
        //头部消息
        JSONObject header = new JSONObject();
        //来源渠道
        header.put("from", from);
        //请求类型
        header.put("requestType", "queryRiderInfo");
        //消息体
        JSONObject body = new JSONObject();
        body.put("policyNo", "hyg测试保单");
        body.put("sourceNo", "hyg");
        //body.put("identityCard", "3333");
        //body.put("riderName", "4444");
        body.put("currentPage", "1");
        body.put("quantity","10");
        //签名
        header.put("sign", md5(body.toString() + from + account + passwords));
        //设置头部消息
        reqJson.put("header", header);
        //设置消息体
        reqJson.put("body", body);
        String doPost = HttpClientUtilDemo.doPost(url, reqJson, "UTF-8");
        System.out.println(doPost);
    }

    /**
     * 未承保骑手删除
     * @throws Exception
     */
    public static void riderDelete() throws Exception{
        //请求消息JSON
        JSONObject reqJson = new JSONObject();
        //头部消息
        JSONObject header = new JSONObject();
        //来源渠道
        header.put("from", from);
        //请求类型
        header.put("requestType", "riderDelete");
        //消息体
        JSONObject body = new JSONObject();
        //骑手数组
        JSONArray riderArray = new JSONArray();
        //骑手JSON
        JSONObject riderObj = new JSONObject();
        riderObj.put("riderId", "36e55f0cb2ef469db5703b41857f9373");
        riderArray.add(riderObj);
        //设置骑手数组
        body.accumulate("riderArray", riderArray);
        //签名
        header.put("sign", md5(body.toString() + from + account + passwords));
        //设置头部消息
        reqJson.put("header", header);
        //设置消息体
        reqJson.put("body", body);
        String reponseBody = HttpClientUtilDemo.doPost(url, reqJson, "UTF-8");
        //XiaoChuiInsuredRes idcardBean = com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSONObject.toJSONString(JSON.parseObject(reponseBody)), XiaoChuiInsuredRes.class);
        System.out.println(reponseBody);
    }

    /**
     * md5加密
     * @param plainText
     * @return
     */
    public static String md5(String plainText) throws Exception{
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes("UTF-8"));
            byte[] b = md.digest();
            StringBuffer buf = new StringBuffer("");

            for (int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        //增加或者删除
       riderOperate();
        //查询信息
	// queryRiderInfo();
		//删除未承保的信息
	//	riderDelete();
    }

}
