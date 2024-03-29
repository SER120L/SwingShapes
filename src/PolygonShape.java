import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class PolygonShape extends Path2D.Double {

	private int x, y;
	private int offsetX, offsetY;
	private int rotation;
	private Color color;
	private Color borderColor;
	private int borderThickness;
	private double scaleX, scaleY;
	
	public PolygonShape(int[] xPoints, int[] yPoints) {
		if (xPoints.length != yPoints.length) {
			throw new RuntimeException("X and Y point arrays do not have same number of points.");
		}
		
		moveTo(xPoints[0], yPoints[0]);
		for (int i = 1; i < xPoints.length; i++) {
			lineTo(xPoints[i], yPoints[i]);
		}
		closePath();
		
		this.color = Color.red;
		this.borderColor = Color.red;
		this.borderThickness = 0;
		this.x = xPoints[0];
		this.y = yPoints[0];
		this.scaleX = 1;
		this.scaleY = 1;
	}

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int degrees) {
    	this.rotation = degrees;
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
    
    public Color getColor() {
    	return color;
    }
    
    public void setColor(Color color) {
    	this.color = color;
    	this.borderColor = color;
    }
    
    public Color getBorderColor() {
    	return borderColor;
    }
    
    public void setBorderColor(Color color) {
    	this.borderColor = color;
    }

    public int getBorderThickness() {
    	return borderThickness;
    }
    
    public void setBorderThickness(int borderThickness) {
    	this.borderThickness = borderThickness;
    }
    
    public double getScaleX() {
    	return scaleX;
    }
    
    public void setScaleX(double scaleX) {
    	this.scaleX = scaleX;
    }
    
    public double getScaleY() {
    	return scaleY;
    }
    
    public void setScaleY(double scaleY) {
    	this.scaleY = scaleY;
    }
    
    public void setScale(double scaleX, double scaleY) {
    	this.scaleX = scaleX;
    	this.scaleY = scaleY;
    }

	private Shape getTransformedInstance() {
		AffineTransform at = new AffineTransform();
		java.awt.Rectangle bounds = getBounds();
		
		at.translate(offsetX, offsetY);
		at.rotate(Math.toRadians(rotation), bounds.getCenterX(), bounds.getCenterY());
		
		double centerX = getBounds2D().getCenterX();
		double centerY = getBounds2D().getCenterY();
		at.translate(centerX, centerY);
		at.scale(scaleX, scaleY);
		at.translate(-centerX, -centerY);
		
		return createTransformedShape(at);
	}
	
	public void paint(Graphics2D brush) {
		Shape shape = getTransformedInstance();
		brush.setColor(color);
		brush.fill(shape);
		
		java.awt.Stroke oldStroke = brush.getStroke();
		brush.setColor(borderColor);
        brush.setStroke(new BasicStroke(borderThickness));
        brush.draw(shape);
		brush.setStroke(oldStroke);
	}

}
