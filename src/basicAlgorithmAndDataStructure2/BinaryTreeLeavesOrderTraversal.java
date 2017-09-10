package basicAlgorithmAndDataStructure2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 * 
 * Example
 * Given binary tree:
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * Returns [[4, 5, 3], [2], [1]].
 */

public class BinaryTreeLeavesOrderTraversal {
    /**
     * @param root the root of binary tree
     * @return collect and remove all leaves
     */
    Map<Integer, List<Integer>> depth = new HashMap<>();

    public int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int d = Math.max(dfs(cur.left), dfs(cur.right)) + 1;

        if (!depth.containsKey(d)) {
            depth.put(d, new ArrayList<Integer>());
        }
        depth.get(d).add(cur.val);
        return d;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        int max_depth = dfs(root);

        for (int i = 1; i <= max_depth; i++) {
            ans.add(depth.get(i));
        }
        return ans;
    }
}
