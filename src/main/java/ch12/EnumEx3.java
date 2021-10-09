package ch12;

enum Transportation{
    BUS(100) {int fare(int distance) {return distance*BASIC_FARE;}},
    TRAIN(150) {int fare(int distance) {return distance*BASIC_FARE;}},
    SHIP(100) {int fare(int distance) {return distance*BASIC_FARE;}},
    AIRPLAIN(300){int fare(int distance) {return distance*BASIC_FARE;}};

    protected final int BASIC_FARE;
    //protected로 해야 각 상수에서 접근가능

    Transportation(int baiscFare){
        BASIC_FARE = baiscFare;
    }

    public int getBASIC_FARE(){return BASIC_FARE;}
    //거리에 따른 요금 계산 추상메서드

    abstract int fare(int distance);
}

public class EnumEx3 {
    public static void main(String[] args) {
        Transportation.BUS.fare(100);
        Transportation.TRAIN.fare(100);
        Transportation.SHIP.fare(100);
        Transportation.AIRPLAIN.fare(100);
    }
}
