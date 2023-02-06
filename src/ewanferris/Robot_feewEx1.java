package ewanferris;



import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;
import robocode.BulletHitEvent;
import robocode.HitRobotEvent;

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
			/*
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
			*/
			turn++;
			System.out.println("Turn " + turn);
			tank.stayWithinBounds();
			if (tank.skipMoveFunction == false) {
				tank.move();
			}
			//tank.skipMoveFunction = true;
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
	
	 public void onHitRobot(HitRobotEvent event) {
		tank.skipMoveFunction = false;
	   }
	 
	
	public void onWallHit(BulletHitEvent event) {
	     out.println("I hit " + event.getName() + "!");
	     go(0, 0);
			
	   }
	void go(double x, double y) {
	    /* Calculate the difference bettwen the current position and the target position. */
	    x = x - getX();
	    y = y - getY();
	    
	    /* Calculate the angle relative to the current heading. */
	    double goAngle = Utils.normalRelativeAngle(Math.atan2(x, y) - getHeadingRadians());
		
	    /*
	     * Apply a tangent to the turn this is a cheap way of achieving back to front turn angle as tangents period is PI.
	     * The output is very close to doing it correctly under most inputs. Applying the arctan will reverse the function
	     * back into a normal value, correcting the value. The arctan is not needed if code size is required, the error from
	     * tangent evening out over multiple turns.
	     */
	    setTurnRightRadians(Math.atan(Math.tan(goAngle)));
		
	    /* 
	     * The cosine call reduces the amount moved more the more perpendicular it is to the desired angle of travel. The
	     * hypot is a quick way of calculating the distance to move as it calculates the length of the given coordinates
	     * from 0.
	     */
	    setAhead(Math.cos(goAngle) * Math.hypot(x, y));
	}
	
	
}
