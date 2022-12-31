class Solution {
    int ans=0;
    public void solve(int[][] grid,int i,int j,int count){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }

        if(grid[i][j]==-1 || grid[i][j]==3){
            return;
        }

        if(grid[i][j]==2 && count==0){
            ans+=1;
            System.out.println(ans);
            return;
        }

        if(grid[i][j]==2){
            return;
        }

        grid[i][j]=3;//it means we have visited the i,j position and marked as 3
        
        solve(grid,i,j+1,count-1);//right-move
        solve(grid,i+1,j,count-1);//down-move
        solve(grid,i-1,j,count-1);//up-move
        solve(grid,i,j-1,count-1);//left-move
        grid[i][j]=0;
        

    }
    
    public int uniquePathsIII(int[][] grid) {
        int x=0,y=0,count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    x=i;
                    y=j;
                }
                if(grid[i][j]==0){
                    count++;
                }
            }
        }
       solve(grid,x,y,count+1);
       return ans;
    }
}
