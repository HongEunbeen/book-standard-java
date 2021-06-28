package ch07;

interface I{
    public abstract void methodB();
}
class InstanceManager{
    public static I getInstance(){
        return new InterfaceB();
    }
}

class InterfaceA{
    void methodA(){
        I i = InstanceManager.getInstance();
        i.methodB();
        System.out.println(i.toString());
    }
}

class InterfaceB implements I{
    public void methodB(){
        System.out.println("methodB in B class");
    }
    public String toString(){return "class b";}
}

public class InterfaceTest {
    public static void main(String[] args) {
        InterfaceA a = new InterfaceA();
    }

}
