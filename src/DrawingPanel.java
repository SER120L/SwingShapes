
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
    private Rectangle rectangle;
    private Ellipse ellipse;
    private Line line;
    private Triangle triangle;
    private Pentagon pentagon;

    public DrawingPanel()
    {
        super();
        this.setSize(1000, 900);
        this.setBackground(Color.white);  
        
        rectangle = new Rectangle();
        rectangle.setFillColor(Color.blue);
        rectangle.setBorderColor(Color.green);
        rectangle.setBorderThickness(6);
        
        ellipse = new Ellipse();
        ellipse.setFillColor(Color.blue);
        ellipse.setBorderColor(Color.black);
        ellipse.setLocation(330,  330);
        
        line = new Line(10, 10, 70, 70);
        line.setColor(Color.blue);
        line.setThickness(10);
        line.setLocation(50, 50);
        
        triangle = new Triangle(50);
        triangle.setColor(Color.pink);
        triangle.setLocation(200, 200);
        triangle.setRotation(90);
        
        pentagon = new Pentagon();
        pentagon.setColor(Color.green);
        pentagon.setLocation(500, 400);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D brush = (Graphics2D) g;
        rectangle.paint(brush);
        ellipse.paint(brush);
        line.paint(brush);
        triangle.paint(brush);
        pentagon.paint(brush);
    }
}
