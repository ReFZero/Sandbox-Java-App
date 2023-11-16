package pl.ReFZero.collection;
    /*
        Podstawowe kolekcje
        <<I>> - interfejs
        <<C>> - klasa implementacyjna
        <<S>> - synchronizowana
        -Iterable <<I>>
            -Collection <<I>>
                - 1. Listy (List) <<I>>
                    -ArrayList <<C>>
                    -LinkedList <<C>>
                    -Vector <<C>> <<S>>
                        -Stack <<C>> <<S>>

                -2. Kolejki (Queue) <<I>>
                    -PriorityQueue <<C>>
                    -ArrayDeque <<C>>

                -3. Zbiory (Set) <<I>>
                    -HashSet <<C>>
                        -LinkedHashSet <<C>>
                    -TreeSet <<C>>

        -4. Mapa (Map) <<I>> - ze wzgledu na swoja budowe nie jest zaliczana do frameworka kolekcji
            -HashTable extends Dictionary <<C>> <<S>>
            -HashMap <<C>>
                -LinkedHashMap <<C>>
            -WeakHashMap <<C>>
            -IdentityHashMap <<C>>
            -TreeMap <<C>>
            -EnumMap <<C>>

        TO DO:
        + Kolekcje synchronizowane
         */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionClass {
    public static void main(String[] args) {
        //Kolekcje mozna uzywac na 2 sposoby:
        //Poprzez interfejsy - zalecany
        List<String> testListInterface = new LinkedList<>();
        //Poprzez konkretne implementacje - niezalecany
        LinkedList<String> testListImplementation = new LinkedList<>();
        /*
        Używanie interfejsów zamiast konkretnych implementacji jest zalecane z kilku powodów:
        - Elastyczność i Zamiana Implementacji:
          Używając interfejsu, masz elastyczność do łatwej zamiany implementacji w przyszłości bez zmian w kodzie, który z nimi współpracuje.
        - Kod Uniwersalny:
          Używając interfejsu, tworzysz kod bardziej uniwersalny, który może współpracować z dowolną implementacją interfejsu.
          Dzięki temu kod staje się bardziej niezależny od konkretnej implementacji, co ułatwia utrzymanie i rozwijanie aplikacji.
        - Lepsza kompatybilność z Bibliotekami i Frameworkami:
          Wielu programistów stosuje tę zasadę, co sprawia, że korzystanie z interfejsów jest bardziej zgodne z konwencjami
          i ułatwia integrację z różnymi bibliotekami i frameworkami.
        - Możliwość Wykorzystania Innych Struktur Danych:
          Używając interfejsu List, możesz łatwo zamienić implementację listy na inną,
          ale również na inną strukturę danych, która implementuje List, np. CopyOnWriteArrayList lub ArrayList.

          --Coding to interfaces, not implementation--
        */

        //1. Listy (List)
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> stack = new Stack<>();

        //Dodawanie elementow do listy
        List<String> arrayList1 = new ArrayList<>();
        //Lista z tablicy (przekazana tablica do asList() powinna byc Wrapperem dla typu prymitywnego)
        List<String> listToAdd = Arrays.asList("A", "B", "C");
        //Niemutowalna lista (JDK 9+)
        List<String> listListOf = List.of("Pierwszy", "Drugi", "Trzeci");
        arrayList1.add("A"); // dodaje na koniec
        arrayList1.add(1, "B"); // dodaje pod konkretnym indeksem
        arrayList1.addAll(listToAdd); // dodaje do listy druga liste
        arrayList1.addAll(1, listToAdd); // dodaje do listy druga liste pod konkretny indeks

        arrayList1.forEach(System.out::println);

        //2. Kolejki (Queue)
        Queue<String> priorityQueue = new PriorityQueue<>();
        Queue<String> arrayDequeue = new ArrayDeque<>();

        //3. Zbiory (Set)
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();

        //4. Mapy (Map)
        //Aby poprawnie uzywac map nalezy zaimplementowac hashCode() i equals()!
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        Map<Days, String> enumMap = new EnumMap<>(Days.class);
        Map<Integer, String> identityHashMap = new IdentityHashMap<>();
        Map<Integer, String> weakHashMap = new WeakHashMap<>();

        //HashMap<K,V>
        Map<String, Integer> hashMapTest = new HashMap<>();
        hashMapTest.put("D", 56);
        hashMapTest.put("C", 81);
        hashMapTest.put("B", 19);
        hashMapTest.put("A", 53);
        System.out.println("HashMap");
        //Iteracja
        //1.
        System.out.println("Iteracja poprzez klucze:");
        for (String key : hashMapTest.keySet()) {
            System.out.println(hashMapTest.get(key));
        }
        //2.
        System.out.println("Iteracja poprzez Map.Entry:");
        for (Map.Entry<String, Integer> entry : hashMapTest.entrySet()) {
            System.out.println("Klucz: " + entry.getKey() + ", wartosc: " + entry.getValue());
        }
        //3.
        System.out.println("Iteracja poprzez wartosci:");
        List<Integer> listFromHashSet = new ArrayList<>(hashMapTest.values());
        listFromHashSet.forEach(System.out::println);
        //4.
        System.out.println("Iteracja poprzez Iterator: klucz + wartosc");
        Iterator<String> iterator1 = hashMapTest.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println("Klucz:" + key + " wartosc: " + hashMapTest.get(key));
        }

        System.out.println("Iteracja poprzez Iterator: wartosc");
        Collection<Integer> values = hashMapTest.values(); // Collection<T> poniewaz taki typ zwraca metoda values()
        Iterator<Integer> iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            System.out.println("Wartosci:" + iterator2.next());
        }

        System.out.println("Iteracja poprzez Iterator: Map.Entry");
        Set<Map.Entry<String, Integer>> entries = hashMapTest.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            System.out.println(entryIterator.next());
        }
        //Iteracja poprzez forEach i wyrazenia lambda
        System.out.println("Iteracja poprzez forEach i wyrazenia lambda:");
        hashMapTest.forEach((key, value) -> System.out.println("Klucz:" + key + " wartosc:" + value));

        //EnumMap
        Map<Days, Integer> enumMapTest = new EnumMap<>(Days.class);
        enumMapTest.put(Days.MONDAY, 1);
        enumMapTest.put(Days.TUESDAY, 2);
        enumMapTest.put(Days.WEDNESDAY, 3);
        enumMapTest.putAll(
                new HashMap<>(Map.of(
                        Days.FRIDAY, 5,
                        Days.SATURDAY, 6)
                ));
        enumMapTest.forEach((enumKey, value) -> System.out.println("Klucz enum:" + enumKey + " wartosc:" + value));

        // Ciekawe przypadki:

        //    Zamiana List na Collection:
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3));
        // Collection<Integer> numbers1 = new ArrayList<>(List.of(1,2,3));
        System.out.println(numbers1);      //   [1, 2, 3]
        //W sytuacji gdy interfejsem jest List = [1, 3]
        //W sytuacji gdy interfejsem jest Collection = [2, 3]
        numbers1.remove(1);
        System.out.println(numbers1);
        /*
        Wynika to z tego ze:
        Collection<T>  - remove(T)          object <--
        List<T>        - remove(int index)  index  <--
        Dochodzi do polimorfizmu, optymalizacji i przysłoniecia metody z indexem.
        Polimorfizm nie uwzględnia typu parametrów w czasie wykonywania. Jest to rozwiązane w czasie kompilacji
        */

        //Zamiana Collection na var:
        Collection<Integer> numbers2 = new ArrayList<>(List.of(1, 2, 3));
        // var numbers2 = new ArrayList<>(List.of(1,2,3));
        System.out.println(numbers2);      //   [1, 2, 3]
        //W sytuacji gdy interfejsem jest Collection = [2, 3]
        //W sytuacji gdy jest var = [1, 3] poniewaz implementacja jest ArrayList<>
        numbers2.remove(1);
        System.out.println(numbers2);

        // Arrays.asList() vs List.of()
        //Arrays.asList() - nie jest niemutowalna, moze wykonac metode set()
        List<Integer> numbers3 = Arrays.asList(1, 2, 3);
        try {
            numbers3.add(4); // nie wykona sie
        } catch (Exception e) {
            System.out.println("add unsupported");
        }
        try {
            numbers3.set(2, 2); // wykona sie
        } catch (Exception e) {
            System.out.println("set unsupported");
        }
        System.out.println(numbers3);

        //List.of() - niemutowalna
        //Map.of()
        //Set.of() - nie pozwala dodawac takich samych elementow
        //metoda of() nie zezwala na null
        List<Integer> numbers4 = List.of(1, 2, 3);
        try {
            numbers4.add(4);   // nie wykona sie
        } catch (Exception e) {
            System.out.println("add unsupported");
        }
        try {
            numbers4.set(2, 2); // nie wykona sie
        } catch (Exception e) {
            System.out.println("set unsupported");
        }
        System.out.println(numbers4);

        //stream() i parallelStream()
        //Kod generujacy bład
        System.out.println("Kod generujacy blad");
        for (int i = 0; i < 100; i++) {
            List<String> names = List.of("David", "Bruce", "Nemo", "Eva", "Dory", "John", "Alex");
            List<String> inUppercase = new ArrayList<>();

            // W sytuacji gdy uzyjemy stream() bład nie wystapi,
            // natomiast gdy uzyjemy parallelStream() dojdzie do błedu ktory spowoduje zgubienie elementow
            names.parallelStream()
                    .map(String::toUpperCase)
                    .forEach(name -> inUppercase.add(name)); // Nie wolno tak robic!
            // mutowalnosc - ok
            // dzielenie  - ok
            // dzielenie mutowalnosci - BARDZO ŹLE!

            System.out.println(names.size()); // 7
            System.out.println(inUppercase.size()); // np. 6
        }

        //Poprawny kod
        System.out.println("Kod poprawny");
        for (int i = 0; i < 100; i++) {
            List<String> names = List.of("David", "Bruce", "Nemo", "Eva", "Dory", "John", "Alex");
            List<String> inUppercase = names.parallelStream()
                    .map(String::toUpperCase)
                    .toList(); //Poprawny zapis

            System.out.println(names.size()); // 7
            System.out.println(inUppercase.size()); // 7
        }

        //Lambdy i czystość funkcji
        /* "Rules of purity" w kontekście lambd w języku Java odnosi się do zasad związanych z programowaniem funkcyjnym
         i utrzymaniem czystości funkcji, czyli funkcji, które nie mają efektów ubocznych i zwracają wartość tylko
         na podstawie swoich argumentów.
         Zasady:
            1. Lambda powinna unikać modyfikacji zmiennych spoza zakresu lambda (tzw. zmiennych "captured" z otoczenia).
            2. Unikaj modyfikacji stanu obiektów spoza lambdy, które nie są finalne ani efektywnie finalne.
            3. Unikaj korzystania ze zmiennych globalnych lub stanu programu wewnątrz lambdy.
            4. Zmienna, która jest używana w lambdzie, powinna być efektywnie finalna lub finalna,
               co oznacza, że nie może być modyfikowana po raz drugi po przypisaniu.
            5. Unikaj rzucania wyjątków w lambdzie, szczególnie tych, które nie są wymienione w sygnaturze funkcji interfejsu.
            Zasady czystości w lambdach pomagają zachować przejrzystość, przewidywalność i testowalność kodu.
            Programowanie funkcyjne promuje tworzenie funkcji, które są izolowane od otaczającego środowiska,
            co ułatwia ich testowanie i utrzymanie. */
        // Kod ktory nie jest "czysty"
        System.out.println("Brak zachowania zasad czystosci funkcji");
        int[] mnoznik = new int[]{2};
        List<Integer> integers1 = List.of(1, 2, 3);

        Stream<Integer> stream = integers1.stream()
                .map(n -> n * mnoznik[0]);

        mnoznik[0] = 0;
        stream.forEach(System.out::println);
        /*
        W jezykach takich jak Java, C#, Python zawsze lazy
        W jezykach takich jak Kotlin, Scala mozna wybrac czy bedzie lazy czy eager
         */

        //Stream - parallel() czy sequential()?
        // Stream (Java 8) nie dziela wykonywania podczas przepływu w streamie.
        // Wynika to z tego ze priorytet ma ostatnie wywolanie (przed wywolaniem terminalnym) sequential() lub parallel()
        // Mozna uzyc Reactive Stream
        List.of(1, 2, 3).stream()
                .parallel()
                .map(number -> transform(number))
                .sequential()
                .forEach(number -> print(number));

        //toList() vs collect() dla List i Set

        List<Integer> integers2 = List.of(1, 2, 3);
        List<Integer> doubled = integers2.stream()
                .map(i -> i * 2)
                // .collect(Collectors.toList());             //mutowalna
                // .collect(Collectors.toUnmodifiableList()); //niemutowalna
                .toList();                                    //niemutowalna

        System.out.println(doubled);
        System.out.println(doubled.getClass());

        //copyOf() gdy lista jest mutowalna i niemutowalna
        List<Integer> integersA = Arrays.asList(1, 2, 3); //mutowalna
        List<Integer> integersB = List.of(1, 2, 3);       //niemutowalna

        System.out.println(integersA == List.copyOf(integersA));  //false
        System.out.println(" ");
        System.out.println(integersB == List.copyOf(integersB));  //true
        //Wynika to z tego ze w celu optymalizacji nie jest tworzona nowa lista
        //poniewaz jest niemutowalna wiec jest bezpieczna do dzielenia i kopiowania.
        //W pierwszym przypadku gdy jest mutowalna nalezy stworzyc nowa

        //Stream i wykonywanie rownolegle operacji zwracajac wiele wartosci
        List<Integer> integers3 = Arrays.asList(8, 4, 7, 1, 34, 9, 99);

        Optional<Integer> min = integers3.stream().collect(Collectors.minBy(Comparator.comparing(e -> e)));
        Optional<Integer> max = integers3.stream().collect(Collectors.maxBy(Comparator.comparing(e -> e)));
        System.out.println(min + " | " + max);

        //Mozna uzyc Collectors.teeing()
        List<Optional<Integer>> result = integers3.stream()
                .collect(Collectors.teeing(
                        Collectors.minBy(Comparator.comparing(e -> e)),
                        Collectors.maxBy(Comparator.comparing(e -> e)),
                        (value1, value2) -> List.of(value1, value2)
                ));

        System.out.println(result);
    }


    //Stream - parallel() czy sequential()?
    public static int transform(int number) {
        System.out.println("transform:" + Thread.currentThread());
        return number * 2;
    }

    public static void print(int number) {
        System.out.println("print:" + Thread.currentThread());
    }
    // <-Stream - parallel() czy sequential()?
}
