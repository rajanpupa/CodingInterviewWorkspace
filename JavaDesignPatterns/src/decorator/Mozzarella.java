package decorator;

public class Mozzarella extends ToppingDecorator{

	public Mozzarella(Pizza newPizza) {
		super(newPizza);
		// TODO Auto-generated constructor stub
		System.out.println("Adding Dough");
		System.out.println("Adding Moz");
	}
	
	public String getDescription(){
		return tempPizza.getDescription() + ", mozzarella";
	}
	
	public double getPrice(){
		System.out.println("Cost of Mosarella: " + 0.5);
		return tempPizza.getPrice() + .50;
	}

}
