class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<dislikes.length;i++){
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        int color[]=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(bfs(i,adj,color)==false) return false;
            }
        }
        return true;
  
    }

    public boolean bfs(int i,ArrayList<ArrayList<Integer>>adj,int color[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=1;

        while(!q.isEmpty()){
            int node=q.poll();

            for(int e:adj.get(node)){
                if(color[e]==-1){
                    color[e]=1-color[node];
                    q.add(e);
                }

                else if(color[e]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
