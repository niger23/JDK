package HomeWork004;

import java.util.ArrayList;
import java.util.List;

public class SetEmployees {
    private List<Employee> set = new ArrayList<>();

    public SetEmployees(List<Employee> set) {
        this.set = set;
    }

    public SetEmployees() {
        List<Employee> defaultSet = new ArrayList<>();
        defaultSet.add(new Employee(123, "1345", "John", 1));
        defaultSet.add(new Employee(124, "2345", "James", 4));
        defaultSet.add(new Employee(125, "3345", "Kelly", 8));
        defaultSet.add(new Employee(126, "4345", "Will", 13));
        defaultSet.add(new Employee(127, "5345", "Anna", 1));
        defaultSet.add(new Employee(128, "6345", "Lucy", 5));
        defaultSet.add(new Employee(129, "7345", "Poll", 1));
        defaultSet.add(new Employee(130, "8345", "John", 4));
        this.set = defaultSet;
    }
    public void add (int serviceNumber, String phoneNumber, String name, int experience) {
        set.add(new Employee(serviceNumber, phoneNumber, name, experience));
    }
    public List<Employee> findEmployForExperience (int expMin, int expMax) {
        List<Employee> list = new ArrayList<>();
        for (Employee emp : set) {
            if (emp.getExperience() >= expMin && emp.getExperience() <= expMax) {
                list.add(emp);
            }
        }
        return list;
    }
    public List<String> findPhoneForName (String findName) {
        List<String> res = new ArrayList<>();
        for (Employee employee : set) {
            if (employee.getName().equals(findName)) {
                res.add(employee.getPhoneNumber());
            }
        }
        return res;
    }
    public List<Employee> findEmployForServiceNumber (int num) {
        return set.stream().filter(s -> s.getServiceNumber() == num).toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : set) {
            sb.append(employee.toString());
        }
        return sb.toString();
    }
}
