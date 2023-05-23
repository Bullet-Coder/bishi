package lambda;

public class Cat implements Comparable<Cat>{
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(){}

    public void print() {
        System.out.println("Mero");
    }

    @Override
    public int compareTo(Cat other) {
        return this.age - other.age ;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
