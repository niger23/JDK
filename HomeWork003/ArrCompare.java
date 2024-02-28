package HomeWork003;

public class ArrCompare {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].getClass().equals(arr2[i].getClass())) {
                return false;
            }
        }
        return true;
    }
    public static String printArr(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer[] intArr1 = {1, 2, 3};
        Integer[] intArr2 = {1, 2, 3};
        Integer[] intArr3 = {2, 3, 4};

        String[] strArr1 = {"Nick", "Anna", "Nick"};
        String[] strArr2 = {"Nick", "Anna", "Nick"};
        String[] strArr3 = {"Anna", "Anna", "123"};

        System.out.println(printArr(intArr1) + " = " + printArr(intArr2) + " : " + compareArrays(intArr1, intArr2));
        System.out.println(printArr(intArr1) + " = " + printArr(intArr3) + " : " + compareArrays(intArr1, intArr3));
        System.out.println(printArr(strArr1) + " = " + printArr(strArr2) + " : " + compareArrays(intArr1, intArr2));
        System.out.println(printArr(strArr1) + " = " + printArr(strArr3) + " : " + compareArrays(intArr1, intArr3));

    }
}
