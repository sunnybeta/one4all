public class Encapsulation {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		System.out.println("Circle's Old Radius = " + c.getRadius());
		c.setRadius(11);
		System.out.println("Circle's New Radius = " + c.getRadius());
	}
}

public class Circle {
	private int radius;

	public Circle() {
		radius = 1;
	};

	public Circle(int radius) {
		this.radius = radius;
	};

	public double Area() {
		return 22.0/7 * radius * radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int r) {
		radius = r;
	}
}

