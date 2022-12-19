package defaultpackage;

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
	

}

