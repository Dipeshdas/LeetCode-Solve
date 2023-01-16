/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;

        Queue<Node>q=new LinkedList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur==null && q.isEmpty()){
                return root;
            }

            if(cur==null){
                q.add(null);
            }
            else{
                cur.next=q.peek();

                if(cur.left!=null){
                    q.add(cur.left);
                }

                if(cur.right!=null){
                    q.add(cur.right);
                }
            }
        }
        return root;
    }
}
