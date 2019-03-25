package com.learn.java8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-31 16:43
 * @description:
 * @modified By:
 */
public class TestDate {

    public static final String format1 = "yyyy-MM-dd HH:mm:ss";
    public static final String format2 = "yyyy-MM-dd";
    public static final String format3 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String timeFormat = "HH:mm:ss";
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat(format1);
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat(format2);
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat(format3);
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(timeFormat);
    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    @Test
    public void test() throws ParseException {
        Date now = new Date();
        Date endDate = dateFormat1.parse("2018-08-31 20:00:00");
        Date beginDate = new Date((endDate.getTime() / 1000L - 15 * 60) * 1000L);
        System.out.println(dateFormat1.format(now));
        System.out.println(dateFormat1.format(endDate));
        System.out.println(dateFormat1.format(beginDate));
    }
}
