package leet.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// 127: Word ladder
// given begin word , endword and wordlist
// find in how many steps, is it possible to transform from begin word to endword using wordlist
// only one character change is possible at a time.

// solution:
/*
 * Put beginword in a list (reached)
 * for every element in the beginning of iter, find words in wordlist that are at one diff, add them to reached list, remove from wordlist
 * break if the size of reached list is same.
 * else continue for the new elements of the list
 * keep increasing step
 * 
 * at the end, if the reached list contains endword, return step
 * else not possible, return 0
 */

// working solution
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty()) return 0;
        if(! wordList.contains(endWord)) return 0;
        
        if(beginWord.equals(endWord)) return 0;
        
        List<String> reached = new ArrayList<>();
        List<String> dict = new ArrayList<>(wordList);
        
        reached.add(beginWord);
        int step = 1;
        
        while(! reached.contains(endWord)) {
        	
        	int rl = reached.size();
        	for(int i = 0; i < rl; i++) {
        		Iterator<String> dit = dict.iterator();
        		while(dit.hasNext()) {
        			String dst = dit.next();
        			if( this.diff( reached.get(i), dst ) == 1) {
        				reached.add(dst);
        				dit.remove();
        			}
        		}
        	}
            if(rl == reached.size()) break;
        	// delete elements from reached, no more needed to be iterated
        	reached = reached.subList(rl, reached.size());
        	
        	step ++;
        }
        
        if(reached.contains(endWord)){
            return step;
        }else{
            return 0;
        }
    }
	
	private int diff(String w1, String w2) {
		int count = 0;
		for(int i=0; i<w1.length(); i++) {
			if(w1.charAt(i) != w2.charAt(i)) {
				count ++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		
		//System.out.println(wl.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"))); // 5
		//System.out.println(wl.ladderLength("a", "c", Arrays.asList("a","b","c"))); // 2
		System.out.println(wl.ladderLength("hot", "dog", Arrays.asList("hot","dog"))); // 0
	}
}
