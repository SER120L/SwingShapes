import java.awt.Color;

public class Line extends SmartShape {
	public Line(int x1, int y1, int x2, int y2) {
		super(new java.awt.geom.Line2D.Double(x1, y1, x2, y2));
	}
	
	public Line(int x1, int y1, int x2, int y2, Color color) {
		super(new java.awt.geom.Line2D.Double(x1, y1, x2, y2), color);
	}
}
