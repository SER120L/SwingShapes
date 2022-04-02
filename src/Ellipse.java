import java.awt.Color;

public class Ellipse extends EllipseShape {
	public Ellipse() {
		super(new java.awt.geom.Ellipse2D.Double());
	}
	
	public Ellipse(int x, int y) {
		super(new java.awt.geom.Ellipse2D.Double(), x, y);
	}
	
	public Ellipse(Color color) {
		super(new java.awt.geom.Ellipse2D.Double(), color);
	}
}
