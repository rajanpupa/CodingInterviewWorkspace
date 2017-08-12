package trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
	Map<Character, Trie> nextMap = new HashMap<>();
	boolean endOfWord = false;
	
	// util methods
	public void insertWord(String word){
		Trie t1=this, t2=this;
		Character c;
		for(int i=0; i<word.length(); i++){
			t2 = t1;
			c = word.charAt(i);
			t1 = t2.getNextMap().get(c);
			
			if(t1 == null){
				t1 = new Trie();
				t2.getNextMap().put(c, t1);
				
			}
			
			if(i == word.length()-1){
				t1.setEndOfWord(true);
			}
		}
	}
	
	public boolean isWord(String word){
		Trie t1=this, t2=this;
		Character c;
		for(int i=0; i<word.length(); i++){
			t2 = t1;
			c = word.charAt(i);
			t1 = t2.getNextMap().get(c);
			
			if(t1 == null){
				return false;
			}else{
				if(i == word.length()-1){
					return t1.isEndOfWord();
				}
			}
		}
		
		return false;
	}
	
	public boolean isPrefix(String pre){
		Trie t1=this, t2=this;
		Character c;
		for(int i=0; i<pre.length(); i++){
			t2 = t1;
			c = pre.charAt(i);
			t1 = t2.getNextMap().get(c);
			
			if(t1 == null){
				return false;
			}else{
				if(i == pre.length()-1){
					return true;
				}
			}
		}
		return false;
	}
	
//	public List<String> findWords(String pre, int num){
//		List<String> words = new ArrayList<>();
//		
//		Trie t1=this, t2=this;
//		Character c;
//		StringBuffer sb = new StringBuffer("pre");
//		for(int i=0; i<pre.length(); i++){
//			t2 = t1;
//			c = pre.charAt(i);
//			t1 = t2.getNextMap().get(c);
//			
//			if(t1 == null){
//				return words;
//			}
//		}
//		// at the end of the above loop, t1 is at the end of prefix, so ready find words
////		if(t1.isEndOfWord()){
////			words.add(pre);
////		}
//		StackExample<Trie> stack = new StackExample<Trie>();
//		stack.push(t1);
//		while(words.size() < num && !stack.isEmpty()){
//			t1 = stack.peek();
//			
//			for(Character key: t1.getNextMap().keySet()){
//				t2 = t1.getNextMap().get(key);
//				if(t2 != null)
//			}
//			
//			if(t1.isEndOfWord()){
//				words.add(sb.toString());
//				sb = new StringBuffer(pre);
//			}
//		}
//		
//		return words;
//	}
	// getters and setters
	public Map<Character, Trie> getNextMap() {
		return nextMap;
	}
	public void setNextMap(Map<Character, Trie> nextMap) {
		this.nextMap = nextMap;
	}
	public boolean isEndOfWord() {
		return endOfWord;
	}
	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		List<String> words = Arrays.asList("apple", "arts", "oranges", "ball", "alphabet", "antique", "an"
				,"appler", "pple");
		
		for(String str : words){
			t.insertWord(str);
		}
		
		System.out.println("isWord   abc = " + t.isWord("abc"));
		System.out.println("isWord   apple = " + t.isWord("apple"));
		System.out.println("isPrefix app = " + t.isPrefix("app"));
		System.out.println("isPrefix pple = " + t.isPrefix("pple"));
		System.out.println("isPrefix appler = " + t.isPrefix("appler"));
	}
}
