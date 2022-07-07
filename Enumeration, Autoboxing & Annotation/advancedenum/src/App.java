enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

    private int price;  // price of each apple

    // Apple Constructor
    Apple(int p) {price=p;}

    int getPrice() {return price;}
}

enum AppleVar {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class App {
    public static void main(String[] args) throws Exception {

        // Display price of Winesap
        System.out.println(Apple.Winesap+" costs "+Apple.Winesap.getPrice()+" rupees");
        System.out.println();

        // Display all apples and prices
        System.out.println("All apple prices are:");
        for (Apple apple : Apple.values()) {
            System.out.println("-> "+apple+" costs "+apple.getPrice()+" rupees");
        }
        System.out.println();

        // ordianl(), compareTo() and equals()
        AppleVar apple, apple2, apple3;

        // Obtain all ordinal values using ordinal()
        System.out.println("Here are apple constants and respective ordinal values");
        for (AppleVar ap : AppleVar.values()) {
            System.out.println(ap+" : "+ap.ordinal());
        }
        System.out.println();
        
        apple=AppleVar.RedDel;
        apple2=AppleVar.GoldenDel;
        apple3=AppleVar.RedDel;

        // Use compareTo()
        if (apple.compareTo(apple2)<0) {
            System.out.println(apple+" comes before "+apple2);
        }
        if (apple.compareTo(apple2)>0) {
            System.out.println(apple+" comes after "+apple2);
        }
        if (apple.compareTo(apple3)==0) {
            System.out.println(apple+" equals "+apple3);
        }
        System.out.println();

        // Use equals()
        if (apple.equals(apple2)) {
            System.out.println("Error!");
        }
        if (apple.equals(apple3)) {
            System.out.println(apple+ " equals "+apple3);
        }

        // Use ==
        if (apple==apple3) {
            System.out.println(apple+" == "+apple3);
        }
    }
}