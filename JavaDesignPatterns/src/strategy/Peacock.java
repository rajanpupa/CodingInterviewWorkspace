package strategy;

public class Peacock extends Animal{

	public Peacock(){
		this.flyingObject = new CanFly();
	}
}
