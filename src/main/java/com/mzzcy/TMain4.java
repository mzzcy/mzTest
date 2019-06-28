package com.mzzcy;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changyin.zhao on 6/12/19
 */
public class TMain4 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Date d = new Date(time);
        Timestamp t = new Timestamp(time);
        t.setNanos(123456789);
        System.out.println(d);
        System.out.println(t);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'.'");
        NumberFormat nf = new DecimalFormat("000000000");
        System.out.println(df.format(t.getTime()));
        System.out.println(nf.format(t.getNanos()));
    }
}
