package com.example.test;

import jdk.internal.util.Preconditions;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LotterySimulator {
    public static List<String> findMondays(String yearMonth) {
        List<String> mondays = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(yearMonth + "-01");

        while (date.getMonthValue() == Integer.parseInt(yearMonth.split("-")[1])) {
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondays.add(date.format(formatter));
            }
            date = date.plusDays(1);
        }

        return mondays;
    }

    public static void main(String[] args) {
        String yearMonth = "2024-02";
        List<String> mondays = findMondays(yearMonth);
        System.out.println("所有周一的日期列表：");
        for (String monday : mondays) {
            System.out.println(monday);
        }
    }

    private static List<LocalTime> calculateIntervals(LocalTime startTime, LocalTime endTime) {
        List<LocalTime> intervals = new ArrayList<>();
        LocalTime current = startTime;
        while (current.isBefore(endTime)) {
            intervals.add(current);
            current = current.plusMinutes(30); // 每次增加30分钟
        }
        intervals.add(endTime); // 包含结束时间
        return intervals;
    }


}
@Data
class StudentA{
    private String name;
    private List<String> age;
}
@Data
@Builder
class StudentB{
    private String name;
    private String age;
}
