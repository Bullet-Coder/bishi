package Generics;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        Animal animal = new Animal("??");
        Animal cat = new Animal("mero");*/
        Animal a = new Animal("小王", 1, null);
        Cat c1 = new Cat();
        Cat c2 = new Cat("猫咪", 3);
        Dog d1 = new Dog();
        Dog d2 = new Dog("二狗", 2);
        //        list.add(a);
//        list.add(c1);
        ArrayList<? extends Animal> list = new ArrayList<>(List.of(new Animal[]{a, c1, c2, d1, d2}));
//        list.add(new Cat());
        for (Animal animal : list) {
            System.out.println(animal);
        }
        Integer i = 5;
        String s = i.toString();
        System.out.println(i);
        Cat shout = shout(c2, "15");
        /*a.eat();
        d1.eat();
        c1.eat();
        a.introduction();
        d1.introduction();
        c1.introduction();
        Printer<Animal> printer = new Printer<>(a);
        Printer<Dog>  dogPrinter = new Printer<>(d);
        Printer<Cat>  catPrinter = new Printer<>(c);
        printer.print();
        dogPrinter.print();
        catPrinter.print();*/
    }

    private static <T, V> T shout(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout + "!!!!");
        System.out.println(otherThingToShout + "!!!!");
        return thingToShout;
    }

    private static void printList(List<? extends Animal> myList){

    }
}
