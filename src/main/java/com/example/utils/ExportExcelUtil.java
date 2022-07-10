package com.example.utils;


import java.io.*;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;

/**
 * \* Created with WXD.
 * \* Date:  2022/5/31
 * \* Description:
 * \* @author 王祥栋
 */
public class ExportExcelUtil {


    public static void main(String[] args) throws Exception {
        /*ExportExcelUtil export = new ExportExcelUtil();
        String srcFilePath = "d:/demo.xlsx";
        String fileName = "test_" + System.currentTimeMillis() + ".xlsx";
        String desFilePath = "d:/" + fileName;
        export.exportExcel(srcFilePath, desFilePath);*/
    }


//根据指定的excel模板导出数据

    public void exportExcel(String srcFilePath, String desFilePath,HttpServletResponse response) throws Exception {
//创建Excel文件的输入流对象
        FileInputStream fis = new FileInputStream(srcFilePath);
//根据模板创建excel工作簿
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
//创建Excel文件输出流对象
       // FileOutputStream fos = new FileOutputStream(desFilePath);
//获取创建的工作簿第一页
        XSSFSheet sheet = workBook.getSheetAt(0);
//给指定的sheet命名
        workBook.setSheetName(0, "2016-11-30");
//修改标题
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        //模板固定15行
        int i=16;
        for (int j = 2; j <=i ; j++) {
            XSSFRow row1 = sheet.getRow(j);
            XSSFCell cell1 = row1.getCell(2);
            String stringCellValue = cell1.getStringCellValue();
            cell1.setCellValue("aaaaa");
        }
        workBook.write(getOutputStream("a",response));
//关闭流
        fis.close();
        //fos.flush();
        //fos.close();
        System.out.println("导出成功");
    }

    /**
     * 导出文件时为Writer生成OutputStream.
     * @param fileName 文件名
     * @param response response
     * @return ""
     */
    private static OutputStream getOutputStream(String fileName,
                                                HttpServletResponse response) throws Exception {
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");
            return response.getOutputStream();
        } catch (IOException e) {
            throw new Exception("导出excel表格失败!", e);
        }
    }
}
