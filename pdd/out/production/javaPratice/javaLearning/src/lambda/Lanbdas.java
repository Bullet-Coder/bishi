package lambda;

import java.util.*;

public class Lanbdas {
    public static void main(String[] args) {
//        Cat myCat = new Cat();
        Printable lambdaPrintablr = s -> System.out.println("Mero" + s);
        printThing(lambdaPrintablr);

        Integer[] a = new Integer[]{7,5,89,9,6,2,4,7};
        List<Integer> ls= new ArrayList<>(List.of(a));
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        List<Cat> cats = new ArrayList<>();
        Cat cat1 = new Cat("c1", 54);
        Cat cat2 = new Cat("c2", 48);
        Cat cat3 = new Cat("c3", 59);
        Cat cat4 = new Cat("c4", 32);
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        ls.sort(compare);
        Collections.sort(cats);
        for(Cat c : cats){
            System.out.println(c);
        }
        Collections.sort(ls, (o1, o2) -> o2 - o1);
    }

    static  void  printThing(Printable thing){
        thing.print("!");
    }

}
