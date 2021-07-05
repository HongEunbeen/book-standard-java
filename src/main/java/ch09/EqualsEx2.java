package ch09;

public class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(880011L);
        Person p2 = new Person(880011L);

        if(p1 == p2){
            System.out.println("둘은 같은 사람");
        }
    }
}
class Person{
    long id;

    public boolean equals(Object obj){
        if(obj instanceof Person) return id == ((Person)obj).id;
        else return false;
    }

    Person(long id){
        this.id = id;
    }
}
