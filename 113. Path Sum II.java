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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>res =new ArrayList<>();
        List<Integer>ar=new ArrayList<>();

        solve(root,targetSum,res,ar);
        return res;
        
    }

    public void solve(TreeNode root,int targetSum,List<List<Integer>>res,List<Integer>ar){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
            if(targetSum==root.val){
                ArrayList<Integer>base=new ArrayList<>(ar);
                base.add(root.val);
                res.add(base);
            }
            return; 
        }

        ar.add(root.val);
        solve(root.left,targetSum-root.val,res,ar);
        solve(root.right,targetSum-root.val,res,ar);
        ar.remove(ar.size()-1);
    }
}
