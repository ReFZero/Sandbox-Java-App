package pl.ReFZero.string;

import java.util.Arrays;

public class StringClass {

    public static void main(String[] args) {

// StringPool i Sterta
        System.out.println("Obiekty String stworzone przy uzyciu =\"\"");
        String stringA = "teks2"; // Bedzie na StringPool.
        String stringB = "teks2"; // Bedzie na StringPool.
        // TWORZAC NOWY OBIEKT O TEJ SAMEJ ZAWARTOSCI REFERENCJA ZOSTANIE PRZYPISANA DO ISTNIEJACEGO ADRESU W STRINGPOOL
        // stringA i stringB maja taka sama referncje!
        System.out.println("Czy referencje sa rowne?");
        System.out.println(stringA == stringB); // "==" porownuje referencje nie zawartosc. Chcac porownac zawartosc nalezy uzyc equals()
        System.out.println("Referencje obiektow:");
        System.out.println(Integer.toHexString(System.identityHashCode(stringA)));
        System.out.println(Integer.toHexString(System.identityHashCode(stringB)));

        System.out.println("Obiekty String stworzone przy uzyciu operatora = new String()");
        String stringX = new String("tekst1"); // Bedzie na stercie jako nowy obiekt.
        String stringY = new String("tekst1"); // Bedzie na stercie jako nowy obiekt.
        // ZAWSZE BEDZIE NOWYM OBIEKTEM NAWET JESLI MA TAKA SAMA ZAWARTOSC JAK INNY OBIEKT TYPU STRING
        System.out.println("Czy referencje sa rowne?");
        System.out.println(stringX == stringY); // "==" porownuje referencje nie zawartosc. Chcac porownac zawartosc nalezy uzyc equals()
        System.out.println("Referencje obiektow:");
        System.out.println(Integer.toHexString(System.identityHashCode(stringX)));
        System.out.println(Integer.toHexString(System.identityHashCode(stringY)));
        System.out.println("Metoda equals():");
        System.out.println(stringX.equals(stringY));

        //Przydatne metody

        String stringTest = "Abcde";
        //charAt(x) - zwraca znak pod indeksem x. Liczy od 0.
        System.out.println(stringTest.charAt(0));
        //codePointAt(x) - zwraca unicode pod indeksem x
        System.out.println(stringTest.codePointAt(0)); //A - 65(unicode)
        //codePointBefore(x) - zwraca unicode przed indeksem x
        System.out.println(stringTest.codePointBefore(1));
        //codePointCount() - zwraca ilosc znakow unicode znalezionych w stringu
        System.out.println(stringTest.codePointCount(0, 4)); // 0 - indeks poczatkowy, 4 - indeks koncowy
        //compareTo() porownuje dwa stringi. Dziala na unicode. 0 - rowne , <0 mniejszy, >0 wiekszy
        String stringCompareTo = "abcde";
        System.out.println(stringTest.compareTo(stringCompareTo));
        System.out.println(stringTest.compareTo("abcde"));
        System.out.println("abcde".compareTo(stringTest));
        //compareToIgnoreCase() porownuje dwa stringi. Ignoruje wielkosc znakow. Dziala na unicode. 0 - rowne , <0 mniejszy, >0 wiekszy
        System.out.println(stringTest.compareToIgnoreCase(stringCompareTo));
        //concat() - składa obiety typu String
        String stringConcat = "1234";
        System.out.println(stringTest.concat(stringConcat));
        //contains() - sprawdza czy obiekt zawiera dany wzor
        System.out.println(stringTest.contains("bcd"));
        //contentEquals() - sprawdza czy obiekt zawiera DOKŁADNY wzor. Przyjmuje CharSequence i StringBuffer, StringBuilder.
        StringBuilder stringBuffer = new StringBuilder("Abcde");
        System.out.println(stringTest.contentEquals(stringBuffer));
        //copyValueOf() - kopiuje zawartosc od poczatkowego i do koncowego indeksu z podanej tablicy znakow
        char[] tabChar = {'A', 'b', 'c', 'd', 'e'};
        System.out.println(String.copyValueOf(tabChar, 0, 3));
        //endsWith() - sprawdza czy string konczy sie na podany wzor
        System.out.println(stringTest.endsWith("de"));
        //equals() - porownuje dwa stringi
        String stringTestEquals = "Abcde";
        System.out.println(stringTest.equals(stringTestEquals));
        //equalsIgnoreCase() - to samo co equals ale ignoruje wielkosci znakow
        String stringTestIgnoreCase = "Abcde";
        System.out.println(stringTest.equalsIgnoreCase(stringTestIgnoreCase));
        //format() - formatuje string
        String name = "Rafal";
        int age = 30;
        double salary = 2500.50;
    /*  Podstawowe specyfikatory formatowania:
    %s - dla typu String,
    %d - dla typu int,
    %f - dla typu float lub double,
    %c - dla typu char,
    %b - dla typu boolean.

    %.2f oznacza wstawienie wartości typu double z dwoma miejscami po przecinku.  */
        String formattedString = String.format("Name: %s, Age: %d, Salary: %.2f", name, age, salary);
        System.out.println(formattedString);
        //getBytes() - zamienia string na tablice bajtow
        byte[] byteTab = stringTest.getBytes();
        System.out.println(Arrays.toString(byteTab));
    }
}
