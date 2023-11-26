package pl.ReFZero.generic;

import java.util.Arrays;
import java.util.List;

// Uzycie generycznosci
// Dla latwiejszej identyfikacji:
// E - Element
// K - Key
// N - Number
// T - Type
// V - Value
// A,B,C - dodatkowe typy
// ? (wildcard) - dowolny typ
// - T extends Number - wszystkie klasy dziedziczace po Number
// - T super Integer - wszystkie klasy które sa dziedziczone przez Integer
// - ? extends T (Wildcard Górny) - pozwala na przekazywanie typów, które są podtypami lub równorzędne z typem T.
// - ? super T (Wildcard Dolny) - pozwala na przekazywanie typów, które są nadtypami lub równorzędne z typem T.
public class GenericClass {
    public static void main(String[] args) {

        Box<String> stringBox = new Box<>("Text");
        String stringValue = stringBox.getValue();
        System.out.println(stringValue);

        Box<Integer> integerBox = new Box<>(123);
        Integer integer = integerBox.getValue();
        System.out.println(integer);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        showListElement(integerList);

        List<String> stringList = Arrays.asList("A", "B", "C");
        showListElement(stringList);

        List<Float> floatList = Arrays.asList(1.234F, 12.34F, 123.4F);

        multiplyingNumberList(integerList, 2);
        multiplyingNumberList(floatList, 2F);

        showListElement(integerList);
        showListElement(floatList);

    }

    public static <T> void showListElement(List<T> list) {
        list.forEach(System.out::println);
    }

    public static  <N extends Number> void multiplyingNumberList(List<N> list, N multiplyingBy) {
        for (int j = 0; j < list.size(); j++) {
            N element = list.get(j);
            list.set(j, multiply(element, multiplyingBy));
        }
    }

    private static <N extends Number> N multiply(N element, N multiplyingBy) {
        return switch (element) {
            case Integer i -> (N) Integer.valueOf(i * multiplyingBy.intValue());
            case Double d -> (N) Double.valueOf(d * multiplyingBy.doubleValue());
            case Long l -> (N) Long.valueOf(l * multiplyingBy.longValue());
            case Float f -> (N) Float.valueOf(f * multiplyingBy.floatValue());
            default -> throw new IllegalArgumentException("Unsupported number type");
        };
    }
}
