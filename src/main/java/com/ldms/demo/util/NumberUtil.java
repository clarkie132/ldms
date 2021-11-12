package com.ldms.demo.util;

public class NumberUtil {
    public static double round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
