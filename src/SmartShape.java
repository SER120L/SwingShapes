import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class SmartShape {
	private Shape _shape;
	private int _x, _y;
	private int _offsetX, _offsetY;
	private int _thickness;
	private Color _color;
	public int _rotation;
	
	public SmartShape(Shape shape) {
		_shape = shape;
		_thickness = 1;
		_color = Color.white;
	}
	
	public SmartShape(Shape shape, Color color) {
		_shape = shape;
		_thickness = 1;
		_color = color;
	}

	public int getThickness() {
		return _thickness;
	}

	public void setThickness(int _thickness) {
		this._thickness = _thickness;
	}

	public Color getColor() {
		return _color;
	}

	public void setColor(Color color) {
		_color = color;
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
	
    public int getRotation() {
        return _rotation;
    }

    public void setRotation(int degrees) {
    	_rotation = degrees;
    }
	
	private Shape getTransformedInstance() {
		AffineTransform at = new AffineTransform();
		at.translate(_offsetX, _offsetY);
		java.awt.Rectangle bounds = _shape.getBounds();
		at.rotate(Math.toRadians(_rotation), bounds.getCenterX(), bounds.getCenterY());
		return at.createTransformedShape(_shape);
	}

	public void paint(java.awt.Graphics2D g) {
		Shape shape = getTransformedInstance();
		java.awt.Stroke oldStroke = g.getStroke();
		g.setStroke(new java.awt.BasicStroke(_thickness));
		g.setColor(_color);
		g.draw(shape);
		g.setStroke(oldStroke);
	}

}
