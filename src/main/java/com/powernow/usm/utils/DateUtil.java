package com.powernow.usm.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Date 2021/2/3 11:00
 */
@Slf4j
public class DateUtil {
    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TIME_MILLS_PATTERN = "HHmmsss";
    public static final String PATTERN_DATE2 = "yyyyMMdd";
    public static final String YMD="yyyy-MM-dd";
    public static final String YM="yyyy-MM";
    public static final String MD="MM-dd";
    private static String yesterday="yesterday";
    private static String today="today";
    private static String recentDays="recentDays";
    private static String month="month";
    public static final String YMD_HM="yyyy-MM-dd HHmm";
    public static final String YMD_HMS_S="yyyyMMddHHmmssSSS";


    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";



    public static List<String> getBetweenDays(String stime,String etime){
        SimpleDateFormat df = new SimpleDateFormat( MD);
        Date sdate = null;
        Date eDate = null;
        try {
            sdate = df.parse(stime);
            eDate = df.parse(etime);
        } catch (ParseException e) {
            log.error(e.getMessage(),e);
            return new ArrayList<>(0);
        }
        Calendar c = Calendar.getInstance();
        List<String> list = new ArrayList<>();
        while (sdate.getTime() <= eDate.getTime()) {
            list.add(df.format(sdate));
            c.setTime(sdate);
            c.add(Calendar.DATE, 1);
            sdate = c.getTime();
        }
        return list;
    }


    /**
     * 获取指定日期的前N天日期
     **/
    public static Date getBeforeDayDate(Date date, int beforeDay) {
        Calendar a = Calendar.getInstance();
        a.setTime(date);
        a.add(Calendar.DATE, -beforeDay);
        return a.getTime();
    }

    /**
     * 添加指定的小时
     *
     * @param payDate
     * @param n
     * @return
     */
    public static Date addHour(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加n个小时
        cal.add(Calendar.HOUR, n);
        return cal.getTime();
    }

