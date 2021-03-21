
import javax.swing.JFrame;

public class App extends JFrame
{
    public App()
    {
        super("Swing Shapes!");
        this.setSize(1000, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // create a jpanel and add it to the frame
        this.add(new DrawingPanel());

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new App();
    }
}
