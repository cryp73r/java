import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtain a client that uses the default settings.
        HttpClient myHC=HttpClient.newHttpClient();

        // Create a request
        HttpRequest myReq=HttpRequest.newBuilder(new URI("http://www.google.com/")).build();

        // Send the request and get the response. Here, an InputStream is
        // used for the body.
        HttpResponse<InputStream> myRes=myHC.send(myReq, HttpResponse.BodyHandlers.ofInputStream());

        // Display response code and response method.
        System.out.println("Response code is "+myRes.statusCode());
        System.out.println("Request method is "+myReq.method());

        // Get headers from the response
        HttpHeaders hdrs=myRes.headers();

        // Get a map of the headers
        Map<String, List<String>> hdrMap=hdrs.map();
        Set<String> hdrField=hdrMap.keySet();

        System.out.println("\nHere is the header:");

        // Display all header keys and values
        for (String k : hdrField) {
            System.out.println("Key: "+k+" Value: "+hdrMap.get(k));
        }

        // Display the body
        System.out.println("\nHere is the body: ");
        InputStream input=myRes.body();
        int c;
        // Read and display the entire body
        while ((c=input.read())!=-1) {
            System.out.print((char) c);
        }
    }
}
