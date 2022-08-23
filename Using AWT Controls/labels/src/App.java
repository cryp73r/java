import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends Frame {

    public App() {
        setLayout(new FlowLayout());

        Label one=new Label("One");
        Label two=new Label("Two");
        Label three=new Label("Three");

        // Add labels to frame
        add(one);
        add(two);
        add(three);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);;
            }
        });
    }
    public static void main(String[] args) throws Exception {
        App appwin=new App();
        appwin.setSize(new Dimension(300, 100));
        appwin.setTitle("Labels");
        appwin.setVisible(true);
    }
}
