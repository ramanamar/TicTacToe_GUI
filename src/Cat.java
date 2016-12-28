/**
 * Created by Raman on 28/12/2016.
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
        type = "Cat";
        runDist = 200;
        jumpHeight = 2;
        swimDist = 0;
    }

    @Override
    public void swim() {
        System.out.println(name+" don't want to swim!");
    }
}
