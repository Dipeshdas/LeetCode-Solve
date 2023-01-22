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
    int ans=0;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
         
         //2nd approach------------(2ms)

        // List<Integer>ar=new ArrayList<>();
        //inOrder(root,ar);        
        // return ar.get(k-1);
        
    }
    //2nd approach--------------(2ms)

    // public void inOrder(TreeNode root,List<Integer>ar){
    //     if(root==null) return;

    //     inOrder(root.left,ar);
    //     ar.add(root.val);
    //     inOrder(root.right,ar);

    // }
    public void inOrder(TreeNode root,int k){
        if(root==null) return;
        
        inOrder(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        inOrder(root.right,k);

    }

}
