class Solution {
    public int equalPairs(int[][] grid) {
        Map<Integer,ArrayList<Integer>>row=new HashMap<>();
        Map<Integer,ArrayList<Integer>>col=new HashMap<>();

        int n=grid.length;

        for(int i=0;i<n;i++){
            row.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            col.put(i,new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                row.get(i).add(grid[i][j]);
                col.get(j).add(grid[i][j]);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(row.get(i).equals(col.get(j))){
                    ans++;
                }
            }
        }

        return ans;
    }
}
