public class Facade {
	public static void main(String[] args) {
		System.out.println("::: This is a non-facade party ::: ;_;");
		TV tv = new TV();
		Radio r = new Radio();
		tv.turnOn();
		tv.setVolume(34);
		tv.setTimer(1);
		r.turnOn();
		r.setVolume(4);
		r.setTimer(3);
		System.out.println("---");
		System.out.println("::: This is a Facade Party ::: :D");
		FacadeParty f = new FacadeParty();
		f.beginParty();
	}
}

public interface MusicSystem {
	public void turnOn();
	public void setVolume(int volume);
	public void setTimer(int hours);
}

public class Radio implements MusicSystem {
	public void turnOn() {
		System.out.println("Radio is ON");
	}

	public void setVolume(int volume) {
		System.out.println("Radio Volume is set to " + volume);
	}

	public void setTimer(int hours) {
		System.out.println("Radio Timer is set to " + hours + " hours");
	}
}


public class TV implements MusicSystem {
	public void turnOn(){
		System.out.println("TV is ON");
	}

	public void setVolume(int volume) {
		System.out.println("TV Volume is set to " + volume);
	}

	public void setTimer(int hours) {
		System.out.println("TV Timer is set to " + hours + " hours");
	}
}


public class FacadeParty {
	private TV tv = new TV();
	private Radio r = new Radio();

	public void beginParty() {
		tv.turnOn();
		tv.setVolume(34);
		tv.setTimer(1);
		r.turnOn();
		r.setVolume(4);
		r.setTimer(3);
	}
}
