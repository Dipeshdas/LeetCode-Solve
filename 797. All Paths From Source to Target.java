class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        dfs(0,graph,ans,temp);
        return ans;
    }

    public void dfs(int sr,int[][]graph,List<List<Integer>>ans,List<Integer>temp){
        temp.add(sr);
        if(sr==graph.length-1){
            ArrayList<Integer>cur=new ArrayList<>();
            cur.addAll(temp);
            ans.add(cur);
            return;
        }

        int child[]=graph[sr];
        for(int e:child){
            dfs(e,graph,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}
