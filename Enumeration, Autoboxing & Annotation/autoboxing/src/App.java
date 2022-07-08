public class App {
    public static void main(String[] args) throws Exception {
        Integer iob, iob2;
        int i;
        
        iob=100;
        System.out.println("Original Value of iob: "+iob);

        // The following automatically unboxes iob,
        // performs the increment, and then reboxes
        // the result back into iob
        ++iob;
        System.out.println("After ++iob: "+iob);
        
        // Here iob is unboxed, the expression is
        // evaluated, the result is reboxed and
        // assigned to iob2
        iob2=iob+(iob/3);
        System.out.println("iob2 afetr expression: "+iob2);
        
        // the same epression is evaluated, but the
        // result is not reboxed
        i=iob+(iob/3);
        System.out.println("i after expression: "+i);
    }
}
