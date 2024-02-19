package HomeWork003;

public class Pair<K, V> {
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "[" + first + ", " + second + "]";
    }

    public static void main(String[] args) {
        Pair<Integer, String> pairFirstTest = new Pair<>(23, "I like number");
        Pair<Boolean, Float> pairSecondTest = new Pair<>(false, 2f);

        System.out.println(pairFirstTest);
        System.out.println(pairFirstTest.getFirst());
        System.out.println(pairFirstTest.getSecond());
        System.out.println("=================");
        System.out.println(pairSecondTest);
        System.out.println(pairSecondTest.getFirst());
        System.out.println(pairSecondTest.getSecond());
    }
}
