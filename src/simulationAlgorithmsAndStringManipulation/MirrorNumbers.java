package simulationAlgorithmsAndStringManipulation;

/**
 * A mirror number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is mirror. The number is represented as a string.
 * 
 * Example
 * For example, the numbers "69", "88", and "818" are all mirror numbers.
 * Given num = "69" return true
 * Given num = "68" return false
 */

public class MirrorNumbers {
    /**
     * @param num a string
     * @return true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[256];
        map['0'] = '0';
        map['1'] = '1';
        map['6'] = '9';
        map['8'] = '8';
        map['9'] = '6';
        for (int i = 0; i < num.length(); i++) {
            int j = num.length() - i - 1;
            if (map[num.charAt(i)] != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
