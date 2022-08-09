import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        int count;
        Path filePath=null;

        try {
            filePath=Path.of("text.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path error: "+e);
            return;
        }

        try (SeekableByteChannel fChan=Files.newByteChannel(filePath)) {
            ByteBuffer mBuf=ByteBuffer.allocate(128);

            do {
                // Read a buffer
                count=fChan.read(mBuf);

                // Stop when EOF
                if (count!=-1) {
                    mBuf.rewind();
                    for (int i=0; i<count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count!=-1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("I/O Error: "+e);
        }
    }
}
