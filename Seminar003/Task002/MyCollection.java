package Seminar003.Task002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollection<E> implements Iterable<E>{
    private Object[] array;
    private int size;

    public MyCollection() {
        array = new Object[10];
    }
    public MyCollection<E> add(E element) {
        if (size >= array.length) {
            Object[] newArray = new Object[size + 10];
            System.arraycopy(array,0, newArray,0, size);
            array = newArray;
        }
        array[size++] = element;
        return this;
    }
    public void remove(int index) {
        if (index >= size || index < 0) {
            return;
        }
        System.arraycopy(array,index + 1,array, index, size - index);
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(", ");
        }
//        Arrays.stream(array).forEach(x->sb.append(x).append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((E)array[i]);
        }
        return new MyIterator<>(list);
    }
}
