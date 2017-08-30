package basicAlgorithmAndDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only
 * and the length of both strings s and p will not be larger than 40,000.
 * The order of output does not matter.
 * 
 * Example
 * Given s = "cbaebabacd" p = "abc"
 * return [0, 6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

public class SubstringAnagrams {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList <Integer>();
        int[] sum = new int[30];

        int plength = p.length(), slength = s.length();
        for (char c : p.toCharArray()) {
            sum[c - 'a']++;
        }
        
        int start = 0, end = 0, matched = 0;
        while (end < slength) {
            if (sum[s.charAt(end) - 'a'] >= 1) {
                matched++;
            }
            sum[s.charAt(end) - 'a']--;
            end++;
            if (matched == plength) {
                ans.add(start);
            }
            if (end - start == plength) {
                if (sum[s.charAt(start) - 'a'] >= 0) {
                    matched--;
                }
                sum[s.charAt(start) - 'a']++;
                start++;
            }
        }
        return ans;
    }
}
