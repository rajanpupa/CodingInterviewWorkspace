package gumgum;

public class Solution {

	public static void main(String[] args) {
		
	}
}

class Point2D{
	int x;
	int y;
	public Point2D(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double dist2D(Point2D p){
		return Math.sqrt(Math.pow(p.x-this.x, 2) + Math.pow(p.y-this.y, 2));
	}
	
	public void printDistance(double d){
		System.out.printf("%d \n", (int)(Math.ceil(d)) );
	}
}
class Point3D extends Point2D{

	int z;
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public double dist3D(Point3D p){
		return Math.sqrt(Math.pow(p.x-this.x, 2) 
				+ Math.pow(p.y-this.y, 2) 
				+ Math.pow(p.z-this.z, 2)
				);
	}
	
}