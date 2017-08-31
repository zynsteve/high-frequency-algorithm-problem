package interviewStyle;

/**
 * Given a non-empty string word and an abbreviation abbr,
 * return whether the string matches with the given abbreviation.
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string word.
 * Any other string is not a valid abbreviation of word.
 * 
 * Example
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * Return false.
 */

public class CheckWordAbbreviation {
    /**
     * @param word a non-empty string
     * @param abbr an abbreviation
     * @return true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) == '0') {
                return false;
            }
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                count = count * 10 + abbr.charAt(j) - '0';
                j++;
            }
            i = i + count;
            count = 0;
            if (i < word.length() && j < abbr.length()) {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        if (i != word.length() || j != abbr.length()) {
            return false;
        }
        return true;
    }
}
