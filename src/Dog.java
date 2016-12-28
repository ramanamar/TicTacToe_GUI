/**
 * Created by Raman on 28/12/2016.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        type = "Dog";
        runDist = 1000;
        jumpHeight = 0.5f;
        swimDist = 300;
    }
}
