import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.google.co.in");
        HttpURLConnection http= (HttpURLConnection) url.openConnection();

        // Display request method
        System.out.println("Request method is "+http.getRequestMethod());

        // Display response code
        System.out.println("Response code is "+http.getResponseCode());

        // Display response message
        System.out.println("Response message is "+http.getResponseMessage());

        // Get list of the header fields and a set of header keys
        System.out.println("Here is the header");
        Map<String, List<String>> hdrMap=http.getHeaderFields();
        Set<String> hdrFeilds=hdrMap.keySet();
        for (String s : hdrFeilds) {
            System.out.println("Key: "+s+" Value: "+hdrMap.get(s));
        }
    }
}
