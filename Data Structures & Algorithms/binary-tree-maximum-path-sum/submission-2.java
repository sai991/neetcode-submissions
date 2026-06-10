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
    public int maxPathSum(TreeNode root) {
        int[] sk = new int[1];
        sk[0]=Integer.MIN_VALUE;
        sun(root,sk);
        return sk[0];
    }


    private int sun(TreeNode root, int[]  res){
        if(root==null){
            return 0;
        }

       // FLOATING FIX: If the path sum from a child is negative, discard it by taking 0
        int leftsum = Math.max(0, sun(root.left, res));
        int rightsum = Math.max(0, sun(root.right, res));

        res[0]= Math.max(res[0],leftsum+rightsum+root.val);

        return root.val+Math.max(leftsum,rightsum);
    }
}
