/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node>map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();

        q.add(node);
        map.put(node,new Node(node.val,new ArrayList<>()));

        while(!q.isEmpty()){
            Node n=q.peek();
            q.poll();

            for(Node e:n.neighbors){
                if(!map.containsKey(e)){
                    map.put(e,new Node(e.val,new ArrayList<>()));
                    q.add(e);
                }
                map.get(n).neighbors.add(map.get(e));
            }
        }
        return map.get(node);
        
    }
}
