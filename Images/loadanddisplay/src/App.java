import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class App extends Frame {

    Image img;

    public App() {
        try {
            File file=new File("landscape.jpg");
            // load the image
            img=ImageIO.read(file);
        } catch (IOException exc) {
            System.out.println("Can't load image");
            System.exit(0);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(img, getInsets().left, getInsets().top, null);
    }
    public static void main(String[] args) throws Exception {
        App appwin=new App();
        
        appwin.setSize(new Dimension(536, 354));
        appwin.setTitle("Simple Image Load");
        appwin.setVisible(true);
    }
}
