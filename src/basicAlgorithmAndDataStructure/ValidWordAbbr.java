package basicAlgorithmAndDataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form.
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 *      1
 * b) d|o|g                   --> d1g
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word,
 * find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique
 * if no other word from the dictionary has the same abbreviation.
 * 
 * Example
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") // return false
 * isUnique("cart") // return true
 * isUnique("cane") // return false
 * isUnique("make") // return true
 */

public class ValidWordAbbr {
    Map<String, Set<String>> map;
    
    /** 
     * @param dictionary a list of word
     */
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String element : dictionary) {
            String abrev = getAbrev(element);
            if (map.containsKey(abrev)) {
                Set<String> s = map.get(abrev);
                if (!s.contains(element)) {
                s.add(element);
                }
            } else {
                Set<String> set = new HashSet<>();
                set.add(element);
                map.put(abrev, set);
            }
        }
    }

    /**
     * @param word a string
     * @return true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abrev = getAbrev(word);
        if (map.containsKey(abrev)) {
            Set<String> set = map.get(abrev);
            if (set.size() == 1 && set.contains(word)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    
    public String getAbrev(String word) {
        if (word == null || word.length() <= 0) {
            return word;
        }
        int len = word.length() - 2;
        String result = "" + word.charAt(0) + len + word.charAt(word.length() - 1);
        return result;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */
