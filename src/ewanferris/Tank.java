package ewanferris;

import java.util.Random;

public class Tank{
	private Robot_feewEx1 robot;
	
	public Tank(Robot_feewEx1 robot) {
		this.robot = robot;
	}
	public void move(){
		
		Random rand = new Random(); //instance of random class
	    int upperbound = 3;
	      //generate random values from 0-3
	    int int_random = rand.nextInt(upperbound);
	    if (int_random == 0) {
	  	  robot.setAhead(200);
	    }
		if (int_random == 1) {
			robot.setBack(200);
		}
		if (int_random == 2) {
			// Turn 
			robot.setTurnRight(90);
			//go forward
			robot.setAhead(200);  
		}
		if (int_random == 3) {
			// Turn 
			robot.setTurnRight(-90);
			//go forward
			robot.setAhead(200); 
		}
				
	}
	
	public void stayWithinBounds() {
		robot.getBattleFieldHeight();
		robot.getBattleFieldWidth();
		double boundsHeightMin = robot.getBattleFieldHeight() * 0.2;
		double boundsHeightMax = robot.getBattleFieldHeight() * 0.8;
		double boundsWidthMin = robot.getBattleFieldWidth() * 0.2;
		double boundsWidthMax = robot.getBattleFieldWidth() * 0.8;
		
		double xPos = robot.getX();
		double yPos = robot.getY();
		
		
		System.out.println(robot.getBattleFieldHeight());
		System.out.println(robot.getBattleFieldWidth());
		System.out.println(xPos);
		System.out.println(yPos);
		
		
		 if (xPos <= boundsHeightMin || xPos >= boundsHeightMax) {
			 robot.setTurnRight(180);
			  robot.setAhead(200);
		}
		
		if (yPos <= boundsWidthMin || yPos >=boundsWidthMax) {
			robot.setTurnRight(180);
			robot.setAhead(200);
			
		}
		
		
	}
	

}

