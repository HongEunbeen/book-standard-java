package ch06;

class Car{
    String color;
    String gearType;
    int door;

    Car(){
        this("white", "auto", 4);
    }

    Car(Car c){
        this.color = c.color;
        this.gearType = c.gearType;
        this.door = c.door;
    }
    Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
public class CarTest3 {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1);
    }
}
