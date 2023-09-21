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
    public static TreeNode parent_link(TreeNode root,Map<TreeNode,TreeNode>map,int start){
		Queue<TreeNode>q=new LinkedList<>();
		TreeNode res=null;
		q.add(root);

		while(!q.isEmpty()){
			TreeNode cur=q.poll();
			if(cur.val==start) res=cur;

			if(cur.left!=null){
				map.put(cur.left,cur);
				q.add(cur.left);
			}

			if(cur.right!=null){
				map.put(cur.right,cur);
				q.add(cur.right);
			}
		}
		return res;
	}

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode>parent_map=new HashMap<>();
        TreeNode target=parent_link(root,parent_map,start);
		
		Map<TreeNode,Boolean>visit=new HashMap<>();
		Queue<TreeNode>qu=new LinkedList<>();

		visit.put(target,true);
		qu.add(target);

		int minTime=0;
		while(!qu.isEmpty()){
			int size=qu.size();

			int flag=0;

			for(int i=0;i<size;i++){
				TreeNode cur=qu.poll();

				if(parent_map.get(cur)!=null && visit.get(parent_map.get(cur))==null){
					flag=1;
					visit.put(parent_map.get(cur),true);
					qu.add(parent_map.get(cur));
				}

				if(cur.left!=null && visit.get(cur.left)==null){
					flag=1;
					visit.put(cur.left,true);
					qu.add(cur.left);
				}

				if(cur.right!=null && visit.get(cur.right)==null){
					flag=1;
					visit.put(cur.right,true);
					qu.add(cur.right);
				}
			}

			if(flag==1) minTime++;
		}
		return minTime;
    }
}
