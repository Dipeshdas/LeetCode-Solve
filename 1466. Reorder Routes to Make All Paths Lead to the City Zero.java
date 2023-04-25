class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(-connections[i][0]);
        }

        int visit[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        visit[0]=1;
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int e:adj.get(Math.abs(node))){
                if(visit[Math.abs(e)]==0){
                    visit[Math.abs(e)]=1;
                    q.add(e);
                    if(e>0) count++;
                }
            }
        }
        return count;
    }
}
