class Solution {
    int startRow;
    int startCol;
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};
        int visit[][]=new int[n][m];
   
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(visit[i][j]==0){
                    
                    max=Math.max(max,dfs(i,j,matrix,visit,n,m,delRow,delCol));
                    
                }
            }
        }
        return max;
    }

    public int dfs(int row,int col,int [][]matrix,int [][]visit,int n,int m,int[]delRow,int[]delCol){     
        if(visit[row][col]>0){
            return visit[row][col];
        }
        //System.out.println(row+","+col);
        int ans=1;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];

            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
                continue;
            }

            if (matrix[nrow][ncol] <= matrix[row][col]) {
                continue;
            }

            ans=Math.max(ans,dfs(nrow,ncol,matrix,visit,n,m,delRow,delCol)+1);
        }
        visit[row][col]=ans;
        return ans;
    }
}
