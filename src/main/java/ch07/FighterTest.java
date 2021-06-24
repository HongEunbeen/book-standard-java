package ch07;

interface Attackable{
    void attack(Unit u);
}

interface Movable{
    void move(int x, int y);
}

interface Fightable extends Attackable, Movable{

}

class Unit{
    int x;
    int y;
    int currentHp;
}

class Fighter extends Unit implements Fightable{
    @Override
    public void attack(Unit u) {

    }

    @Override
    public void move(int x, int y) {

    }
}

public class FighterTest {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();
    }
}
