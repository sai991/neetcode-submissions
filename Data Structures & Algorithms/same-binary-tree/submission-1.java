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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> l = new ArrayList<>();
         List<Integer> r = new ArrayList<>();

         inOrder(p,l);
         inOrder(q,r);
         if(l.size()!=r.size())
         return false;

         for(int i=0;i<l.size();i++){
            if(l.get(i)!=r.get(i)){
                return false;
            }
         }


        return true;
    }
    private void inOrder(TreeNode k,List<Integer> l){

        if(k==null){
            l.add(0);
            return;
        }

        l.add(k.val);
        inOrder(k.left,l);
        inOrder(k.right,l);

        
    }


}
