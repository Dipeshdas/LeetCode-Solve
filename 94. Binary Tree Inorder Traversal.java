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
    
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer>l=new ArrayList<>();
    //     traverse(root,l);
    //     return l;
    // }
    
    // public void traverse(TreeNode root,List<Integer>l){
    //     if(root==null){
    //         return;
    //     }
    //     traverse(root.left,l);
    //     l.add(root.val);
    //     traverse(root.right,l);
        
    // }


    //Iterative Solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        Stack<TreeNode>st=new Stack<>();
        TreeNode temp=root;
        while(true){
            if(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            else{
                if(st.isEmpty()) break;
                temp=st.pop();
                l.add(temp.val);
                temp=temp.right;
            }
        }
        return l;
    }
}
