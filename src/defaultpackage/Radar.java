package defaultpackage;

public class Radar {
	private Robot_feewEx1 robot;
	
	public Radar(Robot_feewEx1 robot) {
		 this.robot = robot;
	}
	
	public void look() {
		robot.setTurnRadarRight(25);
	}


}
