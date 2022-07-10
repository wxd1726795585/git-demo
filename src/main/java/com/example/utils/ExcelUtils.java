package com.example.utils;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.prefs.BackingStoreException;

/**
 * Excel工具类
 */
public class ExcelUtils {

    /**
     * @param sheetName     工作表名，文件名，头部信息
     * @param rowNameList   列名
     * @param list          需要写入的数据
     * @param response      返回
     */
    public static void excelPort(String sheetName, List<String> rowNameList, List<Map<String, String>> list, HttpServletResponse response) {
        try {
            if (list.size() == 0) {
                throw new BackingStoreException("数据为空");
            }
            // 声明一个工作簿
            XSSFWorkbook wb = new XSSFWorkbook();
            // 创建sheet页
            XSSFSheet sheet = wb.createSheet(sheetName);
            sheet.setDefaultColumnWidth(19);

            // 全局加线样式
            CellStyle cellStyle = wb.createCellStyle();
            cellStyle.setBorderBottom(BorderStyle.THIN);//下边框
            cellStyle.setBorderLeft(BorderStyle.THIN);//左边框
            cellStyle.setBorderTop(BorderStyle.THIN);//上边框
            cellStyle.setBorderRight(BorderStyle.THIN);//右边框
            cellStyle.setAlignment(HorizontalAlignment.CENTER);//居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//上下居中

            // 记录标题信息
            TreeMap<String, Integer> headMap = new TreeMap<>();

            // 标题写入
            XSSFRow row = sheet.createRow(0);
            for (int i = 0; i < rowNameList.size(); i++) {
                row.setHeight((short) 450);
                XSSFCell cell = row.createCell(i);
                String headName = rowNameList.get(i);
                cell.setCellValue(headName); //写入列名
                headMap.put(headName, i);
                cell.setCellStyle(cellStyle);
            }

            // 写入内容数据
            int ind = 1;
            for (Map<String, String> map : list) {
                XSSFRow r = sheet.createRow(ind++);
                for (Map.Entry<String, Integer> m : headMap.entrySet()) {
                    String name = m.getKey(); // 列名
                    String value = map.get(name); // value 不一定存在
                    XSSFCell cell2 = r.createCell(m.getValue());
                    if (value != null) {
                        cell2.setCellValue(value);
                    }
                    cell2.setCellStyle(cellStyle);
                }
            }

            // 输出Excel文件
            OutputStream output = response.getOutputStream();
            response.reset();
            // 设置文件头
            response.setHeader("Content-Disposition",
                    "attchement;filename=" + new String((sheetName + ".xls").getBytes("gb2312"), "ISO8859-1"));
            response.setContentType("application/msexcel");
            wb.write(output);
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}