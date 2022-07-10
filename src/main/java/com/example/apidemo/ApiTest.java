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
     * AES私钥1
     */
    private String privateKeyAes1="gPW7L04jwIfddoXMOAY5sw==";
    /**
     * RSA私钥1
     */
    private String privateKeyRSA1="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC91ZVgPkYEGZwhJZ/wp7bItCl00LmEvK1Z1ij9A4b3Gg11BDU2ExRxE4SHtTpRxe+0ZY2kLqubuhK7RrRPTQhlNsEjA+x+osTDZPur+NcGi6fCt7F1eJINO6lWODM8ADpPMXCistTuvu3jhO6reO3yQA+2cTtfM8+rZsHsz+x6+wIDAQAB";

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
    @Test
    public void  jieMi() throws Exception {
        String str="EE1E9E83C542EFD88A0572D2D3AB005EB8C0A18A4420A4129869718D1AF92B1BA97C35285FC40EEC2FA29D54009784235351B4A67F468E096477053682E0C064F2F5192EE52F98EE7BBBEB956881581A54AB09DCBF1B73B241A843EDB06CD1FCEBBFC90166974BF94A245294AA767D3ADDCC0D454127753DFEB0EBCDFDCC6C7CAF68517FCCB626884088610230E1F552678C70DCE93BA537F77ACB6467C7797D156512D55C0551AF468FB7F308287E0A109A6F87D1E53DF8AFDC9BE10671CD3A4D750F2B74649952219725006F5B83AD102AB030A83A5D9641DBD4C360648742ABAA2C53A2C1FA80067AB94DCF82173C46516A7F592DAF2694B31C056BC247AE49BAE892B2877F45DCA597FDBDA7A94F65499C9500574F5A941FF5E2E2CCD6197E01C0A36E8F1110E95700C43423E97FD5EA7C7A17D250C7CD45695733F17A63DB4980E00C0A9C6AE727FB1915C2BC1B43AF874A2596CFF2475D7D66062E9C0C7893D6E7766378C2651EA860CF1E43B2AAFE7F1AC0E8BDEDBBC9E7ADDDFC76987DB214CD6E4447EC5108BBF1ADCE7808A19C7264E88DEE807DAA672874B1882B4094B01730C409E325BB2B03819AA05129E082FB8FFBB7DED818D6D8392BFDBD84B9F41A29EBE225B06C6BC5287757FE538FFE7769E84A55D7EA1C3E59B58CDF094710ECC18870ACAF7661071E276A4D170E6B21ABD759829603DBA83DF996D5EA813AD30DC6696390C20C5E89C684912C69D36A07D193E0F9FEA2A83C9CF6203B3ECDBF763068DF15D8C2B54C35AA7DACEDBC4F2490C29E538529C919CE2F03";
        String s = AESUtils.decryptByHex(str, privateKeyAes1);
        System.out.println(s);
        Map map2 = JSON.parseObject(s, Map.class);
        System.out.println(map2);
        String sign = String.valueOf(map2.get("sign"));
        map2.remove("sign");
        String sortStr = RSAUtils.sortParam(map2);
        System.out.println(sortStr);
        boolean verify = RSAUtils.verify(sortStr.getBytes(), privateKeyRSA1, sign);
        System.out.println(verify);

    }


}
