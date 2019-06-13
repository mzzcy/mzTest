package com.mzzcy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by changyin.zhao on 3/29/19
 */
public class CompileTest {

    public static void main(String[] args) {

        String myDate = "Mon Dec 31 22:39:50 CST 2018";
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date d = null;
        try {
            d = sdf.parse(myDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

        System.out.print(formatDate);


    }

}
