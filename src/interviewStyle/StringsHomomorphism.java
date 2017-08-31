package interviewStyle;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * You may assume both s and t have the same length.
 * 
 * Example
 * Given s = "egg", t = "add", return true.
 * Given s = "foo", t = "bar", return false.
 * Given s = "paper", t = "title", return true.
 */

public class StringsHomomorphism {
    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
	public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int cs = (int)s.charAt(i);
            int ts = (int)t.charAt(i);
            if (m1[cs] == 0 && m2[ts] == 0) {
                m1[cs] = ts;
                m2[ts] = 1;
            } else if (m1[cs] != ts) {
                return false;
            }
        }
        return true;
    }
}
