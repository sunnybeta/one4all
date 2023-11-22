public class Liskov {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(8,9);
		Square s = new Square(11);

		Quadrilateral q1 = new Quadrilateral(r);
		Quadrilateral q2 = new Quadrilateral(s);

		q1.desc();
		q2.desc();
	}
}

public class Rectangle {
	private int length;
	private int breadth;

	public Rectangle(int l, int b) {
		length = l;
		breadth = b;
	}

	public int area() {
		return length * breadth;
	}
	
	public int perimeter() {
		return 2*(length + breadth);
	}
}

public class Square extends Rectangle {
	private int size;

	public Square(int l) {
		super(l, l);
	}
}

public class Quadrilateral {
	private Rectangle rect;

	public Quadrilateral(Rectangle rect) {
		this.rect = rect;
	}

	public void desc() {
		System.out.println(String.format("The area of the quadrilateral is %d\n and perimeter is %d.", rect.area(), rect.perimeter()));
	}
}
