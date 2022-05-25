package com.epam.dhontar.aqamp.hometask1_2_spring.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date createDateFromDataString(String dateString){
        Date date;
        if(null != dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException parseException){
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
