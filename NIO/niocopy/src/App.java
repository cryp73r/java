import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class App {
    public static void main(String[] args) throws Exception {
        
        if (args.length!=2) {
            System.out.println("Usage: Copy from to");
            return;
        }

        try {
            Path source=Path.of(args[0]);
            Path target=Path.of(args[1]);

            // Copy the file
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Path Error: "+e);
        } catch (IOException e) {
            System.out.println("I/O Error: "+e);
        }
    }
}
