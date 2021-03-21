import java.awt.Color;

public class RoundedRectangle extends SmartRectangularShape {
	public RoundedRectangle() {
		super(new java.awt.geom.RoundRectangle2D.Double());
	}
	
	public RoundedRectangle(int x, int y) {
		super(new java.awt.geom.RoundRectangle2D.Double(), x, y);
	}
	
	public RoundedRectangle(Color color) {
		super(new java.awt.geom.RoundRectangle2D.Double(), color);
	}
}
