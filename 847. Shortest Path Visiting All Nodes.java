class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int shortestPathLength(int[][] graph) {
        int finalPath=(1<<graph.length)-1;//n=4 means 2^n-1 = 1111 in binary 
        Queue<Pair>q=new LinkedList<>();
        int visit[][]=new int[graph.length][finalPath+1];

        for(int i=0;i<graph.length;i++){
            q.add(new Pair(i,1<<i));// adding pair like (0,1<<i means 2^i = 1 = 0001 where i=0)
        }
        int ans=0;

        while(!q.isEmpty()){
            int size=q.size();
            ans++;
            while(size-->0){
                int node=q.peek().first;
                int nodeMask=q.peek().second;
                q.poll();

                for(int neighbors:graph[node]){
                    int newMask = nodeMask | (1<<neighbors);
                    if(visit[neighbors][newMask]==1){
                        continue;
                    }

                    if(newMask==finalPath) return ans;

                    visit[neighbors][newMask]=1;
                    q.add(new Pair(neighbors,newMask));
                }
            }
        }
        return 0;
    }
}
