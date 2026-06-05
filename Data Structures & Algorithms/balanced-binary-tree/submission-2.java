class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int l = height(root.left);
        if (l == -1) return -1; // early exit

        int r = height(root.right);
        if (r == -1) return -1; // early exit

        if (Math.abs(l - r) > 1) return -1;

        return 1 + Math.max(l, r);
    }
}