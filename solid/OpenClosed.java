public class OpenClosed {
	public static void main(String[] args) {
		Circle c = new Circle(4);
		Rectangle r = new Rectangle(4,9);
		c.displayArea();
		r.displayArea();
	}
}


public abstract class Shape {
	abstract double getArea();
	abstract void displayArea();

}


public class Circle extends Shape{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 3.14*radius * radius;
	}

	@Override
	void displayArea() {
		System.out.println(String.format("The area of the circle of radius %.2f is %.2f", radius, getArea()));
	}

}


public class Rectangle extends Shape{
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return this.width * this.height;
	}

	@Override
	void displayArea() {
		System.out.println(String.format("The area of the rectangle of height %.2f and width %.2f is %.2f", height, width, getArea()));
	}
}

