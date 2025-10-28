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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode n1,TreeNode n2){
        //If both sides are null at the same time, return True because we reach the end of a tree.
        if(n1==null && n2==null){
            return true;
        }
        //If one of sides is null, return False because it's not symmetric.
        if(n1==null || n2==null){
            return false;
        }
        return n1.val==n2.val && isMirror(n1.left,n2.right) && isMirror(n1.right,n2.left);
    }
}