import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleKey appwin=new SimpleKey();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("Simple Key");
        appwin.setVisible(true);
    }
}

class SimpleKey extends Frame implements KeyListener {
    String message="";
    String keyState="";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Handle a key press
    public void keyPressed(KeyEvent ke) {
        keyState="Key down";
        int key=ke.getKeyCode();

        switch (key) {
            case KeyEvent.VK_F1:
                message+="<F1>";
                break;
            
            case KeyEvent.VK_F2:
                message+="<F2>";
                break;

            case KeyEvent.VK_F3:
                message+="<F3>";
                break;
            
            case KeyEvent.VK_PAGE_DOWN:
                message+="<PgDn>";
                break;
            
            case KeyEvent.VK_PAGE_UP:
                message+="PgUp";
                break;
            
            case KeyEvent.VK_LEFT:
                message+="<Left Arrow>";
                break;

            case KeyEvent.VK_RIGHT:
                message+="<Right Arror>";
                break;
        }
        repaint();
    }

    // Handle key released
    public void keyReleased(KeyEvent ke) {
        keyState="Key released";
        repaint();
    }

    // Handle key typed
    public void keyTyped(KeyEvent ke) {
        message+=ke.getKeyChar();
        repaint();
    }

    // Display keystrokes
    public void paint(Graphics g) {
        g.drawString(message, 20, 100);
        g.drawString(keyState, 20, 50);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}