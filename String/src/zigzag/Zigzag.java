package zigzag;

import java.util.ArrayList;
import java.util.List;

public class Zigzag {
	
	public static void main(String[] args) {
		Zigzag zigzag = new Zigzag();
		
		System.out.println(zigzag.convert("paypalishiring", 3));
	}
	
	public String convert(String s, int numRows) {
        if(s == null || s.length() <= numRows || numRows == 1) return s;
        
        List<StringBuilder> lists = new ArrayList<>();
        
        for(int i=0; i< numRows; i++){
            lists.add(new StringBuilder());
        }
        
        int row = 0;
        Boolean flag = true;
        
        for(int i=0; i<s.length(); i++){
            if(flag){
                if(row < numRows -1){
                    lists.get(row).append(s.charAt(i));
                    row ++;
                }else if(row == numRows -1){
                    lists.get(row).append(s.charAt(i));
                    flag = !flag;
                    row--;
                }
            }else if(!flag){
                if(row > 0){
                    lists.get(row).append(s.charAt(i));
                    row --;
                }else if(row == 0){
                    lists.get(row).append(s.charAt(i));
                    flag = !flag;
                    row++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(StringBuilder ss: lists){
            sb.append(ss.toString());
        }
        
        return sb.toString();
        
    }

}
