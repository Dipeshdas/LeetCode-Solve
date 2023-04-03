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
class Pair{
    TreeNode node;
    int pos;
    Pair(TreeNode node,int pos){
        this.node=node;
        this.pos=pos;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>q=new LinkedList<>();
        int max=0;
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().pos;//inedx of min node possilbe in every level
            int first=0,last=0;

            for(int i=0;i<size;i++){
                int cur_pos=q.peek().pos-min;//to avoid overflow
                TreeNode node=q.poll().node;
                if(i==0) first=cur_pos;
                if(i==size-1) last=cur_pos;

                if(node.left!=null) q.add(new Pair(node.left,(2*cur_pos)+1));
                if(node.right!=null) q.add(new Pair(node.right,(2*cur_pos)+2));
            }
            max=Math.max(max,last-first+1);

        }
        return max;
    }
}
