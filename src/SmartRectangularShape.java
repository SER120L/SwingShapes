
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

public class SmartRectangularShape {
    private RectangularShape _s;
    private Color _fillColor, _borderColor;
    private double _rotation;
    private int _borderThickness;

    public SmartRectangularShape(RectangularShape s) {
        _s = s;
        _fillColor = Color.red;
        _borderColor = Color.red;
        _borderThickness = 0;
        setLocation(250, 225);
        setSize(100, 100);
    }
    
    public SmartRectangularShape(RectangularShape s, int x, int y) {
    	_s = s;
        _fillColor = Color.red;
        _borderColor = Color.red;
        _borderThickness = 0;
    	setLocation(x,  y);
        setSize(100, 100);
    }
    
    public SmartRectangularShape(RectangularShape s, Color color) {
        _s = s;
        _fillColor = color;
        _borderColor = color;
        _borderThickness = 0;
        setLocation(250, 225);
        setSize(100, 100);
    }

    public void setLocation(double x, double y) {
        _s.setFrame(x, y, _s.getWidth(), _s.getHeight());
    }

    public void setSize(double w, double h) {
        _s.setFrame(_s.getX(), _s.getY(), w, h);
    }

    public void setColor(Color c) {
        _fillColor = c;
        _borderColor = c;
    }

    public void setFillColor(Color c) {
        _fillColor = c;
    }

    public void setBorderColor(Color c) {
        _borderColor = c;
    }

    public Color getFillColor() {
        return _fillColor;
    }

    public Color getBorderColor() {
        return _borderColor;
    }

    public void setRotation(double degrees) {
        _rotation = degrees * Math.PI / 180;
    }

    public double getRotation() {
        return _rotation * 180 / Math.PI;
    }
    
    public int getBorderThickness() {
    	return _borderThickness;
    }
    
    public void setBorderThickness(int thickness) {
    	_borderThickness = thickness;
    }

    public void paint(Graphics2D brush) {
        brush.rotate(_rotation, _s.getCenterX(), _s.getCenterY());

        brush.setColor(_fillColor);
        brush.fill(_s);
        brush.rotate(-_rotation, _s.getCenterX(), _s.getCenterY());
        
		java.awt.Stroke oldStroke = brush.getStroke();
        brush.setColor(_borderColor);
        brush.setStroke(new BasicStroke(_borderThickness));
        brush.draw(_s);
		brush.setStroke(oldStroke);
    }
}
