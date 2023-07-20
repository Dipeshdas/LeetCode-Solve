import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/

public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<Integer>in=new ArrayList<>();
		List<Integer>pre=new ArrayList<>();
		List<Integer>post=new ArrayList<>();
		List<List<Integer>>ans=new ArrayList<>();

		if(root==null) return ans;

		Stack<Pair>st=new Stack<>();
		st.push(new Pair(root,1));

		while(!st.isEmpty()){
			Pair pr=st.pop();

			if(pr.num==1){
				pre.add(pr.node.data);
				pr.num++;
				st.push(pr);
				if(pr.node.left!=null){
					st.push(new Pair(pr.node.left,1));
				}
			}
			else if(pr.num==2){
				in.add(pr.node.data);
				pr.num++;
				st.push(pr);
				if(pr.node.right!=null){
					st.push(new Pair(pr.node.right,1));
				}
			}
			else{
				post.add(pr.node.data);
			}
		}

		ans.add(in);
		ans.add(pre);
		ans.add(post);

		return ans;
    }
}

class Pair{
	BinaryTreeNode<Integer> node;
	int num;
	Pair(BinaryTreeNode<Integer> node,int num){
		this.node=node;
		this.num=num;
	}
}
