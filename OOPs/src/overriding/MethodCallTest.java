package overriding;

public class MethodCallTest {
	
	public static void main(String[] args) {
		MethodCallTest mct = new MethodCallTest();
		
		Integer value = null;
		
		mct.abc(value);// pass null here
	}
	
	public void abc(String arg){
		System.out.println("String:arg method() called");
	}
	
//	public void abc(int arg){
//		System.out.println("int:arg method() called");
//	}
	
	public void abc(Integer arg){
		System.out.println("int:arg method() called");
	}

}
