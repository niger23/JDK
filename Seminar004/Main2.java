package Seminar004;

import java.util.*;
import java.util.stream.Collectors;

//В рамках выполнения задачи необходимо:
//Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
//Получите уникальный список Set на основании List
//Определите наименьший элемент (алфавитный порядок)
//Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
//Удалите все элементы содержащие букву ‘A’

public class Main2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("John", "William", "Kat", "Maria", "Maria", "Maria"));
        Set<String> setNames = new HashSet<>(names);
        System.out.println(names);
        System.out.println(setNames);
        System.out.println(firstItemByAlpha(setNames));
        System.out.println(firstItemByLength(setNames));
        System.out.println(delElemStream(setNames));
        System.out.println("===");
        System.out.println(deleteElementWithA(setNames));

//        removeElementsWith(setNames, "a");
//        System.out.println(setNames);

    }
    public static String firstItemByAlpha(Set<String> names) {
        return names.stream().min(String::compareTo).orElse(null);
    }
    public static String firstItemByLength(Set<String> names) {
        return names.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }).orElse(null);
    }
    public static Set<String> deleteElementWithA (Set<String> names) {
        Set<String> result = new HashSet<>();
        for (String name : names) {
            if(!name.contains("a")) {
                result.add(name);
            }
        }
        return result;
    }
    public static Set<String> delElemStream (Set<String> names) {
        return names.stream().filter(x -> !x.contains("A") && !x.contains("a")).collect(Collectors.toSet());
    }
    public static void removeElementsWith(Set<String> set, String targetForDel) {
        set.removeIf(x -> x.contains(targetForDel));
    }


}
