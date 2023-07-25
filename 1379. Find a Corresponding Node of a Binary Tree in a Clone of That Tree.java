/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        return preOrder(original,cloned,target);   
    }
    public final TreeNode preOrder(final TreeNode original, final TreeNode cloned, final TreeNode target){
        if(original==null){
            return null;
        }
        if(target==original){
            ans=cloned;
        }
        preOrder(original.left,cloned.left,target);
        preOrder(original.right,cloned.right,target);
        return ans;
    }
}
