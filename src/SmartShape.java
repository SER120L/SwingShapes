import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

public class SmartShape {
	private Shape shape;
	private int x, y;
	private int offsetX, offsetY;
	private int thickness;
	private Color color;
	public int rotation;
	
	public SmartShape(Shape shape) {
		this.shape = shape;
		this.thickness = 1;
		this.color = Color.white;
	}
	
	public SmartShape(Shape shape, Color color) {
		this.shape = shape;
		this.thickness = 1;
		this.color = color;
	}

	public int getThickness() {
		return thickness;
	}

	public void setThickness(int thickness) {
		this.thickness = thickness;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getXLocation() {
		return x;
	}
	
	public int getYLocation() {
		return y;
	}
	
	public void setLocation(int x, int y) {
    	int dx = x - this.x;
    	int dy = y - this.y;
    	offsetX += dx;
    	offsetY += dy;
    	this.x = x;
    	this.y = y;
	}
	
    public int getRotation() {
        return rotation;
    }

    public void setRotation(int degrees) {
    	this.rotation = degrees;
    }
	
	private Shape getTransformedInstance() {
		AffineTransform at = new AffineTransform();
		at.translate(offsetX, offsetY);
		java.awt.Rectangle bounds = shape.getBounds();
		at.rotate(Math.toRadians(rotation), bounds.getCenterX(), bounds.getCenterY());
		return at.createTransformedShape(shape);
	}

	public void paint(java.awt.Graphics2D g) {
		Shape shape = getTransformedInstance();
		
		java.awt.Stroke oldStroke = g.getStroke();
		g.setStroke(new java.awt.BasicStroke(thickness));
		g.setColor(color);
		g.draw(shape);
		g.setStroke(oldStroke);
	}

}
