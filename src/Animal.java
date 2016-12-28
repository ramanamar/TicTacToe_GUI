/**
 * Created by Raman on 28/12/2016.
 */
public abstract class Animal {
    protected String name;
    protected String type;
    protected int runDist;
    protected int swimDist;
    protected float jumpHeight;

    public Animal(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(type + " " + name);
    }

    public void run() {
        System.out.println(type + " " + name + " running " + runDist + " m.");
    }

    public void swim() {
        System.out.println(type + " " + name + " swimming " + swimDist + " m.");
    }

    public void jump() {
        System.out.println(type + " " + name + " jumping " + jumpHeight + " m.");
    }
}
