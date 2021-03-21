import java.awt.Color;
import java.awt.Shape;

public class SmartShape {
	private Shape _shape;
	private int _thickness;
	private Color _color;

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

	public void paint(java.awt.Graphics2D g) {
		java.awt.Stroke oldStroke = g.getStroke();
		g.setStroke(new java.awt.BasicStroke(_thickness));
		g.setColor(_color);
		g.draw(_shape);
		g.setStroke(oldStroke);
	}

}
