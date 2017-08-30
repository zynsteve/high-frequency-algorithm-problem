package basicAlgorithmAndDataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example
 * Given intervals => merged intervals:
 * [                     [
 *   [1, 3],               [1, 6],
 *   [2, 6],      =>       [8, 10],
 *   [8, 10],              [15, 18]
 *   [15, 18]            ]
 * ]
 */

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeIntervals {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

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
