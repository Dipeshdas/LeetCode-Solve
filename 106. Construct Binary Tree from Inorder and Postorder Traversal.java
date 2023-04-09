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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }

    public TreeNode solve(int[]postorder,int postStart,int postEnd,int[]inorder,int inStart,int inEnd,
                        HashMap<Integer,Integer>map){

            if(postStart>postEnd || inStart>inEnd) return null;

            TreeNode root=new TreeNode(postorder[postEnd]);

            int inRoot=map.get(root.val);
            int numsLeft=inRoot-inStart;

            root.left=solve(postorder,postStart,postStart+numsLeft-1,inorder,inStart,inRoot-1,map);
            root.right=solve(postorder,postStart+numsLeft,postEnd-1,inorder,inRoot+1,inEnd,map);

            return root;

    }
}
