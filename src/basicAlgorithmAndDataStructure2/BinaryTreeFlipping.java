package basicAlgorithmAndDataStructure2;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 * 
 * Example
 * Given a binary tree {1,2,3,4,5}
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 * return the root of the binary tree {4,5,2,#,#,3,1}.
 *       4
 *      / \
 *     5   2
 *        / \
 *       3   1  
 */

public class BinaryTreeFlipping {
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    TreeNode newRoot;

    public void dfs(TreeNode cur) {
        if (cur.left == null) {
            newRoot = cur;
            return;
        }
        dfs(cur.left);
        cur.left.right = cur;
        cur.left.left = cur.right;
        cur.left = null;
        cur.right = null;
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return newRoot;
    }
}
