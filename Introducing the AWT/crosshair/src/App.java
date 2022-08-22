import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {

    int chX=100, chY=100;

    public App() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent me) {
                int x=me.getX();
                int y=me.getY();
                chX=x-10;
                chY=y-10;
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(20, 40, 60, 70);

        g.setColor(Color.BLUE);
        g.fillRect(110, 40, 60, 70);
        
        g.setColor(Color.BLACK);
        g.fillRect(200, 40, 60, 70);

        g.setColor(Color.RED);
        g.fillRect(60, 120, 160, 110);

        // XOR Cross hairs
        g.setXORMode(Color.BLACK);
        g.drawLine(chX-10, chY, chX+10, chY);
        g.drawLine(chX, chY-10, chX, chY+10);
        g.setPaintMode();
    }
    public static void main(String[] args) throws Exception {
        App appwin=new App();
        appwin.setSize(new Dimension(300, 260));
        appwin.setTitle("Crosshair");
        appwin.setVisible(true);
    }
}
