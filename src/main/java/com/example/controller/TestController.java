package com.example.controller;

import com.example.docx.WordTemplate;
import com.example.utils.PdfUtils;
import com.service.TestService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;


@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    private StringRedisTemplate template;
    @Autowired(required = false)
    private TestService testService;
    @PostMapping("/test006")
    public void testDemo001(@RequestParam("date")Date date){
        System.out.println(date);
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
     * 交易月份
     */
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date occurMonth;
}
