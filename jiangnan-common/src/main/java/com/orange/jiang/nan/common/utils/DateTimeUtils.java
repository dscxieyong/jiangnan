package com.orange.jiang.nan.common.utils;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zzs .
 * @since 2017/11/9
 */
public class DateTimeUtils {

    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_COMPACT = "yyyyMMdd";

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_TL_DEFAULT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_TL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    public static Date strToDate(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            throw new IllegalArgumentException("The parameter date String is null.");
        }

        try {
            if (dateStr.contains("-")) {
                return SIMPLE_DATE_FORMAT_TL_DEFAULT.get().parse(dateStr);
            } else {
                return SIMPLE_DATE_FORMAT_TL.get().parse(dateStr);
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("参数解析异常：" + e.getMessage());
        }
    }

    public static Date today() {
        return new Date();
    }

    public static String now() {
        return formatDate(today());
    }

    public static String formatDate(Date date) {
        return formatDate(date, PATTERN_DEFAULT);
    }

    public static LocalDateTime formatString(String date, String pattern) {
        if (null == date) {
            throw new IllegalArgumentException("The parameter date string is null");
        }
        if (null == pattern) {
            throw new IllegalArgumentException("The parameter pattern string is null");
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date, df);
    }

    public static LocalDateTime formatString(String date) {
        return formatString(date, PATTERN_DEFAULT);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /**
     * 获取到秒的时间戳
     */
    public static Integer getTime(Date date) {
        if (date == null) {
            return null;
        }
        return (int) (date.getTime() / 1000);
    }

    /**
     * 从date1到date2有多少天，同一天则天数为0
     * 该方法已废弃，请使用calculateDaysDiff
     *
     * @param date1
     * @param date2
     * @return
     */
    @Deprecated
    public static int getDateDiff(Date date1, Date date2) {
        return calculateDaysDiff(date1, date2);
    }

    /**
     * 从date1到date2有多少天，同一天算1天，不是同一天正常算
     * 该方法已废弃，请使用BusinessDateTimeUtils.getDateDifference
     *
     * @param date1
     * @param date2
     * @return
     */
    @Deprecated
    public static int differentDays(Date date1, Date date2) {
        return calculateDaysDiff(date1, date2) == 0 ? 1 : calculateDaysDiff(date1, date2);
    }

    /**
     * date2与date1间隔的天数,date2>date1,不足一天算一天,按秒计算
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int intervalDays(Date date1, Date date2) {
        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)) {
            return 0;
        }
        long interval = date2.getTime() - date1.getTime();
        return (int) Math.ceil(interval / 1000 / 60.00 / 60.00 / 24.00);
    }

    /**
     * date1大于date2返回true，否则返回false
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compareDate(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime()) {
            return true;
        } else if (date1.getTime() < date2.getTime()) {
            System.out.println("dt1在dt2后");
            return false;
        }
        return false;
    }

    /**
     * java.util.Date 转 java.time.LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        if (null == date) {
            throw new IllegalArgumentException("The parameter date is null");
        }

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * java.util.Date 转 java.time.LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        if (null == date) {
            throw new IllegalArgumentException("The parameter date is null");
        }

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone).toLocalDate();
    }

    /**
     * java.util.Date 转 java.time.LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime dateToLocalTime(Date date) {
        if (null == date) {
            throw new IllegalArgumentException("The parameter date is null");
        }

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone).toLocalTime();
    }

    /**
     * java.time.LocalDateTime 转 java.util.Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            throw new IllegalArgumentException("The parameter localDateTime is null");
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalDate 转 java.util.Date
     *
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        if (null == localDate) {
            throw new IllegalArgumentException("The parameter localDate is null");
        }

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * java.time.LocalTime 转 java.util.Date
     *
     * @param localDate
     * @param localTime
     * @return
     */
    public static Date localTimeToDate(LocalDate localDate, LocalTime localTime) {
        if (null == localDate) {
            throw new IllegalArgumentException("The parameter localDate is null");
        }

        if (null == localTime) {
            throw new IllegalArgumentException("The parameter localTime is null");
        }

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取后一日零点时间
     * 例：传入 2018-09-12 12:12:34 返回 2018-09-13 00:00:00
     *
     * @param date
     */
    public static Date getNextDayZeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 计算date2 - date1的结果天数
     * date2在date1后面结果为正数
     * date2在date1前面结果为负数
     * date2和date1在同一天结果为0
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Integer calculateDaysDiff(Date date1, Date date2) {
        if (ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)) {
            throw new IllegalArgumentException("日期不可为空");
        }
        LocalDate localDate1 = dateToLocalDate(date1);
        LocalDate localDate2 = dateToLocalDate(date2);
        return Long.valueOf(localDate1.until(localDate2, ChronoUnit.DAYS)).intValue();
    }

    /**
     * 时间转换 date to yyyyMMdd
     *
     * @param date
     * @return
     */
    public static Integer parseIntegerForYYYYMMDD(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE) + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.YEAR) * 10000;
    }

    /**
     * yyyyMMdd to Date
     *
     * @param date
     * @return
     */
    public static Date parseDateForYYYYMMDD(Integer date) {
        Integer day = date % 100;
        date /= 100;
        Integer month = date % 100;
        date /= 100;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, date);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 判断传入日期是否是今天
     *
     * @param date
     */
    public static boolean isToday(Date date) {
        return isThisTime(date.getTime(), "yyyy-MM-dd");
    }

    public static boolean isThisTime(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //参数时间
        String param = sdf.format(date);
        //当前时间
        String now = sdf.format(new Date());
        if (param.equals(now)) {
            return true;
        }
        return false;
    }

    /**
     * 获取中文时间描述，例：yyyy年M月dd日  HH时mm分ss秒
     * */
    public static String getTimeCNString(){
        Calendar now = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(now.get(Calendar.YEAR)).append("年");
        sb.append(now.get(Calendar.MONTH) + 1).append("月");
        sb.append(now.get(Calendar.DAY_OF_MONTH)).append("日");
        sb.append("  ");
        sb.append(now.get(Calendar.HOUR_OF_DAY)).append("时");
        sb.append(now.get(Calendar.MINUTE)).append("分");
        sb.append(now.get(Calendar.SECOND)).append("秒");
        return sb.toString();
    }

    /**
     *
     * @Title: 格式化日期格式
     * @param date 如果为空，则返回null，格式化前台参数时不需要再先判断参数是否为null
     * @param  hour_of_day
     * @param minute
     * @param second
     * @return java.util.Date
     * @author: xieyong
     * @since: 2019/9/25 上午10:22
     */
    public static Date formateDateTime(Date date, int hour_of_day, int minute, int second){
        if(date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,hour_of_day);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        return calendar.getTime();
    }
}
