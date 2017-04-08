package com.example.a3mpe.mylibrary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Emre Vatansever  on 8.04.2017.
 */

public class Utils {


    public static ArrayList<String> getMinutes() {
        ArrayList<String> timeList = new ArrayList<>();

        for (int i = 0, y = 0; i < 48; i++) {
            String hour;
            String minute;

            if (i % 2 == 0) {
                minute = "00";
                hour = y < 10 ? "0" + y : "" + y;
            } else {
                minute = "30";
                hour = y < 10 ? "0" + y : "" + y;
                y++;
            }

            timeList.add(hour + ":" + minute);
        }

        return timeList;
    }

    public static HashMap<String, Calendar> getFixedDates() {
        HashMap<String, Calendar> fixedDates = new HashMap<>();

        Calendar start = Calendar.getInstance();
        start.set(Calendar.SECOND, 0);

        start.add(Calendar.MINUTE, ((60 - start.get(Calendar.MINUTE)) % 60));
        start.add(Calendar.HOUR_OF_DAY, 2);

        int hour = start.get(Calendar.HOUR_OF_DAY);

        if (hour >= 20) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            start.set(Calendar.HOUR_OF_DAY, 9);
            start.set(Calendar.MINUTE, 0);
        } else if (hour <= 9) {
            start.set(Calendar.HOUR_OF_DAY, 9);
            start.set(Calendar.MINUTE, 0);
        }

        fixedDates.put("start_date", start);
        Calendar end = (Calendar) start.clone();
        end.add(Calendar.DAY_OF_MONTH, 1);
        fixedDates.put("end_date", end);

        return fixedDates;
    }
    public static HashMap<String, Calendar> getFixedDates(int addEndTime) {
        HashMap<String, Calendar> fixedDates = new HashMap<>();

        Calendar start = Calendar.getInstance();
        start.set(Calendar.SECOND, 0);

        start.add(Calendar.MINUTE, ((60 - start.get(Calendar.MINUTE)) % 60));
        start.add(Calendar.HOUR_OF_DAY, 2);

        int hour = start.get(Calendar.HOUR_OF_DAY);

        if (hour >= 20) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            start.set(Calendar.HOUR_OF_DAY, 9);
            start.set(Calendar.MINUTE, 0);
        } else if (hour <= 9) {
            start.set(Calendar.HOUR_OF_DAY, 9);
            start.set(Calendar.MINUTE, 0);
        }

        fixedDates.put("start_date", start);
        Calendar end = (Calendar) start.clone();
        end.add(Calendar.DAY_OF_MONTH, addEndTime);
        fixedDates.put("end_date", end);

        return fixedDates;
    }
}
