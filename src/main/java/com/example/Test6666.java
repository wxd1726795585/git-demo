package com.example;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * \* Created with WXD.
 * \* Date:  2022/6/7
 * \* Description:测试
 * \* @author 王祥栋
 */
@Data
public class Test6666 {
    private final static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static void main(String[] args) throws ParseException {
        /*//起步3000,每年增加百分之6
        BigDecimal i=new BigDecimal("3000");
        BigDecimal m=i.multiply(new BigDecimal("12"));
        for (int j = 0; j <38 ; j++) {
            i=i.multiply(new BigDecimal("1.06")).setScale(2,BigDecimal.ROUND_HALF_UP);
            m=m.add(i.multiply(new BigDecimal("12"))).setScale(2,BigDecimal.ROUND_HALF_UP);
            System.out.println("第"+(j+2)+ "年的工资数:"+i);
          //  System.out.println("第"+(j+2)+ "年的工资总数:"+m);
        }*/
        /*Date date=new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        Date date1=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrow = formatter.format(date1);
        String today = formatter.format(date);
        System.out.println(tomorrow);
        System.out.println(today);*/
        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);*/
        /*ArrayList<Object> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));*/
        System.out.println(dateRandom16());

    }
    /**
     * 生成18位随机时间戳
     *
     * @return
     */
    public static String dateRandom16() {

        //获取当前年月日
        String date = yyyyMMdd.format(new Date());

        //获取时间戳后6位
        String timeMillis = String.valueOf(System.currentTimeMillis());
        String fiveNumber = timeMillis.substring(timeMillis.length() - 6);

        //获取随机数后4位
        String tempRandom = String.valueOf(Math.random());
        String number = tempRandom.substring(tempRandom.length() - 4);

        //生成18位随机时间戳数字
        return date + fiveNumber + number;
    }


}
