class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                dist[u][v]=wt;
                dist[v][u]=wt;
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]==Integer.MAX_VALUE || dist[via][j]==Integer.MAX_VALUE)
                        continue;      
                    dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                }
            }
        }

        int cntcity=n;
        int cityNo=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntcity){
                cntcity=cnt;
                cityNo=i;
            }
        }
        return cityNo;



    }
}
