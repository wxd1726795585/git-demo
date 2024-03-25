package com.example.impl;

import com.BusinessCode;
import com.example.HygResponse;
import com.example.entity.CopyEntity;
import com.example.entity.UpperAgentRes;
import com.example.mapper.Test02Mapper;
import com.example.req.PersonReq;
import com.example.service.SqlService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * \* Created with WXD.
 * \* Date:  2023/6/6
 * \* Description:
 * \* @author 王祥栋
 */
@Service
@Slf4j
public class SqlServiceImpl implements SqlService {
    @Autowired
    private Test02Mapper test02Mapper;

    public static void main(String[] args) throws Exception {
        String dataMasking = getDataMasking("123456789");

        System.out.println(dataMasking + "长度:" + dataMasking.length());
    }

    /**
     * 功能描述：身份证号脱敏
     * 脱敏规则：保留前六后三, 适用于15位和18位身份证号
     *
     * @param idNumber 身份证号
     * @return
     */
    public static String desensitizedIdNumber(String idNumber) {
        if (StringUtils.isNotBlank(idNumber)) {
            return StringUtils.left(idNumber, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(idNumber, 3), StringUtils.length(idNumber), "*"), "******"));
        }
        return idNumber;
    }


    /**
     * 数据脱敏
     *
     * @param accountNumber 收款账号(中间4位脱敏)
     * @return
     */
    private static String getDataMasking(String accountNumber) {
        // 小于5位或为空直接返回
        if (StringUtils.isBlank(accountNumber) || accountNumber.length() < 5) {
            return accountNumber;
        }
        return StringUtils.left(accountNumber, 1).concat("****").concat(StringUtils.right(accountNumber, accountNumber.length() - 5));
    }

    public static DateTimeFormatter createFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern, Locale.getDefault()).withZone(ZoneId.systemDefault());
    }

    public static String maskBankCard(String cardNum) {
        return StringUtils.isBlank(cardNum) ? "" : StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }


    /**
     * 通过秒毫秒数判断两个时间的间隔的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 校验护照
     * 规则： 14/15开头 + 7位数字, G + 8位数字, P + 7位数字, S/D + 7或8位数字,等
     * 样本： 141234567, G12345678, P1234567
     *
     * @param identNo
     * @return
     */
    private static Boolean passportVerification(String identNo) {
        String regex = "^([a-zA-z]|[0-9]){5,17}$";
        if (identNo.matches(regex)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 校验军官证
     * 规则： 军/兵/士/文/职/广/（其他中文） + "字第" + 4到8位字母或数字 + "号"
     * 样本： 军字第2001988号, 士字第P011816X号
     *
     * @param identNo
     * @return
     */
    private static Boolean certificateOfficersVerification(String identNo) {
        String regex = "[\\u4E00-\\u9FA5](字第)([0-9a-zA-Z]{4,8})(号?)$";
        if (identNo.matches(regex)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static boolean checkname(String name) {
        int n = 0;
        for (int i = 0; i < name.length(); i++) {
            n = (int) name.charAt(i);
            if (!(19968 <= n && n < 40869)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试sql
     *
     * @param flag 标记
     */
    @Override
    public List<CopyEntity> test01Sql(Boolean flag) {
        List<CopyEntity> list = test02Mapper.test01Sql(flag);
        return list;
    }


    @Override
    public HygResponse test02Sql() {
        PersonReq personReq = new PersonReq();
        personReq.setGender("男");
        personReq.setName("张三");
        List<Map<String, Object>> list = test02Mapper.test02Sql(personReq);
        log.info("获取到的数据:-{}-", list);
        boolean a = list.contains("a");
        System.out.println(a);
        return HygResponse.Success(list);
    }

    @Override
    public HygResponse test03Sql(String id) {
        int count = test02Mapper.test04Sql(id);
        log.info("更改的条数:-{}-", count);
        return HygResponse.Success();
    }

    /**
     * 测试sql---v4
     *
     * @param id ID
     * @return
     */
    @Override
    @Transactional(timeout = 30, rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public HygResponse test04Sql(String id) {
        List<CopyEntity> list = test02Mapper.selectCopyList();
        return HygResponse.Success(list);
    }


    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30, isolation = Isolation.READ_COMMITTED)
    public HygResponse test05Sql(String id) {
        log.info("修改的是id为:-{}-的数据", id);
        Integer count = test02Mapper.updateById(id);
        log.info("修改成功条数:-{}-", count);
        List<Map<String, Object>> list = test02Mapper.selectById(id);
        return HygResponse.Success(list);
    }

    /**
     * 测试sql---v6
     *
     * @return
     */
    @Override
    public HygResponse test06Sql() {
        //Integer counts = test02Mapper.selectCopyCounts();
        //CopyEntity copyEntity = test02Mapper.getCopyEntityById();
        List<CopyEntity> copyEntityList = test02Mapper.getCopyEntityList();
        if (Objects.isNull(copyEntityList)) {
            log.info("是空的");
        } else {
            log.info("不是空的");
        }
        log.info("返回的数据结果:-{}-", copyEntityList);
        return HygResponse.Success(copyEntityList);
    }

    /**
     * 测试sql---v7
     *
     * @return
     */
    @Override
    public HygResponse test07Sql(String cooperatorId) {
        List<UpperAgentRes> agentList = test02Mapper.doFindUpperAgentIds(cooperatorId);
        if (Objects.isNull(agentList)){
            return HygResponse.Error("返回结果为null");
        }

        if (CollectionUtils.isEmpty(agentList)) {
            return HygResponse.Error(BusinessCode.WARN, "商户不存在");
        }
        UpperAgentRes upperAgentRes = agentList.get(0);
        log.info("属性值:{}",upperAgentRes);
        return HygResponse.Success(agentList);
    }
}

@AllArgsConstructor
@Data
class ABC {
    private Integer age;
    private String name;
}

