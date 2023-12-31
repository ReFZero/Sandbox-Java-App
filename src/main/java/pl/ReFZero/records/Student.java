package pl.ReFZero.records;
/*
Java 17
Pola tworzy sie w nawiasach przy rekordzie sa one prywatne.
Własciwosci rekordow:
- modyfikator domyslny lub publiczny
- generowany automatycznie konstruktor parametrowy z wszystkimi polami (kompaktowy konstruktor)
  W ramach rekordu mozna definiować własne konstruktory, ale pierwszą instrukcją, która się w nich pojawi,
  musi być wywołanie konstruktora kompaktowego. Działa to podobnie jak w przypadku tradycyjnych klas,
  gdzie pierwszą instrukcją w konstruktorze musi być wywołanie super()
- generowane gettery (odwolanie do pola nastepuje przez metode o takiej samej nazwie jak pole)
- nadpisane metody toString(), hashCode() i equals()
- nie mozna po nich dzidziczyc, sa finalne
- sa niemutowalne (brak setterow)
- moze zawierac stałe
 */


public record Student(Long id, String name, String surname, Integer age) {
    private static final Integer DEFAULT_VALUE = 23;

    // brak nawiasów przy konstruktorze kompaktowym
    public Student {
        if (age < 0) throw new IllegalArgumentException("Wiek nie powinien byc mniejszy od zera");
    }
    // dodatkowy konstruktor bez wieku
    Student(Long id, String name, String surname) {
        this(id, name, surname, DEFAULT_VALUE);
    }

    // metody tworzy sie tak samo jak w zwyklych klasach
}
