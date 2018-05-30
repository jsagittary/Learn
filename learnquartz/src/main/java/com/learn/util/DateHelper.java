package com.learn.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static final String format1 = "yyyy-MM-dd HH:mm:ss";
    public static final String format2 = "yyyy-MM-dd";
    public static final String format3 = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String timeFormat = "HH:mm:ss";
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat(format1);
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat(format2);
    public static SimpleDateFormat dateFormat3 = new SimpleDateFormat(format3);
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(timeFormat);

    static public boolean isSameDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return DateUtils.isSameDay(date1, date2);
    }

    static public boolean isSameDate(Calendar cal1, Calendar cal2) {
        return DateUtils.isSameDay(cal1, cal2);
    }

    static public boolean isBeforeOneDay(Calendar cal1) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return DateUtils.isSameDay(cal1, calendar);
    }

    static public boolean isToday(Date date) {
        return DateUtils.isSameDay(date, new Date());
    }

    static public String displayDateTime() {
        return dateFormat3.format(new Date());
    }

    static public int getNowMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH + 1);
    }

    static public String displayNowDateTime() {
        return dateFormat1.format(new Date());
    }

    static public String formatDateTime(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    static public String formatDateMiniTime(Date date) {
        return dateFormat3.format(date);
    }

    static public Date getInitDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2008, 1, 1);
        return calendar.getTime();
    }

    static public long getServerTime() {
        return Calendar.getInstance().getTime().getTime() / 1000;
    }

    static public long dvalue(Calendar calendar, Date date) {
        if (date == null || calendar == null) {
            return 0;
        }
        long dvalue = (calendar.getTimeInMillis() - date.getTime()) / 1000;
        return dvalue;
    }

    // cdTime --秒数
    static public boolean isOutCdTime(Date date, long cdTime) {
        Date nowDate = new Date();
        return (nowDate.getTime() - date.getTime()) > cdTime * 1000;
    }

    static public Date parseDate(String dateString) {
        try {
            return dateFormat1.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public boolean isInTime(Date now, Date begin, Date end) {
        if (now.before(end) && now.after(begin)) {
            return true;
        }

        return false;
    }

    static public boolean isAfterTime(Date now, Date after) {
        if (now.after(after)) {
            return true;
        }
        return false;
    }

    /**
     * 第几天,同一天为第一天
     * 
     * @param origin
     * @param now
     * @return
     */
    static public int dayiy(Date origin, Date now) {
        Calendar orignC = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        orignC.setTime(origin);
        orignC.set(Calendar.HOUR_OF_DAY, 0);
        orignC.set(Calendar.MINUTE, 0);
        orignC.set(Calendar.SECOND, 0);
        orignC.set(Calendar.MILLISECOND, 0);

        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return (int) ((calendar.getTimeInMillis() - orignC.getTimeInMillis()) / (24 * 3600 * 1000)) + 1;
    }

    /**
     * 第多少天后的时间点(秒值),和dayiy()对应
     * 
     * @param origin
     * @param addDay
     * @return
     */
    public static int afterDayTime(Date origin, int addDay) {
        Calendar orignC = Calendar.getInstance();
        addDay -= 1;
        orignC.setTime(origin);
        orignC.set(Calendar.DAY_OF_YEAR, orignC.get(Calendar.DAY_OF_YEAR) + addDay);
        orignC.set(Calendar.HOUR_OF_DAY, 0);
        orignC.set(Calendar.MINUTE, 0);
        orignC.set(Calendar.SECOND, 0);
        orignC.set(Calendar.MILLISECOND, 0);
        return (int) (orignC.getTimeInMillis() / 1000);
    }

    public static Date afterDayTimeDate(Date origin, int addDay) {
        Calendar orignC = Calendar.getInstance();
        addDay -= 1;
        orignC.setTime(origin);
        orignC.set(Calendar.DAY_OF_YEAR, orignC.get(Calendar.DAY_OF_YEAR) + addDay);
        orignC.set(Calendar.HOUR_OF_DAY, 0);
        orignC.set(Calendar.MINUTE, 0);
        orignC.set(Calendar.SECOND, 0);
        orignC.set(Calendar.MILLISECOND, 0);
        return orignC.getTime();
    }

    /**
     * 获取当前是今年的第几个星期
     */
    public static int getWeekOfYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfYear(long millis) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /** 获取传入秒的当前天0点date对象 */
    public static Date getTimeZoneDate(int currentSecond) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentSecond * 1000L);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 是否在此区时间段
     * 
     * @param now
     * @param start 格式 HH:mm:ss
     * @param end 格式 HH:mm:ss
     * @return
     */
    public static boolean inThisTime(Date now, String start, String end) {
        Date beginDate = null;
        Date endDate = null;
        try {
            now = dateTimeFormat.parse(dateTimeFormat.format(new Date()));
            beginDate = dateTimeFormat.parse(start);
            endDate = dateTimeFormat.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (beginDate == null || endDate == null || now == null) {
            return false;
        }
        return DateHelper.isInTime(now, beginDate, endDate);
    }

    public static boolean isAfterTime(Date now, String after) {
        Date beginDate = null;
        try {
            now = dateTimeFormat.parse(dateTimeFormat.format(new Date()));
            beginDate = dateTimeFormat.parse(after);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (beginDate == null || now == null) {
            return false;
        }
        return DateHelper.isAfterTime(now, beginDate);
    }


    /**
     * origin的second秒以后,转成date
     * @param origin
     * @param second
     * @return
     */
    public static Date afterSecondDate(String origin, int second) {
        Date afterDate = null;
        try {
            Date originC = dateTimeFormat.parse(origin);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(originC);
            calendar.set(Calendar.SECOND, second);
            long afterTime = calendar.getTimeInMillis();
            afterDate = dateTimeFormat.parse(dateTimeFormat.format(new Date(afterTime)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return afterDate;
    }

    /**
     * 将origin的时分秒设置到date上
     * @param date
     * @param origin
     * @return
     */
    public static Date afterStringTime(Date date, String origin) {
        Date afterDate = null;
        try {
            Date originC = dateTimeFormat.parse(origin);
            Calendar beforeC = Calendar.getInstance();
            beforeC.setTime(originC);
            Calendar afterC = Calendar.getInstance();
            afterC.setTime(date);
            afterC.set(Calendar.HOUR_OF_DAY, beforeC.get(Calendar.HOUR_OF_DAY));
            afterC.set(Calendar.MINUTE, beforeC.get(Calendar.MINUTE));
            afterC.set(Calendar.SECOND, beforeC.get(Calendar.SECOND));
            afterC.set(Calendar.MILLISECOND, beforeC.get(Calendar.MILLISECOND));
            afterDate = afterC.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return afterDate;
    }

    /**
     * 将origin的时分秒设置到date上
     * @param date
     * @param origin
     * @return
     */
    public static Date afterStringTime(Date date, Date origin) {
        Date afterDate = null;
        // Date originC = dateTimeFormat.parse(origin);
        Calendar beforeC = Calendar.getInstance();
        beforeC.setTime(origin);
        Calendar afterC = Calendar.getInstance();
        afterC.setTime(date);
        afterC.set(Calendar.HOUR_OF_DAY, beforeC.get(Calendar.HOUR_OF_DAY));
        afterC.set(Calendar.MINUTE, beforeC.get(Calendar.MINUTE));
        afterC.set(Calendar.SECOND, beforeC.get(Calendar.SECOND));
        afterC.set(Calendar.MILLISECOND, beforeC.get(Calendar.MILLISECOND));
        afterDate = afterC.getTime();
        return afterDate;
    }

}
