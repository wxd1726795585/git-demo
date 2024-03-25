package com.example.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * \* Created with WXD.
 * \* Date:  2024/1/11
 * \* Description:
 * \* @author 王祥栋
 */
@Data
@Slf4j
public class AAAAAAAAAAAA {
    private BigDecimal serviceCharge;

    public static void main(String[] args) throws Exception{
        // 模拟数据源
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("{{username}}", "John Doe");
        dataMap.put("{{email}}", "john.doe@example.com");
        dataMap.put("{{phone}}", "+1234567890");
        dataMap.put("{{phones}}", "发票号\n1234567890");

        // 读取Excel模板
        FileInputStream inputStream = new FileInputStream("D:\\template\\服务结算明细表模板.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        // 创建一个单元格样式用于居中和自动换行
        // CellStyle cellStyle = workbook.createCellStyle();
        // cellStyle.setWrapText(true); // 设置自动换行
        // cellStyle.setAlignment(HorizontalAlignment.CENTER); // 设置水平居中
        // cellStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设置垂直居中

        // 遍历单元格，寻找占位符并替换
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    String cellValue = cell.getStringCellValue();
                    if (dataMap.containsKey(cellValue)) { // 检查是否是占位符
                        cell.setCellValue(dataMap.get(cellValue)); // 替换占位符
                    }
                }
            }
        }

        // 保存填充后的Excel文件
        FileOutputStream outputStream = new FileOutputStream("D:\\template\\/filled_template.xlsx");
        workbook.write(outputStream);

        // 关闭资源
        workbook.close();
        outputStream.close();
    }


    /**
     * 四舍五入计算分片区间
     *
     * @param a 总数
     * @param b 分片阈值
     * @return 区间;例如：[a,b]
     */
    public static List<String> catCountList(int a, int b) {
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        BigDecimal divide = bigDecimal.divide(bigDecimal1, 0, RoundingMode.UP);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < divide.intValue(); i++) {

            if (a > (i + 1) * b) {
                log.info("第" + (i + 1) + "次取值，取值范围为：" + ((i * b) + "," + b));
                list.add((i * b) + "," + b);
            } else {
                log.info("第" + (i + 1) + "次取值，取值范围为：" + (i * b) + "," + (a - i * b));
                list.add((i * b) + "," + (a - i * b));
            }

        }
        return list;
    }


    // 生成所有时间（从07:00到22:00，隔半个小时）
    public static List<String> generateAllTimes() {
        List<String> allTimes = new ArrayList<>();
        int hours = 7;
        int minutes = 0;
        while (hours <= 22) {
            allTimes.add(String.format("%02d:%02d", hours, minutes));
            minutes += 30;
            if (minutes >= 60) {
                minutes = 0;
                hours++;
            }
        }
        return allTimes;
    }

    // 找出可用时间段
    public static List<String> findAvailableTimes(List<String> allTimes, List<String> occupiedTimes) {
        List<String> availableTimes = new ArrayList<>();
        boolean occupied = false;
        for (int i = 0; i < allTimes.size(); i++) {
            String startTime = allTimes.get(i);
            if (!occupiedTimes.contains(startTime) && !occupied) {
                occupied = true;
                availableTimes.add(startTime);
            } else if (occupiedTimes.contains(startTime) && occupied) {
                occupied = false;
                availableTimes.add(allTimes.get(i - 1));
            }
        }
        // 添加最后一个时间段
        if (occupied) {
            availableTimes.add(allTimes.get(allTimes.size() - 1));
        }
        return availableTimes;
    }
}

@Data
@AllArgsConstructor
class Student6 {
    String name;
    int score;

    public static void main(String[] args) {
        List<Student6> students = Arrays.asList(
                new Student6("Alice", 95),
                new Student6("Bob", 85),
                new Student6("Charlie", 70),
                new Student6("Dave", 65),
                new Student6("Eve", 55),
                new Student6("AiLiWenSi", 95)
        );

        Map<Integer, List<Student6>> collect = students.stream().collect(Collectors.groupingBy(Student6::getScore));
        System.out.println(collect);

        Map<String, List<String>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        s -> {
                            if (s.getScore() >= 90) return "优秀";
                            else if (s.getScore() >= 80) return "良好";
                            else if (s.getScore() >= 60) return "及格";
                            else return "不及格";
                        },
                        Collectors.mapping(Student6::getName, Collectors.toList())
                ));
        System.out.println(studentsByGrade);
    }
}


