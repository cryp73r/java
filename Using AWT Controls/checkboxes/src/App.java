import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame implements ItemListener {

    String msg="";
    Checkbox windows, android, linux, mac;

    public App() {
        // Use a flow layout
        setLayout(new FlowLayout());;

        // Create check boxes
        windows=new Checkbox("Windows", true);
        android=new Checkbox("Android");
        linux=new Checkbox("Linux");
        mac=new Checkbox("Mac OS");

        add(windows);
        add(android);
        add(linux);
        add(mac);

        // Add item listeners
        windows.addItemListener(this);
        android.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);;
            }
        });
    }

        public void itemStateChanged(ItemEvent ie) {
            repaint();
        }

        public void paint(Graphics g) {
            msg="Curren state: ";
            g.drawString(msg, 20, 120);
            msg=" Windows: "+windows.getState();
            g.drawString(msg, 20, 140);
            msg=" Android: "+android.getState();
            g.drawString(msg, 20, 160);
            msg=" Linux: "+linux.getState();
            g.drawString(msg, 20, 180);
            msg=" MAC OS: "+mac.getState();
            g.drawString(msg, 20, 200);
        }
    public static void main(String[] args) throws Exception {
        App appwin=new App();

        appwin.setSize(new Dimension(240, 220));
        appwin.setTitle("Checkboxes");
        appwin.setVisible(true);
    }
}
