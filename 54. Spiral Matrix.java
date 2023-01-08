class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>ans=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;

        int l=0,r=m-1; //col
        int t=0,b=n-1;//row

        int num=1;
        int dir=0; //direction

        while(l<=r && t<=b){
            if(dir==0){
                for(int i=l;i<=r;i++){
                    ans.add(matrix[t][i]);
                }
                dir=1;
                t++; 
            }
            else if(dir==1){
                for(int i=t;i<=b;i++){
                    ans.add(matrix[i][r]);
                }
                dir=2;
                r--; 
            }
            else if(dir==2){
                for(int i=r;i>=l;i--){
                    ans.add(matrix[b][i]);
                }
                dir=3;
                b--;
            }
            else if(dir==3){
                for(int i=b;i>=t;i--){
                    ans.add(matrix[i][l]);
                }
                dir=0;
                l++;
            }
        }
        return ans;
    }
}
