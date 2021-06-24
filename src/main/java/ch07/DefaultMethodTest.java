package ch07;

interface MyInterface{
    default void method1(){
        System.out.println("method1() in MyInterface");
    }

    default void method2(){
        System.out.println("method2() in MyInterface");
    }

    static void staticMethod(){
        System.out.println("staticMethod() in MyInterface");
    }
}

interface MyInterface2{
    default void method1(){
        System.out.println("method1() in MyInterface2");
    }

    static void staticMethod(){
        System.out.println("staticMethod() in MyInterface2");
    }
}

class DefaultParent{
    public void method2() {
        System.out.println("method2() in DefaultParent");
    }
}

class DefaultChild extends DefaultParent implements MyInterface, MyInterface2{
    public void method1() {
        System.out.println("method1() in DefaultChild");
    }
}

public class DefaultMethodTest {
    public static void main(String[] args) {
        DefaultChild c = new DefaultChild();
        c.method1();
        c.method2();
        MyInterface.staticMethod();
        MyInterface2.staticMethod();
    }
}
