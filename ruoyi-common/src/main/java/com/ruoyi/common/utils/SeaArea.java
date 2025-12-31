package com.ruoyi.common.utils;

public class SeaArea {
    public static String resolveSeaArea(double lat, double lon) {
        if(lat >= 37 && lat <= 41 && lon >= 117 && lon <= 122) {
            return "渤海";
        }
        if(lat >= 32 && lat < 37 && lon >= 120 && lon <= 126) {
            return "黄海";
        }
        if(lat >= 24 && lat < 32 && lon >= 118 && lon <= 128) {
            return "东海";
        }
        if(lat >= 3 && lat < 24 && lon >= 105 && lon <= 125) {
            return "南海";
        }
        return "其他";
    }
}
