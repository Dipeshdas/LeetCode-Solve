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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new LinkedList<>();
        
        if(root==null){
            return ans;
        }
        boolean leftToRight=true;
        int index=0;
        Queue<TreeNode>n=new LinkedList<>();
        n.add(root);
        while(!n.isEmpty()){
            int count=n.size();
            List<Integer>l=new ArrayList<>(count);
            
            for(int i=0;i<count;i++){
                TreeNode cur=n.poll();
        
                if(cur.left!=null){
                    n.add(cur.left);
                }
                if(cur.right!=null){
                    n.add(cur.right);
                }  
                if(leftToRight){
                    l.add(cur.val);
                }
                else{
                    l.add(0,cur.val);
                    //System.out.println(l);
                } 
            }
            leftToRight=!leftToRight;
            ans.add(l);
        }
        return ans;
        
        
    }
}
