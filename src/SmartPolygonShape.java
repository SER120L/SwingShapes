import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class SmartPolygonShape extends Path2D.Double {

	private int _x, _y;
	private int _offsetX, _offsetY;
	private int _rotation;
	private Color _color;
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
		
		_color = Color.red;
		_borderColor = Color.red;
		_borderThickness = 0;
		_x = xPoints[0];
		_y = yPoints[0];
	}

    public int getRotation() {
        return _rotation;
    }

    public void setRotation(int degrees) {
    	_rotation = degrees;
    }
    
    public int getXLocation() {
    	return _x;
    }
    
    public int getYLocation() {
    	return _y;
    }
    
    public void setLocation(int x, int y) {
    	int dx = x - _x;
    	int dy = y - _y;
    	_offsetX += dx;
    	_offsetY += dy;
    	_x = x;
    	_y = y;
    }
    
    public Color getColor() {
    	return _color;
    }
    
    public void setColor(Color color) {
    	_color = color;
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
		at.translate(_offsetX, _offsetY);
		at.rotate(Math.toRadians(_rotation), bounds.getCenterX(), bounds.getCenterY());
		return createTransformedShape(at);
	}
	
	public void paint(Graphics2D brush) {
		Shape shape = getTransformedInstance();
		brush.setColor(_color);
		brush.fill(shape);
		
		java.awt.Stroke oldStroke = brush.getStroke();
		brush.setColor(_borderColor);
        brush.setStroke(new BasicStroke(_borderThickness));
        brush.draw(shape);
		brush.setStroke(oldStroke);
	}

}
