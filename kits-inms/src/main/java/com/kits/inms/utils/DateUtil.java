package com.kits.inms.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author 姚邦奇
 */
public class DateUtil {
    public final static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm:ss");
    public final static SimpleDateFormat SDF_TIME12 = new SimpleDateFormat("hh:mm:ss");
    public final static SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat SDF_DATETIME12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 取得日期
     *
     * @param
     * @return 日期字符串
     */
    public static String formatToDate(Date date) {
        return SDF_DATE.format(date);
    }

    /**
     * 取得时间
     *
     * @param
     * @return 时间字符串
     */
    public static String formatToTime(Date date) {
        return SDF_TIME.format(date);
    }

    /**
     * 取得完整时间(秒)
     *
     * @param
     * @return 时间字符串
     */
    public static String formatToDateTime(Date date) {
        return SDF_DATETIME.format(date);
    }

    /**
     * 作为开始日期(小时，分钟，秒，毫秒变为0)
     *
     * @param date
     * @return
     */
    public static Date asStartDate(Date date) {
        Calendar calendar = datePrefix(date);
        return asStartDate(calendar);
    }

    /**
     * 作为开始日期(小时，分钟，秒，毫秒变为0)
     *
     * @param calendar
     * @return
     */
    public static Date asStartDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 作为结束日期(小时变为23，分钟，秒变为59，毫秒变为999)
     *
     * @param date
     * @return
     */
    public static Date asEndDate(Date date) {
        Calendar calendar = datePrefix(date);
        return asEndDate(calendar);
    }

    /**
     * 作为结束日期(小时变为23，分钟，秒变为59，毫秒变为999)
     *
     * @param calendar
     * @return
     */
    public static Date asEndDate(Calendar calendar) {
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取这个月的的开始时间
     *
     * @param date
     * @return
     */
    public static Date asStartDateOfMonth(Date date) {
        Calendar calendar = datePrefix(date);
        //只保留日期
        asStartDate(calendar);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取这个月的最后一刻
     *
     * @param date
     * @return
     */
    public static Date asEndDateOfMonth(Date date) {
        Calendar calendar = datePrefix(date);
        //设置为当天的最后1ms
        asEndDate(calendar);
        //回到上个月最后一天
        calendar.set(Calendar.DAY_OF_MONTH, -1);
        //月份+1
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        return calendar.getTime();
    }

    /**
     * 获取这一年的第一天
     *
     * @param date
     * @return
     */
    public static Date asStartDateOfYear(Date date) {
        Calendar calendar = datePrefix(date);
        //只保留日期
        asStartDate(calendar);
        //设置为当年第一天
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取这一年的最后一刻
     *
     * @param date
     * @return
     */
    public static Date asEndDateOfYear(Date date) {
        Calendar calendar = datePrefix(date);
        //设置为当天的最后1ms
        asEndDate(calendar);
        //设为当年第一天
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        //加一年
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        //减少一天
        calendar.set(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 计算两个时间的小时差
     *
     * @param dateA
     * @param dateB
     * @return
     */
    public static int calcDiffOfHour(Date dateA, Date dateB) {
        Calendar calendarA = datePrefix(dateA);
        Calendar calendarB = datePrefix(dateB);

        Long diff = Math.abs(calendarA.getTimeInMillis() - calendarB.getTimeInMillis());
        diff = diff / 1000 / 60 / 60;
        return diff.intValue();
    }

    /**
     * 计算两个时间的天数差
     *
     * @param dateA
     * @param dateB
     * @return
     */
    public static int calcDiffOfDay(Date dateA, Date dateB) {
        Calendar calendarA = datePrefix(dateA);
        Calendar calendarB = datePrefix(dateB);

        Long diff = Math.abs(calendarA.getTimeInMillis() - calendarB.getTimeInMillis());
        diff = diff / 1000 / 60 / 60 / 24;
        return diff.intValue();
    }

    /**
     * 按天数偏移量得到新时间
     *
     * @param date       时间
     * @param offsetType 偏移类型
     *                   如 Calendar.DAY_OF_MONTH
     * @param offset     偏移量
     * @return
     */
    public static Date calcOffset(Date date, int offsetType, int offset) {
        Calendar calendar = datePrefix(date);
        calendar.set(offsetType, calendar.get(offsetType) + offset);
        return calendar.getTime();
    }

    private static Calendar datePrefix(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            date = new Date();
        }
        calendar.setTime(date);
        return calendar;
    }
}
