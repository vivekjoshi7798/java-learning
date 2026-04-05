package com.vivek.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateOperationSolution {

    public static void main() {

        printLocalDate();
        printLocalTime();
        printLocalDateTime();
    }

    private static void printLocalDateTime() {
        System.out.println(LocalDate.now());
    }

    private static void printLocalTime() {
        System.out.println(LocalTime.now());
    }

    private static void printLocalDate() {
        System.out.println(LocalDateTime.now());
    }
}
