class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>prev=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>r=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    r.add(1);
                }
                else{
                    r.add(prev.get(j-1)+prev.get(j));
                }
            }
            prev=r;
            ans.add(r);

        }
        return ans;
        
    }
}
