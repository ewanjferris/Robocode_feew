package defaultpackage;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.BulletHitEvent;

public class Robot_feewEx1 extends AdvancedRobot {
	public void run() {
// Initialization
		int turn = 0;
		while (true) {
// One iteration per turn
			turn++;
			System.out.println("Turn " + turn);
// Turn in a circle
			setTurnRight(10);
			//go forward
			ahead(10);
// Perform any actions we planned this turn
			execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
// Try to fire the gun immediately
		System.out.println("Target ahead - fire!");
		fire(3);
	}
	 public void onBulletHit(BulletHitEvent event) {
	     out.println("I hit " + event.getName() + "!");
	     ahead(20);
	     setTurnLeft(45);
			//go forward
			
	     
	   }
}
