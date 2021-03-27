
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
    private Rectangle _rectangle;
    private Ellipse _ellipse;
    private Line _line;
    private Triangle _triangle;

    public DrawingPanel()
    {
        super();
        this.setSize(1000, 900);
        this.setBackground(Color.white);  
        
        _rectangle = new Rectangle();
        _rectangle.setFillColor(Color.blue);
        _rectangle.setBorderColor(Color.gray);
        
        _ellipse = new Ellipse();
        _ellipse.setFillColor(Color.blue);
        _ellipse.setBorderColor(Color.black);
        _ellipse.setLocation(330,  330);
        
        _line = new Line(10, 10, 70, 70);
        _line.setColor(Color.blue);
        _line.setThickness(10);
        _line.setLocation(50, 50);
        
        _triangle = new Triangle(50);
        _triangle.setLocation(200, 200);
        _triangle.setRotation(90);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D brush = (Graphics2D) g;
        _rectangle.paint(brush);
        _ellipse.paint(brush);
        _line.paint(brush);
        _triangle.paint(brush);
    }
}
