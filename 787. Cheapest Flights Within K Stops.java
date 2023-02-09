class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        int cost[]=new int[n];
        for(int i=0;i<n;i++){
            cost[i]=(int)1e9;
        }

        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()){
            int steps=q.peek().first;
            int node=q.peek().second;
            int val=q.peek().third;
            q.poll();
            if(steps>k) continue;
            for(Pair e:adj.get(node)){
                int adjNode=e.first;
                int edw=e.second;

                if(edw+val<cost[adjNode] && steps<=k){
                    q.add(new Tuple(steps+1,adjNode,edw+val));
                    cost[adjNode]=edw+val;
                }
            }
        }
        if(cost[dst]==1e9) return -1;
        return cost[dst];
    }
}
