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

 class Pair{
    TreeNode root;
    int val;
    Pair(TreeNode root,int val){
        this.root=root;
        this.val=val;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int width=0;
        while(!q.isEmpty()){            
            int min=q.peek().val;
            int size=q.size();
            int first=0;int last=0;
            for(int i=0;i<size;i++){
                int cur_id=q.peek().val-min;
                TreeNode node=q.peek().root;
                q.poll();
                if(i==0){
                    first=cur_id;
                }
                if(i==size-1){
                    last=cur_id;
                }

                if(node.left!=null){
                    q.add(new Pair(node.left,2*cur_id+1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right,2*cur_id+2));
                }
            }
            width=Math.max(width,last-first+1);           
        }
        return width;

        
    }
}