package defaultpackage;



import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.util.Utils;
import robocode.BulletHitEvent;
import java.awt.Color;


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
	/* public void onBulletHit(BulletHitEvent event) {
	     out.println("I hit " + event.getName() + "!");
	     ahead(20);
	     setTurnLeft(45);
			//go forward
			
	     
	   }*/
}
