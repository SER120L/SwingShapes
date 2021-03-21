
public class Triangle extends SmartPolygonShape {
	
	public Triangle() {
		super(new int[] {300, 400, 200}, new int[] {200, 300, 300});
	}
	
	public Triangle(int size) {
		super(new int[] {300, 300 + size, 300 - size}, new int[] {200, 200 + size, 200 + size});
	}
	
	public Triangle(int height, int base) {
		super(new int[] {300, 300 - (base / 2), 300 + (base / 2)}, new int[] {200, 200 + height, 200 + height});
	}
	
	public Triangle(int side1, int side2, int side3) {
		super(new int[] {300, 300 - (side1 / 2), 300 + (side2 / 2)}, new int[] {200, 200 + side1, 200 + side2});
	}
}
