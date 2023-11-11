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

        //getChars() - kopiuje ze stringa do tablicy znaków
        char[] charTab = new char[stringTest.length()];
        stringTest.getChars(0, stringTest.length(), charTab, 0);
        System.out.println(Arrays.toString(charTab));

        //hashCode() - zwraca hashCode stringa
        System.out.println(stringTest.hashCode());

        //indexOf() - zwraca index pierwszego miejsca wystapienia wzorca
        System.out.println(stringTest.indexOf("A")); // zwraca -1 gdy nie znaleziono wzorca

        //intern() - dodaje ciąg do puli (String Pool) i zwraca referencję do ciągu w puli.
        // Używana do dodania ciągu znaków do puli ciągów znaków (String Pool) i zwrócenia odniesienia do tej wartości z puli,
        // jeśli już istnieje. Jeśli dany ciąg znaków nie istnieje w puli,
        // zostanie on dodany, a następnie zwrócone odniesienie do nowo utworzonego ciągu.
        // Ze względu na optymalizacje puli łańcuchów, nie zawsze jest konieczne ręczne wywoływanie intern()
        String stringFromStringPool = "Tekst";
        String newStringToAdd = stringFromStringPool.intern();
        String newStringFromHeap = new String("Tekst");
        System.out.println(stringFromStringPool == newStringToAdd);
        System.out.println(newStringToAdd == newStringFromHeap);

        //isEmpty() - sprawdza czy string nie jest pusty
        System.out.println(stringTest.isEmpty());

        //lastIndexOf() - ostatnie wystapienie wzorca
        System.out.println(stringTest.lastIndexOf("c"));

        //lenght() - zwraca dlugosc stringa
        System.out.println(stringTest.length());

        //matches() - sprawdza czy tekst pasuje do wzorca. Uzywa REGEX
        System.out.println(stringTest.matches("[a-zA-Z]+"));

        //regionMatches() - sprawdza czy string wystepuje  w stringu bazowym
        System.out.println(stringTest.regionMatches(true, 1, "bc", 0, 2));

        //replace() - zwraca nowy string z zaminionymi literami
        String stringReplace = "AaaBbbCcc";
        System.out.println(stringReplace.replace("b", "1"));

        //replaceFirst() - zamienia pierwsze wystapienie wzorca
        System.out.println(stringReplace.replaceFirst("b", "2"));

        //replaceAll() - służy do zamiany wszystkich wystąpień określonego wzorca w ciągu znaków na inny ciąg znaków.
        // Wzorzec może być wyrażeniem regularnym lub zwykłym ciągiem znaków.
        String newStringReplace = "Abc1234 AB1D 34";
        System.out.println(newStringReplace.replaceAll("\\d", "X")); // Zamienia wszystkie cyfry na X (REGEX)
        System.out.println(newStringReplace.replaceAll("A", "X")); // Zamienia wszystkie litery na 'A'

        //split() - zwraca tablice obiektow dzieloac podany string wedlug wzorca
        String text = "Java jest jezykiem obiektowym!";
        String[] strings = text.split(" ");
        System.out.println(Arrays.toString(strings));

        //startsWith() - sprawdza czy podany string zaczyna sie od wzorca
        System.out.println(stringTest.startsWith("Ab"));

        //subSequence() - służy do uzyskiwania podciągów (subsequences) z oryginalnego ciągu znaków.
        //Jest przydatna, gdy chcemy uzyskać widok na pewien fragment istniejącego ciągu znaków,
        // bez konieczności tworzenia nowego obiektu ciągu.
        System.out.println(stringTest.subSequence(1, 4));

        //substring() - zwraca string od podanych indeksow. Tworzy nowy obiekt.
        System.out.println(stringTest.substring(1, 4));

        //toCharArray() - zamienia string w tablice znakow
        char[] stringToCharArray = stringTest.toCharArray();
        System.out.println(Arrays.toString(stringToCharArray));

        //toLowerCase - zamienia duze litery na male
        System.out.println(stringTest.toLowerCase());

        //toString - zwraca wartosc string.
        // W przypadku, gdy tworzy sie własne klasy, warto nadpisać metodę toString() (zaimplementować ją ponownie)
        // w celu dostarczenia własnej, bardziej sensownej reprezentacji dla nowych klas.
        // Brak implementacji spowoduje zwrocenie referncji

        //toUpperCase - zamienia male litery na duze
        System.out.println(stringTest.toUpperCase());

        //trim() - służy do usuwania białych znaków z początku i końca ciągu znaków.
        // Białe znaki obejmują spację, znaki nowej linii, tabulatory i inne znaki,
        // które są niewidoczne na ekranie.
        String stringTrim = "      Abc abc   ";
        System.out.println(stringTest.trim());

        //valueOf() - celem tej metody jest konwersja różnych typów danych na obiekt danej klasy,
        // zwykle na obiekt typu String.
        int temp = 234;
        String stringFromInt = String.valueOf(temp);
        System.out.println(stringFromInt);
    }
}
