package leetcode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//438: Find All Anagrams in a String
public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams3("cbaebabacd", "abc")); // [0,6]
        System.out.println(findAnagrams3("baa", "aa")); // [1]
        System.out.println(findAnagrams3("aaaa", "aa")); // [0,1,2]
        System.out.println(findAnagrams3("abacbabc", "abc")); // [1,2,3,5]
        
        StringBuilder sb = new StringBuilder();
        StringBuilder pb = new StringBuilder();
        for(int i=0; i<20001; i++) sb.append('a');
        for(int i=0; i<10000; i++) pb.append('a'); // long running

        // String s = sb.toString();
        // String p = pb.toString();

        //System.out.println(findAnagrams3(s, p));
    }

    // sliding window solution
    public static List<Integer> findAnagrams3(String s, String p){
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;

        int[] sfreq = new int[26];
        int[] pfreq = new int[26];

        // window length
        int plen = p.length();

        // fill p's frequency
        for(char c: p.toCharArray()) pfreq[c-'a'] ++;

        // window's frequency in s
        for(int i=0; i<plen; i++) sfreq[s.charAt(i)-'a'] ++;

        // abcabc abc
        for(int i=plen; i<s.length(); i++){
            if(Arrays.equals(sfreq, pfreq)){
                ans.add(i-plen);// that's where cur window started
            }
            sfreq[s.charAt(i) - 'a'] ++;
            sfreq[s.charAt(i-plen) - 'a'] --;
        }

        if(Arrays.equals(sfreq, pfreq)){
            ans.add(s.length() - plen);
        }


        return ans;
    }

    // trying to make it more efficient
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> l = new ArrayList<>();
        if(s==null) return l;
        if(s.length() < p.length()) return l;
        
        Map<Character, Integer> m = new HashMap<>();
        for(char c : p.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);

        int i=0;
        while(i < s.length()){ // i++
            Map<Character, Integer> tm = new HashMap<>();
            int j=i;
            while(j < i + p.length() && j<s.length()){
                char c = s.charAt(j);
                if( ! m.containsKey(c)) {
                    i = j;
                    break;
                }
                if(tm.getOrDefault(c,0) < m.get(c)){
                    tm.put(c, tm.getOrDefault(c, 0) + 1);
                    if(valsum(tm) == p.length()){
                        l.add(i);
                        //break;
                        // for search from i+1 th character of s
                        tm.put(s.charAt(i) , tm.get(s.charAt(i))-1);
                        i++;
                    }
                }else{
                    break;
                }
                j++;
            }//for
            i++;
        }
        
        return l;
    }

    // works but is not efficient
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        
        if(s==null) return l;
        if(s.length() < p.length()) return l;
        
        Map<Character, Integer> m = new HashMap<>();
        for(char c : p.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);
        
       
        for(int i=0; i< s.length(); i++){
            Map<Character, Integer> tm = new HashMap<>();
            for(int j=i; j < i + p.length() && j < s.length(); j++){
                char c = s.charAt(j);
                if( ! m.containsKey(c)) {
                    i = j+1;
                    break;
                }

                if(tm.getOrDefault(c,0) < m.get(c)){
                    tm.put(c, tm.getOrDefault(c, 0) + 1);
                    if(valsum(tm) == p.length()){
                        l.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        
        return l;
    }

    private static int valsum(Map<Character, Integer> m){
        int sum = 0;
        for(Integer i: m.values()){
            sum += i;
        }
        return sum;
    }
}