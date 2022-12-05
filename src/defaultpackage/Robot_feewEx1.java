package defaultpackage;

import java.util.Random;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;
import robocode.BulletHitEvent;


public class Robot_feewEx1 extends AdvancedRobot {
	public void run() {
// Initialization
		int turn = 0;
		//setAdjustGunForRobotTurn(true);
		//setAdjustRadarForGunTurn(true);
		
		while (true) {
			// One iteration per turn
			turn++;
			System.out.println("Turn " + turn);
						
			 Random rand = new Random(); //instance of random class
		      int upperbound = 3;
		        //generate random values from 0-3
		      int int_random = rand.nextInt(upperbound);
		      if (int_random == 0) {
		    	  ahead(200);
		      }
			if (int_random == 1) {
				back(200);
			}
			if (int_random == 2) {
				// Turn in a circle
				setTurnRight(90);
				//go forward
				ahead(200);  
			}
			if (int_random == 3) {
				// Turn in a circle
				setTurnRight(-90);
				//go forward
				ahead(200); 
			}		      
			
						
			 /*Random randDeg = new Random(); //instance of random class
		      int upperbound2 = 180;
		      int int_randomDeg = randDeg.nextInt(upperbound2);
		      turnRadarRight(int_randomDeg);*/
		      
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
	
	public void onWin(WinEvent e) {
		// Victory dance
		turnRight(36000);
	}
	/* public void onBulletHit(BulletHitEvent event) {
	     out.println("I hit " + event.getName() + "!");
	     ahead(20);
	     setTurnLeft(45);
			//go forward
			
	     
	   }*/
}
