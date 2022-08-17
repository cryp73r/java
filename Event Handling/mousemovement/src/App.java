import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) throws Exception {
        WindowBuilder appwin=new WindowBuilder();

        appwin.setSize(new Dimension(300, 300));
        appwin.setTitle("Mouse Events");
        appwin.setVisible(true);
    }
}

class WindowBuilder extends Frame implements MouseListener, MouseMotionListener {
    String message="";
    int mouseX=0, mouseY=0;

    public WindowBuilder() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    // Handle mouse clicked
    public void mouseClicked(MouseEvent me) {
        message+=" -- click received";
        repaint();
    }

    public void mouseEntered(MouseEvent me) {
        mouseX=100;
        mouseY=100;
        message="Mouse Entered";
        repaint();
    }

    // Handle mouse exit
    public void mouseExited(MouseEvent me) {
        mouseX=100;
        mouseY=100;
        message="Mouse Exited";
        repaint();
    }

    // Handle button pressed
    public void mousePressed(MouseEvent me) {
        mouseX=me.getX();
        mouseY=me.getY();
        message="Button down";
        repaint();
    }

    // Handle button released
    public void mouseReleased(MouseEvent me) {
        mouseX=me.getX();
        mouseY=me.getY();
        message="Button released";
        repaint();
    }

    public void mouseDragged(MouseEvent me) {
        mouseX=me.getX();
        mouseY=me.getY();
        message="*"+" mouse at "+mouseX+", "+mouseY;
        repaint();
    }

    public void mouseMoved(MouseEvent me) {
        message="Moving mouse at "+me.getX()+", "+me.getY();
        repaint();
    }

    // Display message in the window at current X, Y location
    public void paint(Graphics g) {
        g.drawString(message, mouseX, mouseY);
    }
}

class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}