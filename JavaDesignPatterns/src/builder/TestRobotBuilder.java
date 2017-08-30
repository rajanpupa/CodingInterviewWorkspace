package builder;

/*
 You use the builder design pattern when you want to have many classes help in the creation of an object. 
 By having different classes build the object you can then easily create many different types of objects 
 without being forced to rewrite code.

The Builder pattern provides a different way to make complex objects like you’d 
make using the Abstract Factory design pattern. All of the code follows the video to help you learn.

- See more at: http://www.newthinktank.com/2012/09/builder-design-pattern-tutorial/#sthash.zNS9FKsl.dpuf
 */
public class TestRobotBuilder {
	
	public static void main(String[] args){
		
		// Get a RobotBuilder of type OldRobotBuilder
		
		RobotBuilder oldStyleRobot = new OldRobotBuilder();
		
		// Pass the OldRobotBuilder specification to the engineer
		
		RobotEngineer robotEngineer = new RobotEngineer(oldStyleRobot);
		
		// Tell the engineer to make the Robot using the specifications
		// of the OldRobotBuilder class
		
		robotEngineer.makeRobot();
		
		// The engineer returns the right robot based off of the spec
		// sent to it on line 11
		
		Robot firstRobot = robotEngineer.getRobot();
		
		System.out.println("Robot Built");
		
		System.out.println("Robot Head Type: " + firstRobot.getRobotHead());
		
		System.out.println("Robot Torso Type: " + firstRobot.getRobotTorso());
		
		System.out.println("Robot Arm Type: " + firstRobot.getRobotArms());
		
		System.out.println("Robot Leg Type: " + firstRobot.getRobotLegs());
		
	}
	
}
