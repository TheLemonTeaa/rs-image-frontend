package com.ruoyi.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateParseUtils {

    private static final String ISO_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public static Date parseUtc(String timeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(ISO_PATTERN);
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.parse(timeStr);
        } catch (Exception e) {
            return null;
        }
    }
}
