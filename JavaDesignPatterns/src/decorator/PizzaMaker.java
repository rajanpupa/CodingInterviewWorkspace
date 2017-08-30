package decorator;

/*
The Decorator allows you to modify an object dynamically. 
You would use it when you want the capabilities of inheritance with subclasses, 
but you need to add functionality at run time.

It is more flexible than inheritance. 
The Decorator Design Pattern simplifies code because you add functionality using many simple classes. 
Also, rather than rewrite old code you can extend it with new code and that is always good.

- See more at: http://www.newthinktank.com/2012/09/decorator-design-pattern-tutorial/#sthash.mjyJEDvI.dpuf
 */

public class PizzaMaker {
	
	public static void main(String[] args){
		
		// The PlainPizza object is sent to the Mozzarella constructor
		// and then to the TomatoSauce constructor
		
		Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
		
		System.out.println("Ingredients: " + basicPizza.getDescription());
		
		System.out.println("Price: " + basicPizza.getPrice());
		
	}
	
}