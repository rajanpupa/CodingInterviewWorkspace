package observer.example;

import java.util.Observable;

public class MessageBoard extends Observable{
	private String message;
	
	public String getMessage(){
		return message;
	}
	
	public void changeMessage(String message){
		this.message = message;
		setChanged();
		notifyObservers(message);
	}
	
	//main
	public static void main(String[] args) {
		MessageBoard board = new MessageBoard();
		Student bob = new Student("BoB");
		Student joe = new Student("Joe");
		board.addObserver(bob);
		board.addObserver(joe);
		board.changeMessage("More Homework!");
	}

}
