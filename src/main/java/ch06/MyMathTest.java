package ch06;

public class MyMathTest {
    public static void main(String[] args){
        MyMath mm = new MyMath();
        long result = mm.add(5L, 3L);
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L); //double로 자동 형변환 된다.

        System.out.println("result = " + result);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

    }
}
class MyMath{
    long add(long a, long b){
        long result = a+b;
        return result;
    }

    long subtract(long a, long b){return a - b;}
    long multiply(long a, long b){return a * b;}
    double divide(double a, double b){
        return a / b;
    }

}