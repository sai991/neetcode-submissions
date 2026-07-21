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
    public int diameterOfBinaryTree(TreeNode root) {
       if(root ==null)return 0;
       int[] tm =new int[1];
        maxDepth(root,tm);
        return tm[0];

        
    }
 private int maxDepth(TreeNode root,int[] res) {

        if(root ==null) return 0;

        int left = maxDepth(root.left,res);
        int right=maxDepth(root.right,res);
        res[0]=Math.max(res[0],left+right);
        return 1+Math.max(left,right);
    }
}
