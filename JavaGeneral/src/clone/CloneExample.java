package clone;

/*
 * If not implemented Cloneable, will return CloneNotSupportedException
 * 
 * The address object will be same in the clone as well: Shallow copy
 * 
 * To DeepCopy: create and return a new object, and every composited objects, and set values inside clone method
 * 
 */

public class CloneExample implements Cloneable{
	
	int age = 20;
	String name = null;
	Address add = new Address();
	
	public CloneExample(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneExample ce = new CloneExample("rajan", 25);
		
		CloneExample clone = (CloneExample)(ce.clone());
		clone.age = 27;
		clone.name="najar";
		clone.add.street="1000 N 4th street";
		
		System.out.println("original obj hash code: " + System.identityHashCode(ce));
		System.out.println(ce);
		System.out.println("original obj hash code: " + System.identityHashCode(clone));
		System.out.println(clone);
	}
	
	@Override
	public String toString() {
		return String.format("{ name: %s, age: %d, Address:{zip: %d, street: %s } }", name, age, add.zip, add.street);
	}
	
}

class Address implements Cloneable{
	int zip = 30067;
	String street = "2560 delk road";
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
