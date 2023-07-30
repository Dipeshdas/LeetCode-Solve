class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,k));

        int dist[]=new int[n+1];
        Arrays.fill(dist,(int)(1e9));
        dist[k]=0;
        
        while(!q.isEmpty()){
            Pair pr=q.poll();
            int steps=pr.first;
            int node=pr.second;

            for(int i=0;i<adj.get(node).size();i++){
                int adjNode=adj.get(node).get(i).first;
                int edgeWeight=adj.get(node).get(i).second;

                if(steps+edgeWeight<dist[adjNode]){
                    dist[adjNode]=steps+edgeWeight;
                    q.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dist[i]==(int)(1e9)){
                //System.out.println(i);
                return -1;
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]>max){
                max=dist[i];
            }
        }
        return max;

    }
}

class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
