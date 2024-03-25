package com.example.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with WXD.
 * \* Date:  2024/2/18
 * \* Description:
 * \* @author 王祥栋
 */
public class StringSpliceTest {
    public static void main(String[] args) {
        String time1 = "09:00";
        String time2 = "10:30";

        int i = compareTimes(time1, time2);
        System.out.println(i);
    }

    /**
     * 比较两个HH:mm格式的字符串
     *
     * @param timeStr1 时间1
     * @param timeStr2 时间2
     * @return
     */
    public static int compareTimes(String timeStr1, String timeStr2) {
        // 将时间字符串解析为 LocalTime 对象
        LocalTime time1 = LocalTime.parse(timeStr1);
        LocalTime time2 = LocalTime.parse(timeStr2);

        // 比较两个 LocalTime 对象
        return time1.compareTo(time2);
    }


    public static String findMinTime(List<String> timeStrings) {
        if (timeStrings.isEmpty()) {
            return null;
        }

        LocalTime minTime = LocalTime.MAX;

        for (String timeStr : timeStrings) {
            LocalTime time = LocalTime.parse(timeStr);
            if (time.isBefore(minTime)) {
                minTime = time;
            }
        }

        return minTime.toString();
    }

    public static String findMaxTime(List<String> timeStrings) {
        if (timeStrings.isEmpty()) {
            return null;
        }

        LocalTime maxTime = LocalTime.MIN;

        for (String timeStr : timeStrings) {
            LocalTime time = LocalTime.parse(timeStr);
            if (time.isAfter(maxTime)) {
                maxTime = time;
            }
        }

        return maxTime.toString();
    }

    public static String checkTime(String timeStr) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour > 22 || (hour == 22 && minute > 0)) {
            return "22:00";
        } else {
            return timeStr;
        }
    }

    public static List<String> generateTimePoints(String start, String end) {
        start = processTime(start, 1);
        end = processTime(checkTime(end), 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.parse(start, formatter);
        LocalTime endTime = LocalTime.parse(end, formatter);

        // 确保开始时间早于或等于结束时间
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("The start time should be earlier than or equal to the end time.");
        }

        List<String> timePoints = new ArrayList<>();
        LocalTime currentTime = startTime;

        // 循环直到达到或超过结束时间
        while (!currentTime.isAfter(endTime)) {
            timePoints.add(currentTime.format(formatter));
            currentTime = currentTime.plusMinutes(30);
        }

        return timePoints;
    }


    public static String processTime(String timeStr, int type) {
        LocalTime time = LocalTime.parse(timeStr);
        int minute = time.getMinute();

        if (minute % 30 == 0) {
            // 如果分钟部分为 00 或 30，则直接返回该时间字符串
            return timeStr;
        } else {
            // 如果分钟部分不是 00 或 30，则根据类型进行处理
            if (type == 1) {
                // 类型为 1
                if (minute > 30) {
                    return time.withMinute(30).toString();
                } else {
                    return time.withMinute(0).toString();
                }
            } else {
                // 类型为 2
                if (minute > 30) {
                    time = time.plusHours(1);
                    time = time.withMinute(0);
                } else {
                    time = time.withMinute(30);
                }
                return time.toString();
            }
        }
    }

    public static String processTime1(String timeStr, int type) {
        String[] parts = timeStr.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour == 23) {
            return "00:00";
        }

        if (minute == 0 || minute == 30) {
            return timeStr;
        }

        if (type == 1) {
            if (minute > 30) {
                return String.format("%02d:30", hour);
            } else {
                return String.format("%02d:00", hour);
            }
        } else if (type == 2) {
            if (minute > 30) {
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
                return String.format("%02d:00", hour);
            } else {
                return String.format("%02d:30", hour);
            }
        } else {
            return "Invalid type";
        }
    }

    public static List<String> getAllDatesOfMonth(String yearMonth) {
        List<String> dates = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(yearMonth + "-01");
        LocalDate endDate = startDate.plusMonths(1).minusDays(1); // 获取该月的最后一天

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dates.add(currentDate.format(formatter));
            currentDate = currentDate.plusDays(1);
        }
        return dates;
    }


    public static List<String> generateTimePoints(List<String> inputList) {
        List<String> resultList = new ArrayList<>();

        for (String timeRange : inputList) {
            String[] times = timeRange.split(":");
            int startHour = Integer.parseInt(times[0]);
            int startMinute = Integer.parseInt(times[1].substring(0, 2)); // Remove any additional characters

            LocalTime startTime = LocalTime.of(startHour, startMinute);

            resultList.add(startTime.toString()); // Add the start time
            while (startTime.getMinute() != 30) { // Increment minutes until it reaches 30
                startTime = startTime.plusMinutes(1);
                resultList.add(startTime.toString());
            }
        }

        return resultList;
    }
}
