class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};

        int sub=0;
        for(int i=0;i<n;i++){
            boolean[] flag={true};
            for(int j=0;j<m;j++){
                
                if(grid2[i][j]==1){
                    dfs(i,j,grid1,grid2,flag,delRow,delCol);
                    if(flag[0]) sub++;
                    flag[0]=true;
                }
            }
        }
        return sub;
    }

    public void dfs(int i,int j,int[][] grid1, int[][] grid2,boolean[] flag,int delRow[],int delCol[]){
        
        if(grid1[i][j]==0) {
            flag[0]=false;
            return;
        }

        grid2[i][j]=0;
        int n=grid2.length;
        int m=grid2[0].length;

        for(int k=0;k<4;k++){
            int nrow=i+delRow[k];
            int ncol=j+delCol[k];

            if(nrow<n && ncol<m && nrow>=0 && ncol>=0 && grid2[nrow][ncol]==1){
                dfs(nrow,ncol,grid1,grid2,flag,delRow,delCol);
            }
  

        }
    }
}
