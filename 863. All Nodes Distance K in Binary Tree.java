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

    public void parentLink(Map<TreeNode,TreeNode>parent_map,TreeNode root){
        
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode cur=q.poll();

            if(cur.left!=null){
                parent_map.put(cur.left,cur);
                q.add(cur.left);
            }

            if(cur.right!=null){
                parent_map.put(cur.right,cur);
                q.add(cur.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parent_map=new HashMap<>();
        parentLink(parent_map,root);

        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        Map<TreeNode,Boolean>visit=new HashMap<>();
        q.add(target);
        visit.put(target,true);

        int dis=0;
        while(!q.isEmpty()){
            int size=q.size();         
            if(dis==k) break;
            dis++;  

            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();

                if(cur.left!=null && visit.get(cur.left)==null){
                    visit.put(cur.left,true);
                    q.add(cur.left);
                }

                if(cur.right!=null && visit.get(cur.right)==null){
                    visit.put(cur.right,true);
                    q.add(cur.right);
                }

                if(parent_map.get(cur)!=null && visit.get(parent_map.get(cur))==null){
                    visit.put(parent_map.get(cur),true);
                    q.add(parent_map.get(cur));
                }

            }
            
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;

    }
}
