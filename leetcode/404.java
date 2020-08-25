
class Solution {

    int result = 0;

    void find(TreeNode node) {
        if(node.left != null &&
                node.left.left == null && node.left.right == null) {
            result += node.left.val;
        }

        if(node.left != null) { find(node.left); }
        if(node.right != null) { find(node.right); }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) { return 0; }

        find(root);
        return result;
    }
}