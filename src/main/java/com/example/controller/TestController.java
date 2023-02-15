package com.example.controller;

import com.example.base.BusinessException;
import com.example.bean.Student;
import com.example.collect.utils.ExcelUtils;
import com.example.docx.WordTemplate;
import com.example.utils.ExportExcelUtil;
import com.example.utils.PdfUtils;
import com.service.TestService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CountDownLatch;


@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired(required = false)
    private TestService testService;


    @PostMapping("/daorushuju")
    public void demo06(@RequestBody Test006 test006) {
        List<String> idList = test006.getIdList();
        log.info("id集合:-{}-",idList);
    }



    @GetMapping("import/excel")
    public void demo06(@RequestPart(value = "file")MultipartFile multipartFile) throws Exception {
        if (null==multipartFile || StringUtils.isBlank(multipartFile.getOriginalFilename())){
            throw new BusinessException("输入文件不正确");
        }
        List<Student> students1 = ExcelUtils.importExcelOld(multipartFile, 1, Student.class);
        System.out.println(students1);
    }


    @GetMapping("/demo02")
    public void demo01(HttpServletResponse response)throws Exception{
        redisTemplate.opsForHash().put("a","b",String.valueOf(1112.550));
        String o = (String) redisTemplate.opsForHash().get("a", "b");
        BigDecimal bigDecimal = new BigDecimal(o);
        System.out.println(bigDecimal);
        //2022-07-08 练习redis的常用api
        //-------------String类型的
        /*redisTemplate.opsForValue().set("name","wangxiangdong");
        String name = redisTemplate.opsForValue().get("name");
        log.info("获取name的值:{}",name);
        //批量插入
        HashMap<String, String> map = new HashMap<>();
        map.put("gender","男");
        map.put("age","24");
        redisTemplate.opsForValue().multiSet(map);
        log.info("获取gender值:{},获取年龄的值:{}",redisTemplate.opsForValue().get("gender"),redisTemplate.opsForValue().get("age"));
        //插入时候判断是否有该值  没有则插入 返回true 有则返回false
        Boolean name1 = redisTemplate.opsForValue().setIfAbsent("name", "1");
        System.out.println(name1);
        //自增 或者 自减
        redisTemplate.opsForValue().set("decrement","10");
        redisTemplate.opsForValue().set("increment","10");
        redisTemplate.opsForValue().decrement("decrement");
        redisTemplate.opsForValue().increment("decrement");


        //-----------List类型的
        //往左边插入数据
        redisTemplate.opsForList().leftPush("test","1");
        //往右边插入数据
        redisTemplate.opsForList().rightPush("test","2");
        //往左边批量插入数据
        redisTemplate.opsForList().leftPushAll("test","3","4","5");
        redisTemplate.opsForList().leftPushAll("test",Arrays.asList("6","7","8"));
        //往右边批量插入数据
        redisTemplate.opsForList().rightPushAll("test","10","11","12");
        redisTemplate.opsForList().rightPushAll("test",Arrays.asList("13","14","15"));
        //弹出左边的第一个数据
        String leftPop = redisTemplate.opsForList().leftPop("test");
        log.info("弹出左边的第一个数据:{}",leftPop);
        //弹出右边的第一个数据
        String rightPop = redisTemplate.opsForList().rightPop("test");
        log.info("弹出右边的第一个数据:{}",rightPop);
        //获取list集合长度
        redisTemplate.opsForList().size("test");

        //-----------Hash类型的
        //插入数据
        redisTemplate.opsForHash().put("hash","name","王祥栋");
        //获取数据
        String hashName =(String) redisTemplate.opsForHash().get("hash", "name");
        log.info("获取的name名称:{}",hashName);
        //批量插入数据
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("gender","男");
        map1.put("age","24");
        redisTemplate.opsForHash().putAll("hash",map1);
        //获取长度
        Long hash = redisTemplate.opsForHash().size("hash");
        log.info("hash的长度:{}",hash);
        //获取所有的键值对
        Map<Object, Object> hash1 = redisTemplate.opsForHash().entries("hash");
        log.info("获取所有的键值对:{}",hash1);
        //获取所有的KEY值
        Set<Object> hash2 = redisTemplate.opsForHash().keys("hash");
        log.info("获取所有的KEY值:{}",hash2);
        //获取所有的value值
        List<Object> hash3 = redisTemplate.opsForHash().values("hash");
        log.info("获取所有的value值:{}",hash3);*/
        //redisTemplate.opsForValue().set("test","10");
    }
    @GetMapping("/test006")
    public void testDemo001(HttpServletResponse response)throws Exception{
        /*HashMap<String, Object> map = new HashMap<>();
        //商户名称
        map.put("cooperatorName","a");
        //行业类别
        map.put("industryCategory","a");
        //业务覆盖省份
        map.put("businessCoverageProvinces","a");
        //公司在职员工数
         map.put("companyEmployees","");


        //公司年收入规模
        map.put("income","c");
        //公司网址/APP
        map.put("companyWebSite","web");
        //自由职业者岗位
        map.put("freelanceJobs","f");
        //场景描述
        map.put("sceneDesc","s");
        //开票内容
        map.put("invoiceContent","i");
        //工作地点
        map.put("workerPlace","word");
        //单人单月月收入范围
        map.put("monthIncomeRange","最高单人单月不超过100");
        //自由职业者数量
            map.put("numberOfFreelancers","");
        //单月总下发额
            map.put("totalMonthlyPayment","");
        //费用发放周期
            map.put("expenseReleaseCycle","");
        //真实性证明
            map.put("expenseReleaseCycle1","");
        TemplateExcelUtils.downLoadExcel("测试数据", "a.xls", map, response);*/
        ExportExcelUtil export = new ExportExcelUtil();
        String srcFilePath = "d:/hezuopinggu.xlsx";
        String fileName = "test_" + System.currentTimeMillis() + ".xlsx";
        String desFilePath = "d:/" + fileName;
        export.exportExcel(srcFilePath, desFilePath,response);

    }


    @GetMapping("/demo01")
    public void testDemo() throws Exception{
        //老板需要等待15个员工会议室开会
        final CountDownLatch latch = new CountDownLatch(15);
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            final int timer = random.nextInt(1000);
            new Thread(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在赶路");
                    //模仿每个员工走自己线程需要的时间
                    Thread.sleep(20000 + timer);
                    //调用latch的countDown方法使计数器-1；一共15个
                    latch.countDown();
                    System.out.println("子线程" + Thread.currentThread().getName() + "到会议室了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            System.out.println("领导等待员工会议室开会...");
            //主线程阻塞等待计数器归零
            latch.await();
            System.out.println("员工都来了,会议开始");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }


    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("D:\\健康测评.docx");
        XWPFDocument docx = new XWPFDocument(inputStream);
        //设置参数
        WordTemplate wordTemplate = new WordTemplate(docx);
        HashMap<String, String> replaceMap = new HashMap<>();
        replaceMap.put("cooperatorName","测试商户");
        replaceMap.put("totalScore","15");
        wordTemplate.replaceTag(replaceMap);
        for (int i = 0; i <=20 ; i++) {
            //获取所有表格
            List<XWPFTable> tables = docx.getTables();
            //这里简单取第一个表格
            XWPFTable table = tables.get(0);
            //获取表头，第一个是表头,所以需要+1
            XWPFTableRow header = table.getRow(0);
            if (i==0){
                //获取到刚刚插入的行
                XWPFTableRow row = table.getRow(i + 1);
                //设置单元格内容
                XWPFParagraph xwpfParagraph = row.getCell(2).getParagraphs().get(0);
                XWPFRun run = xwpfParagraph.createRun();
                for (int j = 0; j < 3; j++) {
                    XWPFRun run1 = xwpfParagraph.createRun();
                    //设置字体大小
                    run1.setFontSize(15);
                    //设置文字内容
                    run1.setText("");
                    run1.addBreak();

                }
                run.setFontSize(15);
                run.setText("证件照占比10.0000%20.0000%");
            }
            if (i<=19){
                //获取到刚刚插入的行
                XWPFTableRow row = table.getRow(i + 1);
                //设置单元格内容
                XWPFParagraph xwpfParagraph = row.getCell(3).getParagraphs().get(0);
                XWPFRun run = xwpfParagraph.createRun();
                run.setFontSize(15);
                run.setText("aaa");

            }
            if (i==20){
                XWPFTableRow row2 = table.getRow(i + 1);
                XWPFParagraph xwpfParagraph = row2.getCell(0).getParagraphs().get(0);
                XWPFRun run = xwpfParagraph.createRun();
                run.setText("".trim());
                run.setFontSize(15);
                run.addBreak();
                XWPFRun run1 = xwpfParagraph.createRun();
                run1.setText("bbbb".trim());
                run1.setFontSize(15);
                run1.addBreak();
                XWPFRun run2 = xwpfParagraph.createRun();
                run2.setText("bbbb".trim());
                run2.setFontSize(15);
                run2.addBreak();
                XWPFRun run3 = xwpfParagraph.createRun();
                run3.setText("bbbb".trim());
                run3.setFontSize(15);
                run3.addBreak();
            }

        }
        File wordFile = new File("D:\\ceshi666.docx");
        OutputStream os = new FileOutputStream(wordFile);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        wordTemplate.write(bos);
        bos.flush();
        bos.close();
        inputStream.close();




}
    private static  void word2pdf(String filePath, String pdfBdUrl) {
        try {
            PdfUtils.word2pdf(filePath, pdfBdUrl);
        } catch (Exception e) {
            log.error("转pdf失败", e);
        }
    }

}
@Data
class Test006{
    /**
     * id集合
     */
  private List<String> idList;
}
