package basicAlgorithmAndDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array
 * where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 * 
 * Example
 * Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
 * return ["2", "4->49", "51->74", "76->99"].
 */

public class MissingInterval {
    /**
     * @param nums a sorted integer array
     * @param lower an integer
     * @param upper an integer
     * @return a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            addToResults(results, (long)lower - 1, (long)upper + 1);
            return results;
        }
        addToResults(results, lower - 1, nums[0]);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp_higher = nums[i];
            addToResults(results, (long)last, (long)temp_higher);
            last = nums[i];
        }
        last = nums[nums.length - 1];
        addToResults(results, (long)last, (long)upper + 1);
        return results;
    }
    
    public void addToResults(List<String> results, long lower, long higher) {
        long range = higher - lower;
        if (range == 2) {
                results.add(String.valueOf(lower + 1));
            } else if (range > 2) {
                results.add(String.valueOf(lower + 1) + "->" + String.valueOf(higher - 1));
            } else {
                return;
            }
    }
}
