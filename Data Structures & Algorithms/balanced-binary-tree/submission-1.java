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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
Boolean[] h = new Boolean[1];
h[0]=true;
height(root,h);
return h[0];
        
        
    }
    private int height(TreeNode root,Boolean[] h){
    if(root==null) return 0;

    int l =height(root.left,h);
    int r =height(root.right,h);
    if(Math.abs(l-r)>1)
     h[0]=false;


    return 1+Math.max(l,r);


    }
}
