
class pair{
    int first;
    int second;
    int third;
    pair(int f,int s,int t){
        this.first=f;
        this.second=s;
        this.third=t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int visit[][]=new int[n][m];
        Queue<pair>q=new LinkedList<pair>();

        int freshOrange=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    visit[i][j]=2;
                }
                else{
                    visit[i][j]=0;
                }
                if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

    int ans=0;
    int count=0;
    while(!q.isEmpty()){
        int row=q.peek().first;
        int col=q.peek().second;
        int step=q.peek().third;
        ans=Math.max(ans,step);
        q.remove();
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 && grid[nrow][ncol]==1){
                q.add(new pair(nrow,ncol,step+1));
                visit[nrow][ncol]=2;
                count++;
            }
        }

    }
    if(count==freshOrange){
            return ans;
        }
        return -1;

        
    }
}
