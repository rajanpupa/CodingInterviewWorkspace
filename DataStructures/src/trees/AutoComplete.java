package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AutoComplete {
	Trie trie = new Trie();
	
	public static void main(String[] args) {
		AutoComplete ac = new AutoComplete();
		
		ac.addWords(Arrays.asList("Apple", "Artist", "Apprehension", "Arrange", "Aeroplane"));
		
		List<String> result = ac.query("Ar");
		
		System.out.println(result);
	}

	private List<String> query(String query) {
		return trie.find(query);
	}

	private void addWords(List<String> asList) {
		for(String str: asList) {
			trie.insert(str);
		}
	}
	
	class Trie{
        Map<Character, Trie> map = new TreeMap<>();
        boolean end = false;
        
        public Trie(){}
        public Trie(String str) {
            insert(str);
        }
        public Trie(List<String> strs) {
            for(String str: strs) {
                insert(str);
            }
        }
        
        void insert(String str) {
            Map<Character, Trie> m2 = map;
            
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                Trie n2 = m2.get(c);
                if(n2 == null) {
                    n2 = new Trie();
                    m2.put(c, n2);
                }
                m2 = n2.map;
                if(i == str.length()-1) {
                    n2.end = true;
                }
            }
        }
        
        public boolean isString(String str) {
            Map<Character, Trie> m2 = map;
            Trie n2 = this;
            for(int i=0; i<str.length(); i++) {
                char c = str.charAt(i);
                n2 = m2.get(c);
                if(n2 == null) return false;
                m2 = n2.map;
            }
            return n2.end;
        }
        public List<String> find(String query) {
            Map<Character, Trie> m2 = map;
            Trie n2 = this;
            List<String> result = new ArrayList<>();
            
            for(int i=0; i<query.length(); i++) {
                char c = query.charAt(i);
                n2 = m2.get(c);
                if(n2 == null) return result;
                m2 = n2.map;
            }
            
            // find top 3 results from the node
            StringBuilder sb = new StringBuilder(query);
            find(result, sb, n2, 3);
            
            return result;
        }
        
        void find(List<String> res, StringBuilder sb, Trie n2, int total) {
            if(res.size() == total) return;
            
            Map<Character, Trie> m2 = n2.map;
            
            for(char c: m2.keySet()) {
                sb.append(c);
                
                Trie t2 = m2.get(c);
                
                if(t2.end) {
                    res.add(sb.toString());
                } else {
                    find(res, sb, t2, total);
                }
                
                if(res.size() >= total) break;
                sb.deleteCharAt(sb.length()-1);
                
            }
        } // find
    }
}
