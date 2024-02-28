package Seminar004;

//В рамках выполнения задачи необходимо:
//1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
//2. Найдите человека с самым маленьким номером телефона
//3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("123","John");
        map.putIfAbsent("234","Leo");
        map.putIfAbsent("32423","Maria");
        map.putIfAbsent("911","Police");
        map.putIfAbsent("23111","Kelly");
        System.out.println(findSmallPhoneStream(map));
        System.out.println(findSmallPhoneMap(map));
        System.out.println(findPhoneBigNameStream(map));

    }
    public static String findSmallPhoneStream(Map<String,String> map) {
        return map.keySet().stream().min(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        }).orElse("");
    }
    public static String findSmallPhoneMap(Map<String,String> map) {
        return String.valueOf(map.keySet().stream().map(Integer::parseInt).min(Comparator.naturalOrder()).orElse(null));
    }
    public static String findPhoneBigNameStream(Map<String,String> map) {
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}
