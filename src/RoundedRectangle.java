import java.awt.Color;

public class RoundedRectangle extends SmartRectangularShape {
	public RoundedRectangle(int arcSize) {
		super(new java.awt.geom.RoundRectangle2D.Double(0, 0, 0, 0, arcSize, arcSize));
	}
	
	public RoundedRectangle(int arcSize, int x, int y) {
		super(new java.awt.geom.RoundRectangle2D.Double(0, 0, 0, 0, arcSize, arcSize), x, y);
	}
	
	public RoundedRectangle(int arcSize, Color color) {
		super(new java.awt.geom.RoundRectangle2D.Double(0, 0, 0, 0, arcSize, arcSize), color);
	}
}
