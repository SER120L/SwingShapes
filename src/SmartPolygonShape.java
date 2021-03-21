import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class SmartPolygonShape extends Path2D.Double {

	private int _rotation = 0;
	private int _x, _y;
	private Color _fillColor;
	private Color _borderColor;
	private int _borderThickness;

	public SmartPolygonShape(int[] xPoints, int[] yPoints) {
		if (xPoints.length != yPoints.length) {
			throw new RuntimeException("X and Y point arrays do not have same number of points.");
		}
		moveTo(xPoints[0], yPoints[0]);
		for (int i = 1; i < xPoints.length; i++) {
			lineTo(xPoints[i], yPoints[i]);
		}

		closePath();
		_fillColor = Color.blue;
		_borderColor = Color.blue;
		_borderThickness = 0;
	}

    public double getRotation() {
        return (int)(_rotation * 180 / Math.PI);
    }

    public void setRotation(double degrees) {
    	_rotation = (int)(degrees + Math.PI / 180);
    }
    
    public int getXLocation() {
    	return _x;
    }
    
    public int getYLocation() {
    	return _y;
    }
    
    public void moveLocationBy(int dx, int dy) {
        _x += dx;
    	_y += dy;
    }
    
    public Color getColor() {
    	return _fillColor;
    }
    
    public void setColor(Color color) {
    	_fillColor = color;
    	_borderColor = color;
    }
    
    public Color getBorderColor() {
    	return _borderColor;
    }
    
    public void setBorderColor(Color color) {
    	_borderColor = color;
    }

    public int getBorderThickness() {
    	return _borderThickness;
    }
    
    public void setBorderThickness(int borderThickness) {
    	_borderThickness = borderThickness;
    }

	private Shape getTransformedInstance() {
		AffineTransform at = new AffineTransform();
		java.awt.Rectangle bounds = getBounds();
		at.rotate(Math.toRadians(_rotation), _x + (bounds.width / 2), _y + (bounds.height / 2));
		at.translate(_x, _y);
		return createTransformedShape(at);
	}
	
	public void paint(Graphics2D brush) {
		Shape shape = getTransformedInstance();
		brush.setColor(_fillColor);
		brush.fill(shape);
		
		java.awt.Stroke oldStroke = brush.getStroke();
		brush.setColor(_borderColor);
        brush.setStroke(new BasicStroke(_borderThickness));
        brush.draw(shape);
		brush.setStroke(oldStroke);
	}

}
