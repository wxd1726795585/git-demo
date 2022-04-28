package com.example.apidemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.AESUtils;
import com.example.utils.HttpUtils;
import com.example.utils.RSAUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/23
 * \* Description:openApi接口测试
 * \* @author 王祥栋
 */
public class ApiTest {
    /**
     * AES私钥
     */
    private String privateKeyAes="q0oxCftJ4YESnVp9YkRUiQ==";
    /**
     * RSA私钥
     */
    private String privateKeyRSA="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALzyZWm0XmB82v2wjolyBHsjWuALrcbeDQrHJH73DalpJG5x+e5vJX4qS59+JL5bnnjG+utCy1vOeMwp1SfggdYVxzJm7MsQ0eJQapDA6mywD3v8fyt52WwBfXJancZCjgH/nv0a0x1qip9+kM1EKGX69pbGp+ITQbn8R+aVnanfAgMBAAECgYEAtEzybR4K+TPrnS3/tjSxBfhE3YsHdr+p3mEN+IIz7TdB5oqontg9BNnDdBzhXyz6WfI2uozwlVi/eMNqfjUEbusTqlUss874//51mj2dDceV632/Bb/9jazG4w+HiiLIWBvHp6HrBod1XfNnyXp0G9LiZmeJ4mQc0TpzNxfiqEECQQDujwbEq4FRRzaVQmhVWfMd9r579ep8yOP3biU23pUaTjq4Pd+6POXLJTX31h4kXnpmsIo9Lc4pf1T9DOdhq1yxAkEAysLP2H1kpu+2Cm727s4iQvyWvwBDMePdR/4HAgWkiR2zTU7HOhz/lrOy7Y8uzL/djP6URRkBKjPgpgoKVS/TjwJBAN5mhN7RLUxC4cYhFPeNVjP3Fvql9qfC+ZRxIUyYEdVmXSPquyr7HxhWZovZGFy7n80ghKAolezmAquvXf8WLOECQBKiWsWzqHdrGljVH96MlTuAyT3egU5peaGvJ+e4qwlq8FqPfeHKXnb0JuKMQSnSDENz9h5vkNrXD7NSwuZXUeMCQDozc1rHIACWNfOvWVOQP0dmYuil/Tsv1GdzTkokcUs7uWWrmEXoTZN/kZZMlaK3eDgAEFGAVjZkfdZEy0+jck0=";

    /**
     * 查询余额
     * @throws Exception
     */
    @Test
    public void  selectBalance() throws Exception {
        Map<String, Object> map = new HashMap<>(8);
        map.put("cooperatorId", "C956134827948511232");
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        //map.put("workerName", "王宇通");
        //map.put("workerMobile", "17600296020");
        //map.put("workerType", 1);
        //map.put("idCard", "130527198909012234");
        String s1 = RSAUtils.sortParam(map);
        System.out.println("排序之后,签名之前:"+ s1);
        String sign = RSAUtils.sign(s1.getBytes(), privateKeyRSA);
        System.out.println("签名:"+sign);
        map.put("sign", sign);
        String jsonString = JSON.toJSONString(map);
        System.out.println("带上签名之后:" + jsonString);
        String s = AESUtils.encrypt2Hex(jsonString, privateKeyAes);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cooperatorId", "C956134827948511232");
        jsonObject.put("businessBody", s);
        System.out.println("最后的请求参数"+ jsonObject.toJSONString());
        String res = HttpUtils.postJson("https://boapi.hvyogo.com/api/cooperator/balance", jsonObject.toJSONString());
//        String res = HttpUtils.postJson("http://localhost:30091/api/add/worker", jsonObject.toJSONString());
        System.out.println(res);
        Map map1 = JSON.parseObject(res, Map.class);
        if (map1.get("data") != null) {
            String data = String.valueOf(map1.get("data"));
            String s2 = AESUtils.decryptByHex(data, privateKeyAes);
            Map map2 = JSON.parseObject(s2, Map.class);
            System.out.println(map2);
        }
    }

    /**
     * 自由职业者信息列表分页查询接口
     * @throws Exception
     */
    @Test
    public void  selectWorkerPage() throws Exception {
        Map<String, Object> map = new HashMap<>(8);
        map.put("cooperatorId", "C956134827948511232");
        map.put("timestamp", String.valueOf(System.currentTimeMillis()));
        map.put("pageNum", "1");
        map.put("pageSize", "20");
        //map.put("workerType", 1);
        //map.put("idCard", "130527198909012234");
        String s1 = RSAUtils.sortParam(map);
        System.out.println("排序之后,签名之前:"+ s1);
        String sign = RSAUtils.sign(s1.getBytes(), privateKeyRSA);
        System.out.println("签名:"+sign);
        map.put("sign", sign);
        String jsonString = JSON.toJSONString(map);
        System.out.println("带上签名之后:" + jsonString);
        String s = AESUtils.encrypt2Hex(jsonString, privateKeyAes);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cooperatorId", "C956134827948511232");
        jsonObject.put("businessBody", s);
        System.out.println("最后的请求参数"+ jsonObject.toJSONString());
        String res = HttpUtils.postJson("https://boapi.hvyogo.com/api/v2/hire/worker/findPage", jsonObject.toJSONString());
//        String res = HttpUtils.postJson("http://localhost:30091/api/add/worker", jsonObject.toJSONString());
        System.out.println(res);
        Map map1 = JSON.parseObject(res, Map.class);
        if (map1.get("data") != null) {
            String data = String.valueOf(map1.get("data"));
            String s2 = AESUtils.decryptByHex(data, privateKeyAes);
            Map map2 = JSON.parseObject(s2, Map.class);
            System.out.println(map2);
        }
    }



}
