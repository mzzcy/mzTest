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


    public static void main(String[] args)
    {
        outer:for(int i = 0 ; i<3; i++)
        { // i= 0;  i =1 i=2 3
            inner:for(int j = 0 ; j<2 ; j++)
            { //j=0
                System.out.println("hello"); //1 2 3
                continue outer;
            }
        }
    }

}
