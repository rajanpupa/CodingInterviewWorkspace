package decorator;

public class PlainPizza implements Pizza{

	@Override
	public String getDescription() {
		return "Thin dough";
	}

	@Override
	public double getPrice() {
		System.out.println("Cost of plain pizza : " + 5.00);
		return 5.00;
	}

}
