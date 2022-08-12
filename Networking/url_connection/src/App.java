import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.google.com/search?q=google");
        URLConnection urlConnection=url.openConnection();

        // Get Date
        long date=urlConnection.getDate();
        if (date==0) {
            System.out.println("No date availabe");
        } else {
            System.out.println("Date: "+new Date(date));
        }

        // Get content-type
        System.out.println(urlConnection.getContentType());

        // Get expiration date
        date=urlConnection.getExpiration();
        if (date==0) {
            System.out.println("No expiration availabe");
        } else {
            System.out.println("Date: "+new Date(date));
        }

        long length=urlConnection.getContentLengthLong();
        if (length==-1) {
            System.out.println("No content availabe");
        } else {
            System.out.println("=====Content=====");
            int ch;
            InputStream in=urlConnection.getInputStream();
            while ((ch=in.read())!=-1) {
                System.out.print((char) ch);
            }
        }
    }
}
