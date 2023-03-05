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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        //long maxSum=0;
        
        ArrayList<Long>maxArray=new ArrayList<>();
        while(!q.isEmpty()){
            
            List<Integer>list=new ArrayList<>();
            int count=q.size();
            
            for(int i=0;i<count;i++){
                TreeNode cur=q.poll();
                list.add(cur.val);
                if(cur.left!=null){
                    q.add(cur.left);
                }
                if(cur.right!=null){
                    q.add(cur.right);
                }   
            }
            
            long sum=0;
            for(int i=0;i<list.size();i++){
                sum+=list.get(i);
            }
            maxArray.add(sum);
            
            
        }
        if(k>maxArray.size()) return -1;
        Collections.sort(maxArray);
        return maxArray.get(maxArray.size()-k);
    }
}
