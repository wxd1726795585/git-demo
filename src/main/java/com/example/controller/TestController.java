package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.HygResponse;
import com.example.base.BusinessException;
import com.example.bean.Student;
import com.example.collect.utils.ExcelUtils;
import com.example.docx.WordTemplate;
import com.example.req.Demo02Req;
import com.example.req.HealthAssessmentItemDto;
import com.example.req.InvoiceApprovalReq;
import com.example.res.ApiH5SignCallbackRes;
import com.example.service.AllKindsTestService;
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
import javax.validation.Valid;
import java.io.*;
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
    @Autowired
    private AllKindsTestService allKindsTestService;


    /**
     * 阅读状态标记
     */
    private static final String READING_STATE_FLAG = "READING_STATE_FLAG";

    @GetMapping("import/excel")
    public void demo06(@RequestPart(value = "file") MultipartFile multipartFile) throws Exception {
        if (null == multipartFile || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new BusinessException("输入文件不正确");
        }
        List<Student> students1 = ExcelUtils.importExcelOld(multipartFile, 1, Student.class);
        System.out.println(students1);
    }

    @GetMapping("/zhuanhuan")
    public void demo009() throws Exception {
        ApiH5SignCallbackRes apiH5SignCallbackRes = new ApiH5SignCallbackRes();
        apiH5SignCallbackRes.setCallbackUrl("https://wmpos.marubi.cn/k/integration/crm/hyg/signing-callback");
        apiH5SignCallbackRes.setC("wmbh");
        apiH5SignCallbackRes.setAgreeState("2");
        apiH5SignCallbackRes.setAgreeDesc("签约成功");
        apiH5SignCallbackRes.setTimes(0);
        apiH5SignCallbackRes.setWorkerId("W1078348279688736768");
        apiH5SignCallbackRes.setWorkerMobile("15031309551");
        apiH5SignCallbackRes.setCooperatorId("C954411691225923584");
        redisTemplate.opsForHash().put("H5_SIGN_OAPI_CALLBACK", "W1078348279688736768", JSON.toJSONString(apiH5SignCallbackRes));
    }


    @PostMapping("/demo02")
    public HygResponse demo01() {
        for (int i = 0; i < 10; i++) {
            allKindsTestService.testAsync();
        }
        return HygResponse.Success("222");
    }

    @PostMapping("/demo03")
    public HygResponse demo03(@RequestBody @Valid Demo02Req demo02Req) {
        log.info("参数:{}", demo02Req);
        return HygResponse.Success("222");
    }

    @PostMapping("/test008")
    public void testDemo008(String topic, String tag, String paramJsonStr) {
        log.info("手动发送MQ，Topic：{}，Tag：{}，Param：{}", topic, tag, paramJsonStr);
        InvoiceApprovalReq invoiceApprovalReq = JSON.parseObject(paramJsonStr, InvoiceApprovalReq.class);

        log.info("内容体:-{}-", invoiceApprovalReq);
    }


    @GetMapping("/test006")
    public void testDemo001(HttpServletResponse response) throws Exception {
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
        export.exportExcel(srcFilePath, desFilePath, response);

    }


    @GetMapping("/demo01")
    public void testDemo() throws Exception {
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


    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("D:\\健康测评.docx");
        XWPFDocument docx = new XWPFDocument(inputStream);
        //设置参数
        WordTemplate wordTemplate = new WordTemplate(docx);
        HashMap<String, String> replaceMap = new HashMap<>();
        replaceMap.put("cooperatorName", "测试商户");
        replaceMap.put("totalScore", "15");
        wordTemplate.replaceTag(replaceMap);
        for (int i = 0; i <= 20; i++) {
            //获取所有表格
            List<XWPFTable> tables = docx.getTables();
            //这里简单取第一个表格
            XWPFTable table = tables.get(0);
            //获取表头，第一个是表头,所以需要+1
            XWPFTableRow header = table.getRow(0);
            if (i == 0) {
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
            if (i <= 19) {
                //获取到刚刚插入的行
                XWPFTableRow row = table.getRow(i + 1);
                //设置单元格内容
                XWPFParagraph xwpfParagraph = row.getCell(3).getParagraphs().get(0);
                XWPFRun run = xwpfParagraph.createRun();
                run.setFontSize(15);
                run.setText("aaa");

            }
            if (i == 20) {
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

    private static void word2pdf(String filePath, String pdfBdUrl) {
        try {
            PdfUtils.word2pdf(filePath, pdfBdUrl);
        } catch (Exception e) {
            log.error("转pdf失败", e);
        }
    }

}

@Data
class Test006 {
    /**
     * 交易月份
     */
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date occurMonth;
}
