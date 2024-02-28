package Seminar004;

import java.util.*;

//В рамках выполнения задачи необходимо:
//1. Создайте коллекцию мужских и женских имен с помощью интерфейса List
//2. Отсортируйте коллекцию в алфавитном порядке
//3. Отсортируйте коллекцию по количеству букв в слове
//4. Разверните коллекцию

public class Main1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("John", "William", "Kat", "Maria"));
        sortByAlphabet(names);
        System.out.println(names);
        System.out.println("=======");
        sortSizeWorld(names);
        System.out.println(names);
        System.out.println(sortSizeWorldStream(names));
        returnList(names);
        System.out.println(names);

    }

    public static void sortByAlphabet(List<String> list) {
        Collections.sort(list);
    }
    public static void sortSizeWorld(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }
    public static List<String> sortSizeWorldStream(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }
    public static void returnList (List<String> list) {
        Collections.reverse(list);
    }

}
