
class DisjointSet{
    List<Integer>size=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUParent(int node){
        if(node==parent.get(node)){
            return node;
        }
        int uLp=findUParent(parent.get(node));
        parent.set(node,uLp);
        return parent.get(node);
    }

    public void UnionBySize(int u,int v){
        int uLp_u=findUParent(u);
        int uLp_v=findUParent(v);

        if(uLp_u==uLp_v) return;//same componenet;

        if(size.get(uLp_u)<size.get(uLp_v)){
            parent.set(uLp_u,uLp_v);
            size.set(uLp_v,size.get(uLp_v)+size.get(uLp_u));
        }
        else{
            parent.set(uLp_v,uLp_u);
            size.set(uLp_u,size.get(uLp_v)+size.get(uLp_u));
        }
    }

}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int extraEdges=0;
        int m=connections.length;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];

            if(ds.findUParent(u)==ds.findUParent(v)){
                extraEdges++;
            }
            else{
                ds.UnionBySize(u,v);
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) count++;
        }

        int ans=count-1;
        if(extraEdges>=ans) return ans;
        return -1;
    }
}
