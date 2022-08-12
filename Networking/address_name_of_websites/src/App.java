import java.net.InetAddress;

public class App {
    public static void main(String[] args) throws Exception {
        InetAddress address=InetAddress.getLocalHost();
        System.out.println(address);

        address=InetAddress.getByName("www.google.co.in");
        System.out.println(address);

        byte add[]=new byte[]{127, 0, 0, 1};
        address=InetAddress.getByAddress(add);
        System.out.println(address.getHostName());

        InetAddress resolver[]=InetAddress.getAllByName("www.google.co.in");
        for (InetAddress addr : resolver) {
            System.out.println(addr);
        }
    }
}
