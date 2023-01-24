class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer>ans=new ArrayList<>();
        int temp[]=new int[n];
        Arrays.fill(temp,0);
        for(List<Integer>l:edges){
            temp[l.get(1)]+=1;
        }

        for(int i=0;i<n;i++){
            if(temp[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}
