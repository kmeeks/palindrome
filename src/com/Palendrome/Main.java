package com.Palendrome;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try{
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date start = df.parse("12/31/2030");
            Date end = df.parse("01/01/2000");
            Set<Date> dates= getPalindromeDates(start, end);

            for (Date date: dates
                 ) {
                System.out.println(df.format(date));
            }
        } catch (ParseException e){
            System.out.println(e);
        }


    }

    static Set<Date> getPalindromeDates(Date start, Date end) {
        Date startDate = start.before(end) ? start : end;
        Date endDate = end.after(start) ? end : start;

        System.out.println(startDate + " :: " + endDate);
        DateFormat yFormat = new SimpleDateFormat("yyyy");
        int startYear = Integer.parseInt(yFormat.format(startDate));
        int endYear = Integer.parseInt(yFormat.format(endDate));
        List<Date> dates = new ArrayList<Date>();

        for(int k = startYear; k <= endYear; k++){
            System.out.println(k);
            String year = Integer.toString(k);
            String[] numbers = year.split("");

            String reverseNumbers = "";

            for(int i = numbers.length - 1; i >= 0; i--){
                reverseNumbers += numbers[i];
            }

            String date = reverseNumbers.replace(" ", "") + year;
            System.out.println(date);
            try{
                DateFormat format = new SimpleDateFormat("MMddyyyy");
                format.setLenient(false);
                Date palDate = format.parse(date);
                System.out.println("adding : " + palDate);
                dates.add(palDate);
            } catch (Exception e){
                continue;
            }



        }
        Collections.sort(dates);
        Set<Date> setDates = new HashSet(dates);
        return setDates;
    }

}
