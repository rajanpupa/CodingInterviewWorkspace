import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Codec {
	
	public static void main(String[] args) {
		List<String> urls = new ArrayList<>() ;
		urls.add("https://leetcode.com/problems/design-tinyurl");
		urls.add("https://leetcode.com/problems/design-tinyurl2");
		
		Codec codec = new Codec();
		for(String url: urls) {
			System.out.println( codec.encode(url));
		}
	}
	
	
    Map<String, String> map = new HashMap<>();
    char[] arr = new char[6];
    public Codec(){
        Arrays.fill(arr, '0');
    }
    
    static String domain = "https://tiny.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = domain +  new String(arr);
        inc();
        map.put(key, longUrl);
        System.out.printf("key=%s, url=%s\n", key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    
    void inc() {
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == '9') {
                arr[i] = 'A';
                return;
            } else if( c == 'Z') {
                arr[i] = 'a';
                return;
            } else if( c == 'z') {
                arr[i] = '0';
                // continue to next index
            }else {
                arr[i] ++;
                return;
            }
        }
    }
}
