package ch12;

enum Direction{EAST, SOUTH, WEST, NORTH}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");
        
        Direction[] dArr = Direction.values();
        
        for(Direction d : dArr){
            System.out.println("d.name() + d.ordinal() = " + d.name() + d.ordinal());
        }
    }
}
