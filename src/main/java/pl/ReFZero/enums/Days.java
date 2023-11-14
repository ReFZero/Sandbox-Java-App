package pl.ReFZero.enums;

import java.io.Serializable;

public enum Days implements Serializable {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);
    final int  dayNumber;

    Days(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    @Override
    public String toString() {
        return "Days{" +
                "dayNumber=" + dayNumber +
                '}';
    }
}
