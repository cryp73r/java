import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class App {
    public static void main(String[] args) throws Exception {
        Path filePath=null;

        try {
            filePath=Path.of("text.txt");
        } catch (InvalidPathException e) {
            System.out.println("Invalid Path Exception: "+e);
        }
        
        try (FileChannel fChan=(FileChannel) Files.newByteChannel(filePath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // Create Buffer
            ByteBuffer mBuff=ByteBuffer.allocate(26);

            // Write some bytes to the buffer
            for (int i=0; i<26; i++) {
                mBuff.put((byte) ('A'+i));
            }

            // Reset the buffer so that it can be written
            mBuff.rewind();

            // Write the buffer to the output file
            fChan.write(mBuff);
        } catch (IOException e) {
            System.out.println("I/O Error: "+e);
        }
    }
}
