import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {

    final int inc=25;
    int max=500;
    int min=200;
    Dimension d;

    public App() {
        // Annonymous inner class to handle mouse release events.
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent me) {
                int w=(d.width+inc)>max?min:(d.width+inc);
                int h=(d.height+inc)>max?min:(d.height+inc);
                setSize(new Dimension(w, h));
            }
        });
        // Annonymous inner class to handle window close events
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Insets i=getInsets();
        d=getSize();
        g.drawLine(i.left, i.top, d.width-i.right, d.height-i.bottom);
        g.drawLine(i.left, d.height-i.bottom, d.width-i.right, i.top);
    }
    public static void main(String[] args) throws Exception {
        App appwin=new App();
        appwin.setSize(new Dimension(200, 200));
        appwin.setTitle("ResizeMe");
        appwin.setVisible(true);
    }
}
