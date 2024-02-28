package HomeWork004;


public class Main {
    public static void main(String[] args) {
        SetEmployees set = new SetEmployees();
        System.out.println(set);
        set.add(131, "99999", "John", 90);
        System.out.println(set);
        System.out.println("======");
        System.out.println(set.findEmployForExperience(1,5));
        System.out.println(set.findPhoneForName("John"));
        System.out.println(set.findEmployForServiceNumber(125));
    }
}
