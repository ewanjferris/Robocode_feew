package ewanferris;

import java.util.Random;

public class Tank{
	private Robot_feewEx1 robot;
	
	boolean skipMoveFunction = false;
	
	public Tank(Robot_feewEx1 robot) {
		this.robot = robot;
	}
	
	public void setSkipMoveFunctionFalse(boolean skipMoveFunction) {
		this.skipMoveFunction = skipMoveFunction;
		skipMoveFunction = false;
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
			robot.setTurnRight(66);
			//go forward
			robot.setAhead(200);  
		}
		if (int_random == 3) {
			// Turn 
			robot.setTurnRight(-66);
			//go forward
			robot.setAhead(200); 
		}
				
	}
	
	public void stayWithinBounds() {
		
		//skipMoveFunction = false;
		
		robot.getBattleFieldHeight();
		robot.getBattleFieldWidth();
		double boundsHeightMin = robot.getBattleFieldHeight() * 0.2;
		double boundsHeightMax = robot.getBattleFieldHeight() * 0.8;
		double boundsWidthMin = robot.getBattleFieldWidth() * 0.2;
		double boundsWidthMax = robot.getBattleFieldWidth() * 0.8;
		
		double xPos = robot.getX();
		double yPos = robot.getY();
		
		System.out.println("boundsHeightMin:" + boundsHeightMin);
		System.out.println("boundsHeightMax:" + boundsHeightMax);
		System.out.println("boundsWidthMin:" + boundsWidthMin);
		System.out.println("boundsWidthMax:" + boundsWidthMax);
		//System.out.println(robot.getBattleFieldHeight());
		//System.out.println(robot.getBattleFieldWidth());
		System.out.println("xPos: " + xPos);
		System.out.println("yPos: " + yPos);
		
		//the coordinates of the mid point
		double yMidPoint = robot.getBattleFieldHeight() * 0.5; 
		double xMidPoint = robot.getBattleFieldWidth() * 0.5; 
		
		double currentRotation = robot.getHeading();
		
		double Velocity = robot.getVelocity();
			
		
		 if (xPos <= boundsHeightMin || xPos >= boundsHeightMax) {
			robot.go(xMidPoint, yMidPoint);
			skipMoveFunction = true;
		}
		
		if (yPos <= boundsWidthMin || yPos >=boundsWidthMax) {
			robot.go(xMidPoint, yMidPoint);
			skipMoveFunction = true;
			
		}
		
		if (Math.abs(yPos - yMidPoint) < 20 && Math.abs(xPos - xMidPoint) < 20 ) {
			skipMoveFunction = false;
			
		}
		
		if (Velocity == 0) {
			skipMoveFunction = false;
		}
		
		
	}
	

}

