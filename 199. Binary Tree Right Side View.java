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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>arr=new ArrayList<>();
        util(arr,root,0);
        return arr;
    }
    
    public void util(List<Integer>ar,TreeNode root,int level){
        if(root==null){
            return;
        }
        if(ar.size()<=level){
            ar.add(level,root.val);
        }
        else{
           ar.set(level,root.val); 
        }
        util(ar,root.left,level+1);
        util(ar,root.right,level+1);
    }
}
