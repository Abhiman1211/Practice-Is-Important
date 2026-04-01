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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

        return root;
    }

    private TreeNode dfs(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int rootIn = map.get(root.val);
        int leftNum = rootIn - is;

        root.left = dfs(preorder, ps+1, ps+leftNum, inorder, is, rootIn-1);
        root.right = dfs(preorder, ps+leftNum+1, pe, inorder, rootIn+1, ie);

        return root;
    }
}
