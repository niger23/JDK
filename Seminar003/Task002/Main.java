package Seminar003.Task002;

public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> arr= new MyCollection<>();
        arr.add(1).add(2).add(3).add(4).add(6);
        System.out.println(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }

    }
}
