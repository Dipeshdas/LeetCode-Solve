
class DisJointSet{
    int size[];
    int parent[];

    DisJointSet(int n){
        size=new int[n+1];
        parent=new int[n+1];

        for(int i=1;i<=n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }

    int findUltimateParent(int node){
        if(node==parent[node]){
            return node;

        }

        return parent[node]=findUltimateParent(parent[node]);
    }

    void unionBySize(int u,int v){
        int ulp_u=findUltimateParent(u);
        int ulp_v=findUltimateParent(v);

        if(ulp_u==ulp_v) return;

        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_v]=ulp_u;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_u]=ulp_v;
            size[ulp_u]+=size[ulp_v];
        }
    }


}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisJointSet ds=new DisJointSet(edges.length);
        
        int ans[]=new int[2];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            if(ds.findUltimateParent(u)==ds.findUltimateParent(v)){
                ans[0]=u;
                ans[1]=v;           
            }
            else{
                ds.unionBySize(u,v);
            }

        }
        return ans;
    }
}