    /**
     * 增加指定天
     * @param payDate   初始日期
     * @param n         增加天数
     * @return
     */
    public static Date addDays(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加n天
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 增加指定月
     * @param payDate   初始日期
     * @param n         增加月数
     * @return
     */
    public static Date addMonths(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加n天
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 增加指定秒
     * @param payDate       初始日期
     * @param n             增加秒数
     * @return
     */
    public static Date addSecond(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加多少秒
        cal.add(Calendar.SECOND, n);
        return cal.getTime();
    }

    /**
     * 增加指定分钟
     * @param payDate   初始时间
     * @param n         增加分钟数
     * @return
     */
    public static Date addMinute(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加多少秒
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }
    /**
     * 增加指定分钟
     * @param payDate   初始时间
     * @param n         增加分钟数
     * @return
     */
    public static String addMinuteStr(Date payDate, int n) {
        // 当前系统时间转Calendar类型
        Calendar cal = dataToCalendar(payDate);
        // 增加多少秒cal.getTime()
        cal.add(Calendar.MINUTE, n);
        return dateToString(cal.getTime());
    }
    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 将javaDate类型的日期转化为 yyyy-MM-dd HH:mm:ss 格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        return dateToString(date,YMD_HMS);
    }

    public static String dateToString(Date date,String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 获取现在时间
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(YMD);
        String dateString = formatter.format(currentTime);
        return strToDate(dateString,YMD);
    }

    /**
     * 格式化时间格式为yyyy-MM-dd
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(YMD);
        String dateString = formatter.format(date);
        return strToDate(dateString,YMD);
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getHourMinute() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 字符串转换为制定格式日期
     * (注意：当你输入的日期是2014-12-21 12:12，format对应的应为yyyy-MM-dd HH:mm
     * 否则异常抛出)
     * @param date
     * @param format
     * @return
     * @throws ParseException
     *    @
     */
    public static Date strToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.toString());
        }
    }

    /**
     * 字符串转换为制定格式日期
     * @param date
     * @return
     * @throws ParseException
     *    @
     */
    public static Date strToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YMD_HMS);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.toString());
        }
    }

    /**
     * 获取两个日期之间的所有日期，格式为：yyyy-MM-dd(包含当天)
     * @param start
     * @param end
     * @return
     */
    public static List<String> getYMBetweenDate(Date start,Date end){
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat(YMD);
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
//        tempEnd.add(Calendar.MONTH, +1);// 日期加1(包含结束)
        while (tempStart.before(tempEnd)) {
            days.add(dateFormat.format(tempStart.getTime()));
            tempStart.add(Calendar.DATE, 1);
        }
        return days;
    }

    /**
     * 获取两个日期之间的所有日期，格式为：yyyy-MM-dd(包含当天)
     * @param start
     * @param end
     * @return
     */
    public static Integer getDaysCountBetweenDate(Date start,Date end){
        // 返回的日期集合
        List<String> days = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat(YMD);
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
//        tempEnd.add(Calendar.MONTH, +1);// 日期加1(包含结束)
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            days.add(dateFormat.format(tempStart.getTime()));
            tempStart.add(Calendar.DATE, 1);
        }
        return days.size();
    }

    /**
     * 获取每天的开始时间 00:00:00:00
     *
     * @param date
     * @return
     */
    public static String getStartTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar dateStart = Calendar.getInstance();
        dateStart.setTime(date);
        dateStart.set(Calendar.HOUR_OF_DAY, 0);
        dateStart.set(Calendar.MINUTE, 0);
        dateStart.set(Calendar.SECOND, 0);
        return dateToString(dateStart.getTime());
    }

    /**
     * 获取每天的开始时间 23:59:59:999
     *
     * @param date
     * @return
     */
    public static String getEndTime(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar dateEnd = Calendar.getInstance();
        dateEnd.setTime(date);
        dateEnd.set(Calendar.HOUR_OF_DAY, 23);
        dateEnd.set(Calendar.MINUTE, 59);
        dateEnd.set(Calendar.SECOND, 59);
        return dateToString(dateEnd.getTime());
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数（包含开始时间当天）
     * @throws ParseException
     */
    public static Integer daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.valueOf(String.valueOf(between_days)) + 1;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数（包含开始时间当天）
     * @throws ParseException
     */
    public static Integer daysBetween(String smdate,String bdate) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.valueOf(String.valueOf(between_days)) + 1;
    }

    /**
     * 获取两个日期之间的所有日期(字符串格式, 按天计算,包含开始结束时间)
     *
     * @param startTime String 开始时间 yyyy-MM-dd
     * @param endTime  String 结束时间 yyyy-MM-dd
     * @return
     */
    public static List<String> getYMDBetweenDays(String startTime, String endTime) throws ParseException {
        if(StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)){
            return null;
        }
        //1、定义转换格式
        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");

        Date start = df.parse(startTime);
        Date end = df.parse(endTime);
        List<String> result = new ArrayList<String>();

        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        result.add(sdf.format(start));
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }


    /**
     * 格式化时间格式为yyyy-MM-dd
     * @param time  yyyyMMdd
     * @return
     */
    public static String formatDate(String time) {
        Date date = strToDate(time, PATTERN_DATE2);
        SimpleDateFormat formatter = new SimpleDateFormat(YMD);
        String dateString = formatter.format(date);
        return dateString;
    }


    /**
     * 格式化时间
     * @param time      初始时间
     * @param format1   初始时间对应格式
     * @param format2   要转换成的目标格式
     * @return
     */
    public static String formatDate(String time, String format1, String format2) {
        Date date = strToDate(time, format1);
        SimpleDateFormat formatter = new SimpleDateFormat(format2);
        String dateString = formatter.format(date);
        return dateString;
    }


    public static void main(String[] args) throws ParseException {

//        String reg = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
//        String reg = "^[1-9]\\d{3}-(([0][1-9])|([1][0-2]))$";
        String reg = "^([\\d]{4}((((0[13578]|1[02])((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|11)((0[1-9])|([12][0-9])|30))|(02((0[1-9])|(1[0-9])|(2[0-8])))))|((((([02468][048])|([13579][26]))00)|([0-9]{2}(([02468][048])|([13579][26]))))(((0[13578]|1[02])((0[1-9])|([12][0-9])|(3[01])))|(((0[469])|11)((0[1-9])|([12][0-9])|30))|(02((0[1-9])|(1[0-9])|(2[0-9]))))){4})$";

        Pattern p = Pattern.compile(reg);

        boolean m = p.matcher("20221001 00:00:00").matches();


        log.info("" + m);
    }

}
