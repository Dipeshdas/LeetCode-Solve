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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(0,nums.length-1,nums);

    }

    public TreeNode construct(int start,int end,int[]nums){
        if(start>end){
            return null;
        }
        int root=0;
        int rootInd=0;
        
        for(int i=start;i<=end;i++){
            if(nums[i]>=root){
                root=nums[i];
                rootInd=i;
            }
        }

        TreeNode head=new TreeNode(root);
        head.left=construct(start,rootInd-1,nums);
        head.right=construct(rootInd+1,end,nums);
        return head;
    }

}
