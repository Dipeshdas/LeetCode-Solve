class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean vis[]=new boolean[arr.length];
        return dfs(arr,start,vis);
        
    }

    public boolean dfs(int[] arr, int start,boolean vis[]){
        if(start<0 || start>=arr.length || vis[start]){
            return false;
        }
         
        if(arr[start]==0) {
            return true;
        }
        vis[start]=true;
        
        return dfs(arr,start+arr[start],vis) || dfs(arr,start-arr[start],vis);
        
    }
}
