/**
 * Created by Raman on 27/12/2016.
 */
public class Employee {
    private String fio;
    private String rank;
    private String email;
    private int phone;
    private double salary;
    private int age;

    public Employee(String fio, String rank, String email, int phone, double salary, int age) {
        this.fio = fio;
        this.rank = rank;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("FIO: " + fio + " Rank: " + rank + " e-mail: " + email +
                " Phone: " + phone + " Salary: " + salary + " Age: " + age);
    }

    public int getAge() {
        return age;
    }
}
