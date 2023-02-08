
class Pair{
    int first;
    int second;
    int third;
    
    Pair(int fst,int scnd,int thrd){
        this.first=fst;
        this.second=scnd;
        this.third=thrd;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        
        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};
        
        dist[0][0]=0;
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0,0));
        
        while(!pq.isEmpty()){
            int diff=pq.peek().first;
            int row=pq.peek().second;
            int col=pq.peek().third;
            pq.poll();

            if(row==n-1 && col==m-1) return diff;
            
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];

                
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort=Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]),diff);
                    
                    if(newEffort<dist[nrow][ncol]){
                        pq.add(new Pair(newEffort,nrow,ncol));
                        dist[nrow][ncol]=newEffort;
                    }
                }
            }
        }
        return -1;
    }
}
