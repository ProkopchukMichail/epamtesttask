package model.util;

import java.time.LocalDateTime;

/**
 * Created by comp on 01.08.2017.
 */
public class DateTimeConverter {
    public static LocalDateTime convert(String str){
        str=str.replace('T','-');
        String values[]=str.split("-");
        int year=Integer.valueOf(values[0]);
        int month=Integer.valueOf(values[1]);
        int day=Integer.valueOf(values[2]);
        return LocalDateTime.of(year,month,day,0,0);
    }
}
