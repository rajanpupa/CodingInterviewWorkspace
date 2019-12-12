package objectfinal;

import java.util.Arrays;
import java.util.List;

public class Employee {
	
	int employeeId;
	
	public Employee() {}
	public Employee(int id) {
		this.employeeId = id;
	}
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public static void main(String[] args) {
		
//		final Employee employee = new Employee();
//		
//		employee.setEmployeeId(1);
//		
//		System.out.println(employee.getEmployeeId());
//		
//		System.out.println("eggs".substring(2) + "eggs".substring(0,2));
		
		// variable employee can't be reassigned
		//employee = new Employee(2);
		String s = "abc";
		int len = s.length();
		
		System.out.println(s.substring( (len+1) / 2 ) + s.charAt( len/2 ) + s.substring(0, (len)/2 ));
		
		List<String> strs = Arrays.asList("a", "ab", "abc", "abcd", "abcde");
		strs.forEach(a -> {
			System.out.println(swap(a));
		});
	}
	
	public static String swap(String s) {
		if(s == null || s.length()<2) return s;
		
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		
		if(len%2 == 0) return s.substring(len/2) + s.substring(0,len/2);
		
		return s.substring( (len+1) / 2 ) + s.charAt( len/2 ) + s.substring(0, (len)/2 );
	}

}
