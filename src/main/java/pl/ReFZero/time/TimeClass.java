package pl.ReFZero.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TimeClass {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // Dodawanie: 1 rok, 1 miesiac, 1 tydzien i 1 dzien
        LocalDateTime localDateTime1 = now.plusYears(1)
                .plusMonths(1)
                .plusWeeks(1)
                .plusDays(1);
        System.out.println(localDateTime1);

        // Odejmowanie: 1 rok, 1 miesiac, 1 tydzien i 1 dzien
        LocalDateTime localDateTime2
                = localDateTime1.minusYears(1)
                .minusMonths(1)
                .minusWeeks(1)
                .minusDays(1);
        System.out.println(localDateTime2);

        // Dodawanie: 1 godzina, 1 minuta, 1 sekunda i 100 nanosekund
        LocalDateTime localDateTime3
                = localDateTime2.plusHours(1)
                .plusMinutes(1)
                .plusSeconds(1)
                .plusNanos(100);
        System.out.println(localDateTime3);

        // Odejmnowanie: 1 godzina, 1 minuta, 1 sekunda i 100 nanosekund
        LocalDateTime localDateTime4
                = localDateTime3.minusHours(1)
                .minusMinutes(1)
                .minusSeconds(1)
                .minusNanos(100);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = LocalDateTime.of(
                2021, 04, 24, 14, 33, 48, 123456789);
        System.out.println(localDateTime5);

        // Miesiac
        LocalDateTime localDateTime6 = LocalDateTime.of(
                2021, Month.APRIL, 24, 14, 33, 48, 123456789);
        System.out.println(localDateTime6);

        // Sekundy
        LocalDateTime localDateTime7 = LocalDateTime.of(
                2021, Month.APRIL, 24, 14, 33, 48);
        System.out.println(localDateTime7);

        // Minuty
        LocalDateTime localDateTime8 = LocalDateTime.of(
                2021, Month.APRIL, 24, 14, 33);
        System.out.println(localDateTime8);

        // Data + czas
        LocalDate date = LocalDate.of(2021, 04, 24);
        LocalTime time = LocalTime.of(10, 34);

        LocalDateTime localDateTime9
                = LocalDateTime.of(date, time);
        System.out.println(localDateTime9);


        // Formatowanie daty i czasu
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime now1 = LocalDateTime.now();
        // Data do Stringa
        String dateTimeString = now1.format(formatter);
        System.out.println(dateTimeString);
    }
}
