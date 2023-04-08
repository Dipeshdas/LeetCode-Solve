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
    public int maxPathSum(TreeNode root) {
        int []ans=new int[1];
        ans[0]=Integer.MIN_VALUE;
        solve(root,ans);
        return ans[0];        
    }

    public int solve(TreeNode root,int[]ans){
        if(root==null) return 0;

        //if solve(root.left,ans) return the value < 0 then leftSum = 0;
        int leftSum=Math.max(0,solve(root.left,ans));

        //if solve(root.right,ans) return the value < 0 then rightSum = 0;
        int rightSum=Math.max(0,solve(root.right,ans));

        ans[0]=Math.max(ans[0],leftSum+rightSum+root.val);

        return root.val+Math.max(leftSum,rightSum);
    }
}
