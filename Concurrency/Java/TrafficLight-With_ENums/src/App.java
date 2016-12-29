// Enumeration of the colors of a traffic light
enum TrafficLightColor {
	RED(3200), GREEN(2000), YELLOW(500);
	
	private int delay;
	
	TrafficLightColor(int t) {
		delay = t;
	}
	
	int getDelay() {
		return delay;
	}
}

public class App {
	public static void main(String[] args) {
		
		TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
		
		for(int i = 0; i < 9; i++) {
			System.out.println(t1.getColor());
			t1.waitForChange();
		}
		
		t1.cancel();
		
	}
}