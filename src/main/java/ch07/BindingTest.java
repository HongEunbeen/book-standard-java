package ch07;

public class BindingTest {
    public static void main(String[] args) {
        ParentBind p = new ChildBind();
        ChildBind c = new ChildBind();

        System.out.println(p.x);
        p.method();

        System.out.println(c.x);
        c.method();
    }
}

class ParentBind{
    int x = 100;

    void method(){
        System.out.println("Parent Bind");
    }
}

class ChildBind extends ParentBind{
    int x = 200;

    void method(){
        System.out.println("Child Bind");
    }
}
