class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                ans.add(mat[i][j]);
            }
        }
        int a[][]=new int[r][c];
        int k=0;
        if(ans.size()==r*c){
            for(int i=0;i<r;i++){
                for(int j=0;j<c && k<ans.size();j++){
                    a[i][j]=ans.get(k++);
                }
            }
            return a;
        }

        return mat;
    }
}
