package Lesson004;

import java.util.ArrayList;
import java.util.LinkedList;

public class HMap {
    private ArrayList <LinkedList<Integer>> map;
    private int capacity;

    public HMap(ArrayList<LinkedList<Integer>> map) {
        capacity = 100;
        map = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            map.add(new LinkedList<>());
        }
    }

    public void put(Integer key, Integer value) {
        int code = key.hashCode() % capacity;
        LinkedList<Integer> list = map.get(code);
        if (!list.contains(value)) {
            list.add(value);
        }
    }
}
