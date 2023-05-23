package Generics;

public class Animal {
    private int id ;
    private String name;
    private String shout;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shout='" + shout + '\'' +
                '}';
    }

    public Animal() {
        System.out.println("调用了父类无参构造器");
    }

    public Animal(String name, int myid, String shout){
        this.name = name;
        id = myid;
        this.shout = shout;
        System.out.println("调用了父类有参构造器");
    }
    public void eat(){
        System.out.println( name +"正在吃");
    }

    public void sleep(){
        System.out.println(name + "正在睡");
    }

    public void introduction(){
        System.out.println("大家好，我是" + id + "号" + name + ".");
    }
}

class Cat extends Animal{
    private final static String s = "meao";
    public Cat() {
        System.out.println("调用了Cat无参构造器");
    }

    public Cat(String name, int myid){

        super(name, myid, s);
        System.out.println("调用了Cat有参构造器");

    }

}

class Dog extends Animal{
    private final static String s = "woof";
    public Dog(){
        System.out.println("调用了dog无参构造器");

    }

    public Dog(String name, int myid){
        super(name, myid, s);
        System.out.println("调用了dog有参构造器");

    }


}