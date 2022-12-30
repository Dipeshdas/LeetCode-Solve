class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;

        int row[]=new int [r];
        Arrays.fill(row,-1);
        int col[]=new int[c];
        Arrays.fill(col,-1);

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    row[i]=0;
                    col[j]=0;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i]==0 || col[j]==0){
                    matrix[i][j]=0;   
                }
            }
        }

        
    }
}
