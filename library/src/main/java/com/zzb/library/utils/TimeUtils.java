package com.zzb.library.utils;

import android.support.v4.util.LruCache;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final long SECOND_MILLIS = 1000;
    public static final long MINUTE_MILLIS = 60 * SECOND_MILLIS;
    public static final long HOUR_MILLIS = 60 * MINUTE_MILLIS;
    public static final long DAY_MILLIS = 24 * HOUR_MILLIS;
    private static LruCache<String, SimpleDateFormat> sCachedFormats = new LruCache<String, SimpleDateFormat>(10);


    /**
     * 获取当天默认格式的日期字符串
     * @return 格式化日期
     * @author ZZB
     */
    public static String getDefaultTimeStamp() {
        return millisToTimestamp(System.currentTimeMillis(), DEFAULT_DATE_FORMAT);
    }


    /**
     * 获取当天默认格式的日期字符串
     * @param millis 时间毫秒
     * @return  格式化日期
     * @author ZZB
     */
    public static String getDefaultTimeStamp(long millis) {
        return millisToTimestamp(millis, DEFAULT_DATE_FORMAT);
    }

    
    /**
     * 日期转为距今多少天
     * @param format 格式
     * @param date 日期字符串
     * @return 格式化日期
     * @author ZZB
     */
    public static String timeStampToDaysElapsed(String format, String date) {
        long millis = System.currentTimeMillis() - timeStampToMillis(date, format);
        long days = millis / DAY_MILLIS;
        long year = DAY_MILLIS * 365;
        if (days < 365) {
            return days + "天";
        } else {
            long years = millis / year;
            long leftDays = millis % year / DAY_MILLIS;
            return years + "年" + leftDays + "天";
        }
    }

    /**
     * 获取DateFormat
     * @param template 日期格式
     * @return SimpleDateFormat
     * @author ZZB
     */
    private static SimpleDateFormat getDateFormat(String template) {
        SimpleDateFormat format = sCachedFormats.get(template);
        if (format == null) {
            format = new SimpleDateFormat(template, Locale.CHINA);
            sCachedFormats.put(template, format);
            Log.d("TimeUtils", "miss:" + template);
        } else {
            Log.d("TimeUtils", "hit:" + template);
        }
        return format;
    }

    /**
     * 毫秒转为日期
     * @param millis 时间毫秒
     * @param template 日期格式
     * @return  格式化日期
     * @author ZZB
     */
    public static String millisToTimestamp(long millis, String template) {
        SimpleDateFormat sdf = getDateFormat(template);
        return sdf.format(new Date(millis));
    }


    /**
     * Date转为日期
     * @param date Date
     * @param template 日期格式
     * @return  格式化日期
     * @author ZZB
     */
    public static String dateToTimeStamp(Date date, String template) {
        SimpleDateFormat sdf = getDateFormat(template);
        return sdf.format(date);
    }

    /**
     * 字符串转为Date
     * @param timeStamp 日期字符串
     * @param template 日期格式
     * @return Date
     * @author ZZB
     */
    public static Date timeStampToDate(String timeStamp, String template) {
        SimpleDateFormat sdf = getDateFormat(template);
        Date date = null;
        try {
            date = sdf.parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 日期转为毫秒
     * @param timeStamp 日期字符串
     * @param template 日期格式
     * @return 毫秒
     * @author ZZB
     */
    public static long timeStampToMillis(String timeStamp, String template) {
        return timeStampToDate(timeStamp, template).getTime();
    }

    /**
     * 日期转为毫秒，使用默认格式
     * @param timeStamp 日期字符串
     * @return 毫秒
     * @author ZZB
     */
    public static long timeStampToMillis(String timeStamp) {
        return timeStampToMillis(timeStamp, DEFAULT_DATE_FORMAT);
    }
}
