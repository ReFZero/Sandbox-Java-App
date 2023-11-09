package pl.ReFZero.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamClass {

    public static void main(String[] args) {

// map() - wykonuje jakas funkcje na obiekcie i go zwraca
// flatMap() - wykonuje spłaszczenie struktury i zwraca Stream

        //map()
        List<String> listLowerCase = List.of("a", "b", "c", "d");
        List<String> listUpperCase = listLowerCase.stream()
                .map(s -> s.toUpperCase())
                // ewentualnie referncja do metody  .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Przed funkcja map():");
        listLowerCase.forEach(System.out::println);
        System.out.println("Po funkcja map():");
        listUpperCase.forEach(System.out::println);

        //flatMap()
        List<String> list1 = List.of("a", "b", "c", "d");
        List<String> list2 = List.of("A", "B", "C", "D");
        List<List<String>> complexList = List.of(list1, list2);

        System.out.println("Lista przed spłaszczeniem flatMap():");
        complexList.forEach(System.out::println);

        List<String> simpleList = complexList.stream()
                .flatMap(List::stream) // spłaszczenie struktury. Zwraca Stream<T> !!!
                .collect(Collectors.toList());
        System.out.println("Lista po spłaszczeniu flatMap():");
        simpleList.forEach(System.out::println);
    }
}
