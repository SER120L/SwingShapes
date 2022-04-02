import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.RectangularShape;

public class EllipseShape extends RectangleShape {

	private boolean cutInHalf;
	
	public EllipseShape(RectangularShape shape) {
		super(shape);
	}
	
	public EllipseShape(RectangularShape shape, int x, int y) {
		super(shape, x, y);
	}
	
	public EllipseShape(RectangularShape shape, Color color) {
		super(shape, color);
	}

    public boolean getCutInHalf() {
    	return cutInHalf;
    }
    
    public void setCutInHalf(boolean cutInHalf) {
    	this.cutInHalf = cutInHalf;
    }
    
    public void paint(Graphics2D brush) {
        Area area = new Area(shape);
        
        if (cutInHalf) {
        	Area choppedArea = new Area(new Rectangle(getXLocation(), getYLocation() + (getHeight() / 2), getWidth(), getHeight() / 2));
        	area.subtract(choppedArea);
        }
    	
        brush.rotate(rotation, shape.getCenterX(), shape.getCenterY());

        brush.setColor(fillColor);
        brush.fill(area);
        
		java.awt.Stroke oldStroke = brush.getStroke();
        brush.setColor(borderColor);
        brush.setStroke(new BasicStroke(borderThickness));
        brush.draw(area);
		brush.setStroke(oldStroke);
		
        brush.rotate(-rotation, shape.getCenterX(), shape.getCenterY());  
    }
	
}
