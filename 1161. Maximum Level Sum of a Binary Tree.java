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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                temp.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            arr.add(temp);
            

        }
        int max=Integer.MIN_VALUE;
        int ind=0;
        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int e:arr.get(i)){
                sum+=e;
            }
            if(sum>max){
                ind=i+1;
                max=Math.max(sum,max);
            }
        }    
        return ind;
    }
}
