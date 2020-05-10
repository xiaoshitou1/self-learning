package com.study.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws InterruptedException {
//        Date date = new Date(116, 2, 18);
//        System.out.println(date);

//        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                for (int x = 0; x < 100; x++) {
//                    Date parseDate = null;
//                    try {
//                        parseDate = sdf.parse("20160505");
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(parseDate);
//                }
//            }).start();
//        }

//        testLocalDate();
//        testLocalTime();
//        combineLocalDateAndTiime();
//        testInstant();
//        testDuration();
//        testPeriod();
//        testDateFormat();
        testDateParse();
    }


    private static void testLocalDate() {
        LocalDate localDate = LocalDate.of(2016, 11, 13);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());

        localDate.get(ChronoField.DAY_OF_MONTH);
    }

    private static void testLocalTime() {
        LocalTime time = LocalTime.now();
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    private static void combineLocalDateAndTiime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.toString());
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    private static void testInstant() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000L);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println(between.toMillis());
    }
    
    private static void testDuration(){
        LocalTime time = LocalTime.now();
        LocalTime beforeTime = time.minusHours(1);
        Duration duration = Duration.between(time, beforeTime);
        System.out.println(duration.toHours());
    }

    private static void testPeriod() {
        Period period = Period.between(LocalDate.of(2014, 1, 10), LocalDate.of(2016, 1, 10));
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.getYears());
    }

    private static void testDateFormat(){
        LocalDate localDate = LocalDate.now();
        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String forma1 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(format);
        System.out.println(forma1);
    }

    private static void testDateParse(){
        String date = "20161113";
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse);
        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date1 = "2016-11-13";
        LocalDate parse1 = LocalDate.parse(date1, myDateTimeFormatter);
        System.out.println(parse1);
    }
}
