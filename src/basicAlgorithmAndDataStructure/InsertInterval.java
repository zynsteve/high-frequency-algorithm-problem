package basicAlgorithmAndDataStructure;

import java.util.ArrayList;

/**
 * Given a non-overlapping interval list which is sorted by start point.
 * Insert a new interval into it,
 * make sure the list is still in order and non-overlapping (merge intervals if necessary).
 * 
 * Example
 * Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
 * Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
 */

public class InsertInterval {
    /**
     * Insert newInterval into intervals.
     *
     * @param intervals:   Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        
        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);

        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end);
            }
        }
        return ans;
    }
}
