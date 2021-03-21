import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangle extends SmartPolygonShape {
	
	public Triangle() {
		super(new int[] {300, 400, 200}, new int[] {200, 300, 300});
	}
	
	public Triangle(int size) {
		super(new int[] {300, 300 + size, 300 - size}, new int[] {200, 200 + size, 200 + size});
	}
	
	/*
	public SmartTriangularShape(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
		_xPoints = new int[] {x1, x2, x3};
		_yPoints = new int[] {y1, y2, y3};
		_color = color;
	}
	*/
}
