import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {

    public App() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) throws Exception {
        App appwin=new App();
        appwin.setSize(new Dimension(370, 700));
        appwin.setTitle("Shapes");
        appwin.setVisible(true);
    }

    public void paint(Graphics g) {
        // Draw Lines
        g.drawLine(20, 40, 100, 90);
        g.drawLine(20, 90, 100, 40);
        g.drawLine(40, 45, 250, 80);

        // Draw Rectangles
        g.drawRect(20, 150, 60, 50);
        g.fillRect(110, 150, 60, 50);
        g.drawRoundRect(200, 150, 60, 50, 15, 15);
        g.fillRoundRect(290, 150, 60, 50, 30, 40);

        // Draw ellipses and circles
        g.drawOval(20, 250, 50, 50);
        g.fillOval(100, 250, 75, 50);
        g.drawOval(200, 260, 100, 40);

        // Draw arcs
        g.drawArc(20, 350, 70, 70, 0, 180);
        g.fillArc(70, 350, 70, 70, 0, 75);

        // Draw a polygon
        int xpoints[]={20, 200, 20, 200, 20};
        int ypoints[]={450, 450, 650, 650, 450};
        int num=5;

        g.drawPolygon(xpoints, ypoints, num);
    }
}
