public class TrafficLightSimulator implements Runnable {
	
	// A computerized traffic light 
	
	private Thread thrd; // holds the thread that runs the simulator
	private TrafficLightColor tlc; // holds the traffic light color
	boolean stop = false; // set to true to stop the simulation
	boolean changed = false; // true when the light has changed
	
	TrafficLightSimulator(TrafficLightColor init) {
		tlc = init;
		
		thrd = new Thread(this);
		thrd.start();
	}
	
	TrafficLightSimulator() {
		tlc = TrafficLightColor.RED;
		
		thrd = new Thread(this);
		thrd.start();
	}
	
	//start up the light
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(tlc.getDelay());
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			changeColor();
		}
	}
	
	synchronized void changeColor() {
		switch(tlc) {
		case RED: 
			tlc = TrafficLightColor.GREEN;
			break;
		case YELLOW:
			tlc = TrafficLightColor.RED; 
			break;
		case GREEN:
			tlc = TrafficLightColor.YELLOW;
			break;
		}
		
		changed = true;
		notify(); // signal that the light has changed
	}
	
	// wait for a light change occurs
	synchronized void waitForChange() {
		try {
			while(!changed)
				wait(); // wait for a light to change
			changed = false;
		} catch(InterruptedException exc) {
			System.out.println(exc);
		}
	}
	
	// return current color 
	synchronized TrafficLightColor getColor() {
		return tlc;
	}
	
	// stop the traffic light
	synchronized void cancel() {
		stop = true;
	}
	
}
