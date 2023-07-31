class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination) return true;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int visit[]=new int[n];
        return dfs(source,destination,adj,visit);
        
    }

    public static boolean dfs(int source, int destination,ArrayList<ArrayList<Integer>>adj,
    int visit[]){
        visit[source]=1;

        for(int e:adj.get(source)){
            if(visit[e]==0){
                visit[e]=1;
                if(e==destination) return true;
                if(dfs(e,destination,adj,visit)) return true;
                
            }
        }
        return false;
    }
}
