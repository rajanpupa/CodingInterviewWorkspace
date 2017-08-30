package strategy;

public interface Flys {
	public void fly();
}

class CanFly implements Flys{
	public void fly(){
		System.out.println(" I can fly ");
	}
}

class CannotFly implements Flys{
	public void fly(){
		System.out.println(" I cannot fly ");
	}
}