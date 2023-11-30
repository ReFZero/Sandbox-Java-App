package pl.ReFZero.apacheCommonsCollection;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.bag.*;
import org.apache.commons.collections4.set.TransformedSet;

import java.util.*;

public class apacheCommonsClass {
    /* Wymagana zaleznosc: "commons-collections4"
    1. Bag - przechowuje obiekty razem z liczba ich powtorzen
            - HashBag (Dekorator - CollectionBag)
            - TreeBag (Dekorator - CollectionSortedBag | SynchronizedSortedBag(synchroniozwany))
    2. Set  - SetUtils.predicatedSet - elementy moga byc dodane pod zdefiniowanym warunkiem (dodanie elementu nie spelniajacego warunku wyrzuci IllegalArgumentException)
            - SetUtils.SetView - zwraca set ktory zawiera roznice pomiedzy 2 setami (zwracany set jest immutable, aby zwrocic mutowalny nalezy uzyc metody toSet())
                           - SetUtils.difference - zwraca zbiór, który zawiera elementy z 1, które nie występują w zbiorze 2
                           - SetUtils.union - zwraca set z 2 setow
                           - SetUtils.intersection  - zwraca czesc wspolna dwoch setow
                           - SetUtils.transformedSet - umozliwia transformacje elelemtu podczas dodawania go do setu, set ktory jest zrodlem nie zostanie zmieniony
                           - TransformedSet.transformedSet - umozliwia transformacje elelemtu podczas dodawania go do setu, elementy z setu ktory jest zrodlem zostanie zmieniony
                           - SetUtils.disjunction - zwraca zbiór, który zawiera elementy, które występują w jednym z podanych zbiorów, ale nie w obu.
    3. Map  - OrderedMap (...)
                           */
    public static void main(String[] args) {

        // Dodano dekorator aby nie lamal kontraktu Java Collection (chodzi o metode add())
        // Dodawanie tego samego elelemntu do kolekcji zwracalo false, dlatego niezbedny jest dekorator

        Bag<String> hashBag = CollectionBag.collectionBag(new HashBag<>(Arrays.asList("A", "B", "B", "C", "A")));
        // dodaj "A" 5 razy do kolekci
        hashBag.add("A", 5);
        hashBag.forEach(System.out::println);
        //Wyswietl ile razy wystepuje podany obiekt
        System.out.println(hashBag.getCount("A"));

        //TreeBag lamie kontrakt dlatego dodano dekorator
        SortedBag<Integer> sortedBag = CollectionSortedBag.collectionSortedBag(
                new TreeBag<>(Arrays.asList(7, 5, 1, 7, 2, 3, 3, 3, 1, 4, 7)));
        sortedBag.forEach(System.out::println);

        //Synchronizowany Bag
        SynchronizedSortedBag<Integer> synchronizedSortedBag = SynchronizedSortedBag
                .synchronizedSortedBag(new TreeBag<>(Arrays.asList(7, 5, 1, 7, 2, 3, 3, 3, 1, 4, 7)));

        //PredicatedSet
        Set<String> names = new HashSet<>(List.of("Lena", "Lucy"));
        Set<String> validatingSet = SetUtils.predicatedSet(names, s -> s.startsWith("L"));

        //Roznice pomiedzy setami
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 5, 7));
        Set<Integer> b = new HashSet<>(Arrays.asList(1, 2));
        SetUtils.SetView<Integer> difference = SetUtils.difference(a, b); // immutable
        Set<Integer> mutableSet = difference.toSet(); // mutable
        System.out.println("difference");
        difference.forEach(System.out::println);

        ///Łaczy 2 sety
        SetUtils.SetView<Integer> union = SetUtils.union(a, b);
        System.out.println("union");
        union.forEach(System.out::println);

        // Zwraca elelemnty ktore sa wspolne dla 2 setow
        SetUtils.SetView<Integer> intersect = SetUtils.intersection(a, b);
        intersect.forEach(System.out::println);

        // Dodawnie elelemntow do setu powoduje wykonanie transformacji na nim
        Set<Integer> source = new HashSet<>(List.of(1, 3, 4));
        Set<Integer> c = SetUtils.transformedSet(source, e -> e * 2);
        c.add(10);
        System.out.println(c);

        Set<Integer> newSet = TransformedSet.transformedSet(source, e -> e * 2);
        System.out.println(newSet);

        // Zwraca zbiór, który zawiera elementy, które występują w jednym z podanych zbiorów, ale nie w obu
        Set<Integer> d = new HashSet<>(Arrays.asList(1, 2, 5, 7, 2));
        Set<Integer> e = new HashSet<>(Arrays.asList(1, 2, 3, 7));
        SetUtils.SetView<Integer> disjunction = SetUtils.disjunction(d, e);
        System.out.println(disjunction);
    }
}
