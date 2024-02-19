package Seminar003.Task001;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

public class MoreCommonClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> extends CommonClass<T, V, K>{
    public MoreCommonClass(T t, V v, K k) {
        super(t, v, k);
    }
}
