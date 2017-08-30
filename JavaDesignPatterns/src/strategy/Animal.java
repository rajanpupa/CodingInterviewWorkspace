package strategy;

/*
 You use this pattern if you need to dynamically change an algorithm used by an object at run time. 

The pattern also allows you to eliminate code duplication.
It separates behavior from super and subclasses. It is a super design pattern and is often the first one taught.

- See more at: http://www.newthinktank.com/2012/08/strategy-design-pattern-tutorial/#sthash.SDC3ublv.dpuf
 */
public abstract class Animal {
	public String name;
	public int height;
	public int weight;
	
	Flys flyingObject;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public int getHeight(){
		return height;
	}
	public void setWeight(int Weight){
		this.weight = Weight;
	}
	public int getWeight(){
		return weight;
	}
	
	public void fly(){
		flyingObject.fly();
	}
	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal bird = new Peacock();
		
		dog.fly();
		bird.fly();
	}
}
