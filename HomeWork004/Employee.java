package HomeWork004;

public class Employee {
    private int ServiceNumber;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(int serviceNumber, String phoneNumber, String name, int experience) {
        ServiceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    public int getServiceNumber() {
        return ServiceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "ID=" + ServiceNumber +
                ", phone='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                "\n";
    }
}
