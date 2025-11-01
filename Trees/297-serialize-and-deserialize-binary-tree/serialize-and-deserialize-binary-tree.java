/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        StringBuilder s=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                s.append("null,");
                continue;
            }
            s.append(node.val+",");
            q.add(node.left);
            q.add(node.right);
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")){
            return null;
        }
        Queue<TreeNode> q=new LinkedList<>();
        String[] values=data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

       int i=1;
        while (!q.isEmpty() && i < values.length) {
            TreeNode parent=q.poll();
            if(!values[i].equals("null")){
                parent.left=new TreeNode(Integer.parseInt(values[i]));
                //parent.left=left;
                q.add(parent.left);
            }
            i++;
            if(i < values.length && !values[i].equals("null")){
                parent.right=new TreeNode(Integer.parseInt(values[i]));
                //parent.right=right;
                q.add(parent.right);
            }
            i++;
        }
        return root;        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));