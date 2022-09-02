package com.example.collect.utils;

import com.example.base.BusinessException;
import com.example.utils.StringFilterUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2022/9/2
 * \* Description: excel等导入时,数据处理
 * \* @author 王祥栋
 */
@Slf4j
public class ExcelUtils {

    /**
     * 读取EXCEL文件 (请自己解析工作薄内容)
     *
     * @param multipartFile 文件
     * @return WORKBOOK
     */
    public static Workbook readExcelFile(MultipartFile multipartFile) {
        Workbook workbook;
        InputStream inputStream;
        try {
            inputStream = multipartFile.getInputStream();
            workbook = WorkbookFactory.create(inputStream);
        } catch (Exception e) {
            log.error("生成excel异常e:{}", e);
            throw new BusinessException("请检查文件格式");
        }
        return workbook;
    }

    /**
     * excel文件导入(仅支持字段类型为BigDecimal和String的类,超出的字段类型不予赋值)
     *
     * @param multipartFile 文件
     * @param start         文件读取起始位置 从0开始
     * @param t
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> importExcelOld(MultipartFile multipartFile, int start, Class<T> t) throws Exception {
        Workbook workbook = readExcelFile(multipartFile);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        if (lastRowNum < start) {
            return new ArrayList<>();
        }
        //获取属性
        List<T> list = new ArrayList<>();
        Field[] fields = t.getDeclaredFields();
        for (int i = start; i <= lastRowNum; i++) {
            T instance = t.newInstance();
            Row row = sheet.getRow(i);
            if (row == null) {
                break;
            }
            int rowNum = row.getRowNum();
            rowNum++;
            for (int j = 0; j < fields.length; j++) {
                Cell cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                String valueString;
                Field field = fields[j];
                Class<?> type = field.getType();
                String name = field.getName();
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Method method;
                try {
                    method = instance.getClass().getMethod(methodName, type);
                    if (type.equals(BigDecimal.class)) {
                        String stringValue = cell.toString();
                        if (StringUtils.isBlank(stringValue)) {
                            continue;
                        }
                        valueString = StringFilterUtils.trim(stringValue).replace("'", "");
                        if (StringUtils.isBlank(valueString)) {
                            continue;
                        }
                        //校验不能大于两位小数
                        BigDecimal amount;
                        try {
                            amount = new BigDecimal(valueString);
                        } catch (NumberFormatException e) {
                            log.error("{}:{}不支持的数额,不是数字,行号:{}", name, valueString, rowNum);
                            throw new BusinessException( "不支持的数额,不是数字,行号:" + rowNum);
                        }
                        method.invoke(instance, amount);
                    } else if (type.equals(String.class)) {
                        cell.setCellType(CellType.STRING);
                        String stringCellValue = cell.getStringCellValue();
                        if (StringUtils.isBlank(stringCellValue)) {
                            continue;
                        }
                        valueString = StringFilterUtils.trim(stringCellValue).replace("'", "");
                        if (StringUtils.isBlank(valueString)) {
                            continue;
                        }
                        method.invoke(instance, valueString);
                    }
                } catch (NoSuchMethodException e) {
                    log.info("NoSuchMethodException:[{}]", methodName);
                    throw new BusinessException("");
                }
            }
            list.add(instance);
        }
        return list;
    }
}
