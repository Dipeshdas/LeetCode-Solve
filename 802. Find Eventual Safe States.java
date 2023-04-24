class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int visit[]=new int[n];
        int pathVisit[]=new int[n];
        int check[]=new int[n];
        

        for(int i=0;i<n;i++){
            if(visit[i]==0){
                dfs(i,visit,pathVisit,check,graph);
            }
        }

        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) ans.add(i);
        }
        return ans;

    }

    public boolean dfs(int i,int visit[],int pathVisit[],int check[],int[][] graph){
        visit[i]=1;
        pathVisit[i]=1;
        check[i]=0;

        for(int e:graph[i]){
            if(visit[e]==0){
                if(dfs(e,visit,pathVisit,check,graph)){
                    return true;
                }
            }
            else if(pathVisit[e]==1) return true;
        }
        check[i]=1;
        pathVisit[i]=0;
        return false;
    }
    
    //TOPOLOGICAL SORT
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adjRev=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        int indegree[]=new int[n];

        for(int i=0;i<n;i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjRev.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);

            for(int e:adjRev.get(node)){
                indegree[e]--;
                if(indegree[e]==0) q.add(e);
            }
        }
        
        Collections.sort(ans);
        return ans;

    }
}
