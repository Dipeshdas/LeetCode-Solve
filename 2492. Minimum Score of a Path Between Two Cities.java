class Pair{
    int first;
    int second;
     Pair(int first,int second){
         this.first=first;
         this.second=second;
     }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        Queue<Pair>q=new LinkedList<>();
        boolean vis[]=new boolean[n+1];
        q.add(new Pair(1,Integer.MAX_VALUE));
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p=q.poll();
            vis[p.first]=true;
            ans=Math.min(ans,p.second);
            for(Pair adjNode:adj.get(p.first)){
                if(!vis[adjNode.first]){
                    q.add(adjNode);
                }
            }
        }
        return ans;
        
    }
}
