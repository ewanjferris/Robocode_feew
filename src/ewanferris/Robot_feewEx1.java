package ewanferris;



import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;
import robocode.BulletHitEvent;
import java.awt.Color;
import java.util.Random;


public class Robot_feewEx1 extends AdvancedRobot {
	private Tank tank;
	private Canon canon;
	private Radar radar;
	private int turn;
	
	public void run() {
// Initialization
		setColors(Color.black, Color.black, Color.black);
		turn = 0;
		//setAdjustGunForRobotTurn(true);
		//setAdjustRadarForGunTurn(true);
		
		tank = new Tank(this); 
		canon = new Canon(this);
		radar = new Radar(this);
		
		while (true) {
			// One iteration per turn
			Random rand = new Random(); //instance of random class
		    int upperbound = 3;
		      //generate random values from 0-3
		    int int_random = rand.nextInt(upperbound);
		    if (int_random == 0) {
		    	setColors(Color.blue, Color.black, Color.black);
		    }
			if (int_random == 1) {
				setColors(Color.black, Color.black, Color.black);
			}
			if (int_random == 2) {
				setColors(Color.red, Color.red, Color.red);
			}
			if (int_random == 3) {
				setColors(Color.black, Color.black, Color.black);
			}
			
			turn++;
			System.out.println("Turn " + turn);
			tank.move();
			canon.fire();
			
			
			
						
		      
			// Perform any actions we planned this turn
			execute();
					
		}
			
		

	}

	
	public void onScannedRobot(ScannedRobotEvent e) {
		 canon.enemySeen(turn, e);
		 
	}
	
	/*public void onScannedRobot(ScannedRobotEvent e) {
		// Try to fire the gun immediately
		System.out.println("Target ahead - fire!");
		fire(3);
		
	}*/
	
	public int getTurn() {
		return turn;
	}

	
	public void onWin(WinEvent e) {		
		// Victory dance
		turnRight(36000);
	}
	
	/*
	public void onBulletHit(BulletHitEvent event) {
	     out.println("I hit " + event.getName() + "!");
	     ahead(20);
	     setTurnLeft(45);
			//go forward
			
	   }*/
	
	
}
