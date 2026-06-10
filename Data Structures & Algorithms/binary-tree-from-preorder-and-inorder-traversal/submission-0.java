

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        
        // Populate the map with inorder values and their respective indices
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        // Call the helper function with initial boundaries
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, 
                                  inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd, 
                              Map<Integer, Integer> inMap) {
        
        // Base case: if pointers cross, the subtree is empty
        if (preStart > preEnd || inStart > inEnd) return null;
        
        // The first element in the current preorder range is always the root
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the index of this root in the inorder traversal
        int inRoot = inMap.get(root.val);
        
        // Calculate how many elements are in the left subtree
        int numsLeft = inRoot - inStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                              inorder, inStart, inRoot - 1, inMap);
                              
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                               inorder, inRoot + 1, inEnd, inMap);
                               
        return root;
    }
}