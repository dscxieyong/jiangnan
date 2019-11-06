package com.orange.jiang.nan.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dingchenchen
 * @since 2019-10-21
 */
public class DateUtils {

    public static final String PATTERN_COMPACT = "yyyyMMdd";

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
}
