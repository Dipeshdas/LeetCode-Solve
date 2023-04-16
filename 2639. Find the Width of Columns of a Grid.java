class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans[]=new int[n];
        
        for(int j=0;j<n;j++){
            int max=1;
            for(int i=0;i<m;i++){
                int len=find(Math.abs(grid[i][j]));
                if(grid[i][j]<0){
                    len=len+1;
                }
                max=Math.max(max,len);
            }
            ans[j]=max;
        }
        return ans;
    }
    
    public int find(int number){
        int count=0;
        while(number!=0){
            number=number/10;
            count++;
        }
        return count;
    }
}
