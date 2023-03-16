package com.digicert.hotelreservations.libs;

import java.sql.Date;
import java.util.Calendar;
import java.util.Comparator;

public class ReservationDateComparator implements Comparator<Calendar> {

    @Override
    public int compare(Calendar o1, Calendar o2) {
        if(o1 == null) {
            return -1;
        }
        if(o2 == null) {
            return 1;
        }
        if (o1.get(Calendar.YEAR) != o2.get(Calendar.YEAR))
            return o1.get(Calendar.YEAR) - o2.get(Calendar.YEAR);
        if (o1.get(Calendar.MONTH) != o2.get(Calendar.MONTH))
            return o1.get(Calendar.MONTH) - o2.get(Calendar.MONTH);
        if (o1.get(Calendar.DAY_OF_MONTH) != o2.get(Calendar.DAY_OF_MONTH))
            return o1.get(Calendar.DAY_OF_MONTH) - o2.get(Calendar.DAY_OF_MONTH);
        return o1.get(Calendar.HOUR_OF_DAY) - o2.get(Calendar.HOUR_OF_DAY);
    }
}