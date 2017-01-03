/**
 * Created by Raman on 27/12/2016.
 */
public class OOP {
    public static void main(String[] args) {
        Employee[] emplArr = new Employee[5];
        emplArr[0] = new Employee("Ivanov Ivan Ivanovich", "Accountant", "ivanov@mail.corp", 5552837, 22000, 40);
        emplArr[1] = new Employee("Petrov Petr Petrovich", "Driver", "petrov@mail.corp", 4442838, 12000, 35);
        emplArr[2] = new Employee("Sidorov Sidor Sidorovich", "Boss", "sidorov@mail.corp", 6662836, 32000, 45);
        emplArr[3] = new Employee("Kalashnikov Evgeniy Vasilievich", "Mechanist", "kalashnikov@mail.corp", 7772837, 23000, 39);
        emplArr[4] = new Employee("Kats Izmail Izrailevich", "Zam", "kats@mail.corp", 3332833, 25000, 38);

        for (int i = 0; i < emplArr.length; i++) {
            if (emplArr[i].getAge() > 40) emplArr[i].info();
        }

        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Barsik");
        animals[1] = new Dog("Barbos");
        animals[2] = new Horse("Berezka");

        for (int i = 0; i < animals.length; i++) {
            animals[i].info();
            animals[i].run(100);
            animals[i].swim(50);
            animals[i].jump(2);
            System.out.println();
        }
    }
}