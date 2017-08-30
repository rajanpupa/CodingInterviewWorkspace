# Observer and Observable

* Observer is an Interface and observable is a class.
* Observable maintains a list of observers
* When an Observable object is updated, it invokes the update() method of each of its observers to notify that it is changed.

 ```
 //observable
 		board.addObserver(bob);
		board.addObserver(joe);
		board.changeMessage("More Homework!");

// Observer
		public void update(Observable o, Object arg) {
			System.out.println(name + "-> Message board changed ->" + arg);
		}
 
 ```