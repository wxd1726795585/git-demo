/*
package com.example;




import com.aspose.words.Row;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

*/
/**
 * \* Created with WXD.
 * \* Date:  2022/5/21
 * \* Description:
 * \* @author 王祥栋
 *//*

public class Text010 {
    public static void main(String[] args)  {
        Integer i=1;
        switch (i){
            case 1:
                System.out.println("1111");
            case 2:
                System.out.println("iiiiiii");
        }


    }
    public static void doExportLongArrearsData() {
        // 要导出的数据

        List<String> list = Lists.newArrayList();
        // 导出列  列数
        int colNum = 9;
        int[] colWidth = new int[colNum];
        for (int i = 0; i < colNum; i++) {
            colWidth[i] = 23;
        }
        // 从XX行开始为数据内容  excel 第一行为0
        int startRow = 5;
        // 　2003版本的Excel （xls） ---- HSSFWorkbook
        //    2007版本以及更高版本 (xlsx)---- XSSFWorkbook
        XSSFWorkbook workbook = null;
        try {
            // 此处linux和windows通用   /files/cq.xlsx 在resource目录下  视情况而定

            */
/**
             *   特殊说明： this.getClass().getResourceAsStream
             *   如果fileUrl路径前不加 / 那么会读取类文件夹下的文件。加了才会读取resource下面的文件
             *   exp: this.getClass().getResourceAsStream("/files/cq.xlsx") ==>读取resource下面的文件
             *   this.getClass().getResourceAsStream("files/cq.xlsx") ==>读取当前类下的文件
             *   源码：
             *     private String resolveName(String name) {
             *         if (name == null) {
             *             return name;
             *         }
             *         if (!name.startsWith("/")) {
             *             Class<?> c = this;
             *             while (c.isArray()) {
             *                 c = c.getComponentType();
             *             }
             *             String baseName = c.getName();
             *             int index = baseName.lastIndexOf('.');
             *             if (index != -1) {
             *                 name = baseName.substring(0, index).replace('.', '/')
             *                     +"/"+name;
             *             }
             *         } else {
             *             name = name.substring(1);
             *         }
             *         return name;
             *     }
             *//*

            //  InputStream inputStream = this.getClass().getResourceAsStream("/files/cq.xlsx");
            FileInputStream inputStream = new FileInputStream( new File("C:\\Users\\usaer\\Desktop\\buss.xlsx"));
            workbook = new XSSFWorkbook(inputStream);

            // 获取sheet
            XSSFSheet sheetAt = workbook.getSheetAt(0);

            // 动态列  修改表头名 、修改模板数据等操作
            // 自定义参数
            int k = 1;
            updateCellLoad(workbook,sheetAt,k);

            // 填充数据
            fillBodyData( sheetAt,startRow,list,colWidth);

            // 设置单元格宽度 (不设置的话，就是模板的宽度)
            if (null != colWidth) {
                for (int i = 0; i < colWidth.length; i++) {
                    sheetAt.setColumnWidth(i, colWidth[i] * 256 + 184);
                }
            }

            // 输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // excel工作空间写入流
            workbook.write(byteArrayOutputStream);
            InputStream wrap = Streams.wrap(byteArrayOutputStream.toByteArray());
            // 写到本地
            writeToLocal("C:\\Users\\usaer\\Desktop\\buss_"+k+".xlsx",wrap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 关闭流
            if (null != workbook)
                try {
                    workbook.close();
                }
                catch (IOException e) {

                }
        }
    }


    public static void updateCellLoad(XSSFWorkbook workbook, Sheet sheet, int k) {
        try {
            //设置行 指定行
            Row titlerow=sheet.getRow(2);
            //根据索引获取对应的列   如果合并单元格 有可能第一列就找不到  根据需求修改参数值
            Cell cell=titlerow.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            //设置列的类型是字符串
            cell.setCellType(CellType.STRING);
            cell.setCellValue(k==1?"1":"0");
            String titleValue=cell.getStringCellValue();
            System.out.println(titleValue);


            // 设置行 指定行修改数据和样式 有可能第一行就找不到  根据需求修改参数值
            CellStyle style1 = workbook.createCellStyle();
            // 自动换行
            style1.setWrapText(true);
            Row row1 = sheet.createRow(1);
            // 行高度
            row1.setHeight(Short.parseShort("1000"));
            Cell row1Cell = row1.createCell(0, CellType.STRING);
            row1Cell.setCellStyle(style1);
            StringBuilder sb = new StringBuilder();
            sb.append("条件1:").append("ABC").append("\r\n");
            sb.append("条件2:").append("DEF").append("\r\n");
            sb.append("条件3:").append("GHI").append("\r\n");
            row1Cell.setCellValue(sb.toString());

        } catch (EncryptedDocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    private static void fillBodyData(Sheet sheet, int startRow, List<NutMap> bodyList, int[] colWidth) {

        // 碰到 时间、金额等需要转换的  在setCellValue 里面操作
        for (int rowNum = 0; rowNum < bodyList.size(); rowNum++) {
            NutMap map = bodyList.get(rowNum);
            Row row = sheet.createRow(rowNum + startRow);
            int colNum = 0;
            // comm
            Cell accountNumberCell = row.createCell(colNum++, CellType.STRING);
            String accountNumber = map.getString("comm");
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(accountNumber));
            accountNumberCell.setCellValue(accountNumber);
            // a
            Cell accountNameCell = row.createCell(colNum++, CellType.STRING);
            String accountName = map.getString("a");
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(accountName));
            accountNameCell.setCellValue(accountName);
            // b
            Cell mobileCell = row.createCell(colNum++, CellType.STRING);
            String mobile = map.getString("b");
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(mobile));
            mobileCell.setCellValue(mobile);

            // c
            Cell addressCell = row.createCell(colNum++, CellType.STRING);
            String address = map.getString("c");
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(address));
            addressCell.setCellValue(address);

            // d
            Cell meterNoCell = row.createCell(colNum++, CellType.STRING);
            String meterNo = map.getString("d");
            meterNoCell.setCellValue(meterNo);
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(meterNo));

            // e
            Cell uncollectedNumberCell = row.createCell(colNum++, CellType.STRING);
            String uncollectedNumber = map.getString("e");
            uncollectedNumberCell.setCellValue(uncollectedNumber);
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(uncollectedNumber));

            // f
            Cell uncollectedDosageCell = row.createCell(colNum++, CellType.STRING);
            String uncollectedDosage = map.getString("f");
            uncollectedDosageCell.setCellValue(uncollectedDosage);
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(uncollectedDosage));

            // g
            Cell uncollectedDosageCell1 = row.createCell(colNum++, CellType.STRING);
            String uncollectedDosage1 = map.getString("g");
            uncollectedDosageCell1.setCellValue(uncollectedDosage1);
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(uncollectedDosage1));

            // h
            Cell uncollectedDosageCell2 = row.createCell(colNum++, CellType.STRING);
            String uncollectedDosage2 = map.getString("h");
            uncollectedDosageCell2.setCellValue(uncollectedDosage2);
            colWidth[colNum - 1] = Math.max(colWidth[colNum - 1], Strings.charLength(uncollectedDosage2));
        }
    }

    private static void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index = 0;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) > 0) {
            downloadFile.write(bytes, 0, index);
        }
        downloadFile.close();
        input.close();
    }

}
*/
