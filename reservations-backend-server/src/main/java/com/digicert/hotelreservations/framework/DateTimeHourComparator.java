package com.digicert.hotelreservations.framework;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class DateTimeHourComparator implements Comparator<Date> {

    @Override
    public int compare(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        // Compare year
        if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR))
            return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);

        // Compare month
        if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH))
            return c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);

        // Compare day
        if (c1.get(Calendar.DAY_OF_MONTH) != c2.get(Calendar.DAY_OF_MONTH))
            return c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);

        // Else, compare hour
        return c1.get(Calendar.HOUR_OF_DAY) - c2.get(Calendar.HOUR_OF_DAY);
    }

    /**.
     * Compare two dates and return 0 if they are the same
     * @param d1 Date 1
     * @param d2 Date 2
     * @return 0 if they are the same, otherwise return the difference
     */
    public static int compareDates(Date d1, Date d2) {
        return new DateTimeHourComparator().compare(d1, d2);
    }

    /**
     * Convenience method (wrapper for {@link DateTimeHourComparator#compareDates(Date, Date) == 0}), check if two dates are the same
     * @param d1 Date 1
     * @param d2 Date 2
     * @return true if they are the same, otherwise return false
     */
    public static boolean sameDate(Date d1, Date d2) {
        return compareDates(d1, d2) == 0;
    }
}
