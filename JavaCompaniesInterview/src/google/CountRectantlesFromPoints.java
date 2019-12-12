package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Provided a list of points, 
 * count how many rectangles can be formed from the points.
 * 
 * -- Assumptions
 * - points are always parallel to the axis
 * 
 * [(0,1), (2,1), (5,1), (0,0), (2,0), (5,0)] -> 3 rectangles
 *
 */

public class CountRectantlesFromPoints {
	Map<Integer, Integer> rectangleCount = new HashMap() ;
	
	
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(
					new Point(0,1),
					new Point(2,1),
					new Point(5,1),
					new Point(0,0),
					new Point(2,0),
					new Point(5,0),
					new Point(4,1),
					new Point(4, 0)
				);
		
		System.out.println(new CountRectantlesFromPoints().countRectangles(points));
	}
	
	public CountRectantlesFromPoints() {
		rectangleCount.put(1,0);
	}
	
	
	
	
	Map<Integer, List<Point>> y_map = new HashMap<>();
	//Map<Integer, List<Point>> x_map = new HashMap<>();
	
	public int countRectangles(List<Point> points) {
		
		// put x and y in map
		for(Point p : points) {
			List<Point> pointListy = getPointsByKey(y_map, p.y);
			pointListy.add(p);
			//List<Point> pointListx = getPointsByKey(x_map, p.x);
			//pointListx.add(p);
		}
		
		// for each horizontal plane combination, check how many lines are there
		List yList = Arrays.asList(y_map.keySet().toArray());
		Integer rectantles = 0;
		for(int i = 0; i<yList.size()-1; i++) {
			for(int j = i+1; j<yList.size(); j++) {
				// check lines between ith and jth plane
				List<Point> ithPoints = y_map.get(i);
				List<Point> jthPoints = y_map.get(j);
				
				int c = 0; // number of lines between these two planes
				for(Point ithPoint: ithPoints) {
					for(Point jthPoint: jthPoints) {
						if(ithPoint.x == jthPoint.x) {
							// match found
							c++;
							break;
						}
					}
				}
				// so thare are c lines between ith and jth horizontal plane
				rectantles += getRectanglesCount(c);
				
			}
		}
		return rectantles;
	}
	
	
	private int getRectanglesCount(Integer c) {
		if(c <=1 ) return 0;
		
		Integer count = rectangleCount.get(c);
		
		if(count == null) {
			count = getRectanglesCount(c-1) + c - 1;
			rectangleCount.put(c, count);
		}
		return count;
	}

	private List<Point> getPointsByKey(Map<Integer, List<Point>> map, Integer key){
		List<Point> points = map.get(key);
		
		if(points == null) {
			points = new ArrayList<>();
			map.put(key, points);
		}
		
		return points;
	}

}


class Point{
	public int x;
	public int y;
	
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/**
 * Solution:
 *  Let n be number of lines that is between two horizontal parallel planes. 
 *  Let R(n) be the number of rectangles that can be formed by n lines.
 *  
 *  Then we have 
 *  	R(0) -> 0
 *  	R(1) -> 0
 *  	R(2) -> 1
 *  	R(3) -> 2
 *  	R(n) -> R(n-1) + (n-1)
 *  
 *  Now the problem is to find how horizontal planes can be formed by the list of planes, and how many lines fit in those planes.
 *  
 *  - Basically each y coordinated in the list of point is a possible horizontal plane
 *  - if there are 2 points with same y coordinate, forms a plane.
 *  	for points in one plane, if there are other points in other plane with same x-coordinate, forms one line between those two planes.
 *  	
 */