import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        int ch;

        // Create a socket connected to internic.net, port 43
        Socket socket=new Socket("whois.apnic.net", 43);

        // Obtain Input and Output Stream
        InputStream in=socket.getInputStream();
        OutputStream out=socket.getOutputStream();

        // Construct a request message
        String message=(args.length==0)?"github.com":args[0];

        // Converts to byte
        byte buff[]=message.getBytes();

        // Send request
        out.write(buff);

        // Read and display message
        while ((ch=in.read())!=-1) {
            System.out.print((char) ch);
        }
        socket.close();
    }
}
