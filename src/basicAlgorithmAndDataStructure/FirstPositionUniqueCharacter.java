package basicAlgorithmAndDataStructure;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * 
 * Example
 * Given s = "lintcode", return 0.
 * Given s = "lovelintcode", return 2.
 */

public class FirstPositionUniqueCharacter {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        int[] cnt = new int[256];

        for (char c : s.toCharArray()) {
            cnt[c]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
