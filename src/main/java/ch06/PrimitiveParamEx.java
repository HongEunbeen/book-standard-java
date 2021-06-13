package ch06;

class Data{int x;}
public class PrimitiveParamEx {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println(d.x);
    }

    static void change(int x){
        x = 1000;
        System.out.println("x = " + x);
    }
}
