package decorator;

public class ToppingDecorator implements Pizza{
	protected Pizza tempPizza;
	
	public ToppingDecorator(Pizza newPizza){
		this.tempPizza = newPizza;
	}
	
	public String getDescription(){
		return tempPizza.getDescription();
	}
	
	public double getPrice(){
		return tempPizza.getPrice();
	}
}
