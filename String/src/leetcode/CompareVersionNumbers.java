package leetcode;

public class CompareVersionNumbers {
	
	public static void main(String[] args) {
		System.out.println(
				// compareVersion("02.01", "01.01")
				compareVersion("02", "02.00")
		);
	}
	
	public static int compareVersion(String version1, String version2) {
        
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        
        //System.out.println(v1.length);
        for(int i=0,j=0; i<v1.length && j<v2.length; i++, j++){
            int res = comp(v1[i], v2[j]);
            System.out.printf("%s, %s , %s\n", v1[i], v2[j], res);
            
            if( res != 0){
                return res;
            }
        }
        
        if(v1.length > v2.length) {
            return 1;
        }else if(v1.length < v2.length){
            return -1;
        }
        return 0;
    }
    
    private static int comp(String v1, String v2){
        
        Integer i1 =  Integer.valueOf(v1);
        Integer i2 =  Integer.valueOf(v2);
        
        System.out.println(i1 + "," + i2);
        
        return i1.compareTo(i2);
    }
}
