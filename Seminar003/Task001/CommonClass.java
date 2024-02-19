package Seminar003.Task001;

import java.io.DataInput;
import java.io.InputStream;

public class CommonClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number>{
    T someT;
    V someV;
    K someK;

    public CommonClass(T someT, V someV, K someK) {
        this.someT = someT;
        this.someV = someV;
        this.someK = someK;
    }

    public T getSomeT() {
        return someT;
    }

    public V getSomeV() {
        return someV;
    }

    public K getSomeK() {
        return someK;
    }
    public String getClassName() {
        StringBuilder sb = new StringBuilder();
        sb.append(someK.getClass().getSimpleName()).append("\n");
        sb.append(someV.getClass().getSimpleName()).append("\n");
        sb.append(someT.getClass().getSimpleName()).append("\n");
        return sb.toString();
    }
}
