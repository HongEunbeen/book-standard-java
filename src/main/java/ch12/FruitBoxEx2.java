package ch12;

import java.util.ArrayList;

interface Eatable{ }

class Fruit1 implements Eatable {
    public String toString(){return "Fruit";}
}

class Apple1 extends Fruit1 {public String toString() {return "Apple";}}
class Grape1 extends Fruit1 {public String toString(){return "Grape";}}
class Toy1 {public String toString(){return "Toy";}}

class FruitBox<T extends Fruit & Eatable> extends Box1<T>{}

class Box1<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item){list.add(item);}
    T get(int i) {return list.get(i);}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}

public class FruitBoxEx2 {
    public static void main(String[] args) {

    }
}
