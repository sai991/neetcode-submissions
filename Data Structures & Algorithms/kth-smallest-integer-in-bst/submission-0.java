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
    public int kthSmallest(TreeNode root, int k) {

        if(root==null){
            return 0;
        }
        List<Integer> l = new ArrayList<>();
        preOrder(root,l);

        return l.get(k-1);

        
    }

    private void preOrder(TreeNode root,List<Integer> l){

        if(root==null){
            return;
        }
preOrder(root.left,l);
l.add(root.val);
preOrder(root.right,l);
        
    }

    }

