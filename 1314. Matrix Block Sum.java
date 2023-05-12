class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                int rowS=i-k;
                int rowE=i+k;
                int colS=j-k;
                int colE=j+k;

                if(rowS<0){
                    rowS=0;
                }
                if(rowE>=n){
                    rowE=n-1;
                }

                if(colS<0){
                    colS=0;
                }
                if(colE>=m){
                    colE=m-1;
                }

                ans[i][j]=sum(rowS,rowE,colS,colE,mat);
            }
        }
        return ans;
    }

    public int sum(int rowS,int rowE,int colS,int colE,int[][] mat){
        int sum=0;

        for(int i=rowS;i<=rowE;i++){
            for(int j=colS;j<=colE;j++){
                sum+=mat[i][j];
            }
        }
        return sum;
    }
}
