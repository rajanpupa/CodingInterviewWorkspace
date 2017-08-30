package strategy;

public class Dog extends Animal{

	public Dog(){
		this.flyingObject = new CannotFly();
	}
}
