package pl.ReFZero.stream;

import pl.ReFZero.stream.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

        //reduce() - agregacja elementów w kolekcji do jednego wyniku.
        // Może być stosowana w różnych kontekstach, ale najczęściej jest używana do sumowania, łączenia lub redukowania elementów.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // W sytuacji gdy chcemy aby lista stała sie Mapa
        List<Person> pList = List.of(
                new Person("Eva", 11),
                new Person("Paula", 73),
                new Person("Gregory", 29),
                new Person("Paul", 20));
        Map<String, Integer> personMap = pList.stream()
                //                                  key = name                    value = age
                //.collect(Collectors.toMap(person -> person.getName(), person -> person.getAge()));
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        //joining()
        // gdy chemy uzyc separatora pomiedzy osobami, zamienia na String
        System.out.println(createPeople().stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .collect(Collectors.joining(",")));

        //partitioningBy()
        // gdy chcemy podzielic na obiekty które spełniaja i te które nie spełniaja warunku
        System.out.println(createPeople().stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() > 30)));

        // groupingBy() & mapping()
        // grupowanie np. po imionach
        Map<String, List<Integer>> ageByName = createPeople().stream()
                .collect(Collectors.groupingBy(
                        Person::getName,            // kluczami beda imiona
                        Collectors.mapping(         // rekurencyjne wywolanie Collectora
                                Person::getAge,      // wartosciami bedzie lista Integer
                                Collectors.toList())));
        System.out.println(ageByName);

        // groupingBy() & counting()
        // Zlicza ilosc wystapien. Zwraca Long
        Map<String, Long> countByName = createPeople().stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.counting()));
        System.out.println(countByName);
        // groupingBy & mapping (Function, Collector)
        // collectingAndThen (Collector, Function)
        // Zlicza ilosc wystapien. Gdy chcemu Integer
        Map<String, Integer> countByNameInteger = createPeople().stream()
                .collect(Collectors.groupingBy(
                        Person::getName,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                Long::intValue)));
        System.out.println(countByNameInteger);

        // reduce standardowo
        System.out.println(createPeople().stream()
                .map(Person::getAge)
                .reduce(0, (total, age) -> total + age));
        // uzywajac sum()
        System.out.println(createPeople().stream()
                .mapToInt(Person::getAge)
                .sum());
        // reduce - reduce, collect, sum
        // maxBy() & minBy()
        System.out.println(createPeople().stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(
                                Person::getAge))));
        // gdy chcemy tylko samo imie nie caly obiekt
        String result = createPeople().stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(
                                Comparator.comparing(Person::getAge)),
                        person -> person.map(Person::getName).orElse("")
                ));
        System.out.println(result);
        // map - gdy wykonujemy transformacje na samym sobie
        // mapping - gdy chcemy wykonac mapowanie wewnatrz reduce
        // to samo gdy uzywamy filter i filltering
        //filtering()
        System.out.println(createPeople().stream()
                .collect(
                        Collectors.groupingBy(Person::getAge,
                                Collectors.mapping(Person::getName,
                                        Collectors.filtering(name -> name.length() > 4,
                                                Collectors.toList())))));
        // groupingBy(), mapping(), flatMapping() 
        Map<Integer, Set<String>> lettersOfNamesUppercase = createPeople().stream()
                .collect(Collectors.groupingBy(
                        Person::getAge, Collectors.mapping(
                                person -> person.getName().toUpperCase(), Collectors.flatMapping(
                                        name -> Stream.of(name.split("")), Collectors.toSet()
                                )
                        )
                ));
        System.out.println(lettersOfNamesUppercase);
    }

    public static List<Person> createPeople() {
        return List.of(
                new Person("David", 34),
                new Person("John", 56),
                new Person("John", 26),
                new Person("Eva", 11),
                new Person("Paula", 73),
                new Person("Gregory", 29),
                new Person("Paul", 20)
        );
    }
}
