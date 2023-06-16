class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int one=0;
        int zero=0;

        int n=grid.length;
        int m=grid[0].length;

        int col[]=new int[m];
        int row[]=new int[n];

        int ans[][]=new int[n][m];

        for(int i=0;i<n;i++){
            one=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    one++;
                }
            }
            row[i]=one;
        }
        for(int i=0;i<m;i++){
            one=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    one++;
                }
            }
            col[i]=one;
        }

        for(int i=0;i<n;i++){
            one =0;
            zero=0;

            for(int j=0;j<m;j++){
                one=row[i]+col[j];
                zero=(n-row[i])+(m-col[j]);
                ans[i][j]=one-zero;
            }
            
        }
            
        return ans;
    }
}
