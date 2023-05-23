package Generics;

import java.io.Serializable;

public class Printer<T extends Animal, V >{
    T thingToPrint;
    V otherThingToShout;
    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        thingToPrint.eat();
        System.out.println(thingToPrint);
    }
}
