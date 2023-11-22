import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class Flyweight {
	private static final String colors[] = {"red","blue","green"};
	private static final Map<String, String> urls = Map.ofEntries(
		new AbstractMap.SimpleEntry<String, String>("red","urlRed"),
		new AbstractMap.SimpleEntry<String, String>("blue","urlBlue"),
		new AbstractMap.SimpleEntry<String, String>("green","urlGreen")
	);

	public static void main(String[] args) {
		final int BALLS = 1_00_000;
		for (int i = 0; i < BALLS; i++) {
			String color = getColor();
			String url = urls.get(color);

			Ball ball = BallFactory.getBall(color, url);
			ball.setX(getX());
			ball.setY(getY());
			ball.setR(getR());
			ball.draw();
		}

		System.out.println("--- MEMORY ---");
		System.out.println("Color:        ~5");
		System.out.println("Url  :        ~20");
		System.out.println("X,Y,R: 8 * 3 = 24\n");
		System.out.println("TOTAL\n" + ((24*BALLS + 25) / 1024) / 1024.0 + " MB\n");
		System.out.println("TOTAL (Unoptimized)\n" + ((49*BALLS) / 1024) / 1024.0 + " MB");


	}

	private static String getColor() {
		return colors[(int)(Math.random()*colors.length)];
	}

	private static int getX() {
		return (int)(Math.random()*50);
	}

	private static int getY() {
		return (int)(Math.random()*50);
	}

	private static int getR() {
		return (int)(Math.random()*10);
	}
}


public class Ball {
	private String color;
	private String url;
	private int x;
	private int y;
	private int r;

	public Ball(String color, String url) {
		this.color = color;
		this.url = url;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setR(int r) {
		this.r = r;
	}

	public void draw() {
		// System.out.println(String.format("BALL (%d, %d, %d)", x, y, r));
	}

	public String getHashCode() {
		return color + url;
	}
}


public class BallFactory {
	private static final HashMap<String, Ball>  BallMap = new HashMap<>();

	public static Ball getBall(String color, String url) {

		StringBuilder sb = new StringBuilder();
		sb.append(color);
		sb.append(url);
		String key = sb.toString();
		Ball ball = BallMap.get(key);

		if (ball == null) {
			ball = new Ball(color, url);
			BallMap.put(key, ball);
			System.out.println("Created Ball of Color " + color);
		}

		return ball;
	}
}


