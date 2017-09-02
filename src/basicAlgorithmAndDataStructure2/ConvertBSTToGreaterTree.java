package basicAlgorithmAndDataStructure2;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree
 * such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * 
 * Example
 * Given a binary search Tree ｀{5,2,3}｀:
 *               5
 *             /   \
 *            2     13
 * Return the root of new tree
 *               18
 *              /   \
 *            20     13
 */

public class ConvertBSTToGreaterTree {
    /**
     * @param root the root of binary tree
     * @return the new root
     */
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
          return null;  
        }
        helper(root);
        return root;
    }
    
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left); 
    }
}
