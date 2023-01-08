class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][]=new int[n][n];

        int l=0,r=n-1; //col
        int t=0,b=n-1;//row

        int num=1;
        int dir=0; //direction

        while(l<=r && t<=b){
            if(dir==0){
                for(int i=l;i<=r;i++){
                    ans[t][i]=num;
                    num++;
                }
                dir=1;
                t++; // increased row
            }
            else if(dir==1){
                for(int i=t;i<=b;i++){
                    ans[i][r]=num;
                    num++;
                }
                dir=2;
                r--;
            }
            else if(dir==2){
                for(int i=r;i>=l;i--){
                    ans[b][i]=num;
                    num++;
                }
                dir=3;
                b--;
            }
            else if(dir==3){
                for(int i=b;i>=t;i--){
                    ans[i][l]=num;
                    num++;
                }
                dir=0;
                l++;
            }
        }
        return ans;
    }
}
