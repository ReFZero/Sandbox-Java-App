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
        while (iterator2.hasNext()){
            System.out.println("Wartosci:" + iterator2.next());
        }

        System.out.println("Iteracja poprzez Iterator: Map.Entry");
        Set<Map.Entry<String,Integer>> entries = hashMapTest.entrySet();
        Iterator<Map.Entry<String,Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()){
            System.out.println(entryIterator.next());
        }
        //Iteracja poprzez forEach i wyrazenia lambda
        System.out.println("Iteracja poprzez forEach i wyrazenia lambda:");
        hashMapTest.forEach((key, value) -> System.out.println("Klucz:" + key + " wartosc:" + value));

        //EnumMap
        Map<Days,Integer> enumMapTest = new EnumMap<>(Days.class);
        enumMapTest.put(Days.MONDAY,1);
        enumMapTest.put(Days.TUESDAY,2);
        enumMapTest.put(Days.WEDNESDAY,3);
        enumMapTest.putAll(
                new HashMap<>(Map.of(
                        Days.FRIDAY,5,
                        Days.SATURDAY,6)
        ));
        enumMapTest.forEach((enumKey, value)-> System.out.println("Klucz enum:" +enumKey + " wartosc:"+ value));
    }
}
