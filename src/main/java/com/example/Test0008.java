package com.example;

import com.example.utils.PdfUtils;
import lombok.Data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/3/2
 * \* Description:
 * \* @author 王祥栋
 */
public class Test0008{
    public static void main(String[] args) throws Exception{
        BigDecimal bigDecimal = new BigDecimal("0.200000000000");
        BigDecimal bigDecimal1 = new BigDecimal("0.2000000");
        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
    private static  void word2pdf(String filePath, String pdfBdUrl) {
        try {
            PdfUtils.word2pdf(filePath, pdfBdUrl);
        } catch (Exception e) {
        }
    }
    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowDate 当前时间
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return
     * @author szh
     */
    public static boolean isEffectiveDate(String nowDate, String startDate, String endDate) throws ParseException {
        String format = "HH:mm:ss";
        Date startTime = new SimpleDateFormat(format).parse(startDate);
        Date endTime = new SimpleDateFormat(format).parse(endDate);
        Date nowTime = new SimpleDateFormat(format).parse(nowDate);

        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        long now = nowTime.getTime();
        long begin = startTime.getTime();
        long end = endTime.getTime();

        if (now > begin && now < end) {
            return true;
        } else {
            return false;
        }
    }

}
@Data
class A{
    private List<String> list;
}
