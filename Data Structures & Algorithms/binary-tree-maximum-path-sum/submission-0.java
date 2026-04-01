/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        // Only take positive contributions from subtrees
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // Update global maximum if path passes through this node
        maxVal = Math.max(maxVal, node.val + leftMax + rightMax);

        // Return maximum gain to parent (choose one side)
        return node.val + Math.max(leftMax, rightMax);
    }
}

