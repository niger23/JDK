package Lesson004;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1,2,3,4,5);
//        1 Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
//        2 for each
        for (Integer i : collection) {
            System.out.print(i + " ");
        }
        System.out.println();
//        3 Stream API
        collection.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
        collection.stream().forEach(System.out::print);
        System.out.println();

        ArrayList<Integer> list = new ArrayList<>(collection);

        Map<String, Integer> map = Map.of("Hello", 1, "World",2);
//        1 for each
        for (var entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
//        2 iterator
        for (String s : map.keySet()) {
            System.out.println(s + ": " + map.get(s));
        }
//        3 Stream API
        map.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
