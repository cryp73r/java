// An enumeration of Apple varieties
enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class App {
    public static void main(String[] args) throws Exception {
        Apple apple;
        apple=Apple.RedDel;

        // Output an enum value
        System.out.println("Value of apple: "+apple);
        System.out.println();

        apple=Apple.GoldenDel;
        if (apple==Apple.GoldenDel) {
            System.out.println("Apple contains GoldenDel");
            System.out.println();
        }

        // Use an enum to control switch statement
        switch (apple) {
            case Jonathan:
                System.out.println("Jonathan is red");
                break;
            case GoldenDel:
                System.out.println("Golden Delicious is yellow");
                break;
            case RedDel:
                System.out.println("Red Delicious is red");
                break;
            case Winesap:
                System.out.println("Winesap is red");
                break;
            case Cortland:
                System.out.println("Cortland is red");
                break;
        }
        System.out.println();

        // Use values() and valueOf() on enum
        Apple[] allApples=Apple.values();
        for (Apple ap : allApples) {
            System.out.println(ap);
        }
        System.out.println();

        apple=Apple.valueOf("Winesap");
        System.out.println("apple contains "+apple);
    }
}