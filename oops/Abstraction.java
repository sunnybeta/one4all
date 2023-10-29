class Abstraction {
	public static void main(String[] args) {
		Tech tech = new Tech();
		tech.add(1,2);
		tech.multiply(37,39);
		System.out.println(tech.divide(666664,166666));
		tech.modulo(1829,18);
		System.out.println(tech.power(6,6));
	}
}

public abstract class Compute {
	abstract void add(int a,int b);
	abstract void multiply(int a, int b);
	abstract float divide(int a,int b);
	abstract void modulo(int a,int b);
	abstract double power(int a, int b);
}

public class Tech extends Compute {

	public Tech() {}

	void add(int a, int b) {
		System.out.println(a + b);
	}

	void multiply(int a, int b) {
		System.out.println(a * b);
	}

	float divide(int a, int b) {
		return a / (float)b;
	}

	void modulo(int a, int b) {
		while (a > 0) {
			a -= b;
		}
		a += b;
		System.out.println(a);
	}

	@Override
	double power(int a, int b) {
		double ans = 1;
		while (b-- > 0) {
			ans *= a;
		}
		return ans;
	}
}
