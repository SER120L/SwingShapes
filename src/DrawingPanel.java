
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel
{
    private Rectangle _rectangle;
    private SmartRectangularShape _ellipse;
    private Line _line;
    private Triangle _triangle;
    private SmartPolygonShape _polygon;

    public DrawingPanel()
    {
        super();
        this.setSize(1000, 900);
        this.setBackground(Color.white);  
        
        _rectangle = new Rectangle();
        _rectangle.setFillColor(Color.blue);
        _rectangle.setBorderColor(Color.gray);
        
        _ellipse = new SmartRectangularShape(new java.awt.geom.Ellipse2D.Double());
        _ellipse.setFillColor(Color.blue);
        _ellipse.setBorderColor(Color.black);
        _ellipse.setLocation(330,  330);
        
        _line = new Line(10, 10, 70, 70);
        _line.setColor(Color.blue);
        _line.setThickness(10);
        
        _triangle = new Triangle();
        _triangle.moveLocationBy(0, 0);
        
        _polygon = new SmartPolygonShape(new int[] {40,  0, 80}, new int[] {40, 80, 80});
        _polygon.setRotation(90);
        _polygon.moveLocationBy(50, 50);
        _polygon.setBorderColor(Color.red);
        _polygon.setBorderThickness(5);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D brush = (Graphics2D) g;
        _rectangle.paint(brush);
        //_ellipse.paint(brush);
        //_line.paint(brush);
        _triangle.paint(brush);
        //_polygon.paint(brush);
    }
}
