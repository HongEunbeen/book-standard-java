package ch07;

public class InnerEx1 {
    class InstanceInner{
        int iv = 100;
        //static int cv = 100;
        //상수는 허용 ?
        final static int COUNT = 1;
        //final과 static이 동시에 붙은 변수는 상수로 모든 내부 클래스에서 정의가 가능하다.
    }

    static class StaticInner{
        int iv = 200;
        static int cv = 200;
    }

    void myMethod(){
        class LocalInner{
            int iv = 300;
            //static int cv = 200;
            final static int CONST = 20;
        }
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.COUNT);
        //System.out.println(StaticInner.tv); -> static 클래스 안에 있다고 하더라도 new 를 해줘야 멤버 변수 사용이 가능하다.
        System.out.println(StaticInner.cv); // static 클래스만 static 멤버를 정의한다.
    }

}
