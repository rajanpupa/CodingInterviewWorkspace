package abstractFactory;
/*
 The abstract factory pattern provides a way to encapsulate 
 a group of individual factories that have a common theme without specifying their concrete classes.
 */
public class ApplicationTest {
	
public static void main(String[] args) {
		
		// EnemyShipBuilding handles orders for new EnemyShips
		// You send it a code using the orderTheShip method &
		// it sends the order to the right factory for creation
	
		EnemyShipBuilding MakeUFOs = new UFOEnemyShipBuilding();
 
		EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO");
		System.out.println("-------------------------------------------\n");
		System.out.println(theGrunt + "\n");
		
		System.out.println("-------------------------------------------\n");
		EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
		System.out.println(theBoss + "\n");
 
	}
	
}
