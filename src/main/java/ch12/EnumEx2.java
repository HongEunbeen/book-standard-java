package ch12;

enum Direction2{
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value;
    private final String symbol;

    Direction2(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {return value;}
    public String getSymbol() {return symbol;}
    public static Direction2 of(int dir){
        if(dir < 1 || dir > 4){
            throw new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir-1];
    }
    public String toString(){
        return name() + getSymbol();
    }
}

public class EnumEx2 {
    public static void main(String[] args) {
        for(Direction2 d : Direction2.values()){
            System.out.println("d.name() + d.getValue() = " + d.name() + d.getValue());
        }

        Direction2 d1 = Direction2.EAST;
        Direction2 d2= Direction2.of(1);
    }
}
