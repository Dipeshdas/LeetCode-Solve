class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer>set=new HashSet<>();
        for(int e:arr){
            set.add(e);
        }
        
        int misCount=0;
        for(int i=1;i<=Integer.MAX_VALUE;i++){
            if(!set.contains(i)){
                misCount++;
            }
            if(misCount==k){
                return i;
            }
        }
        return 0;
        
        
    }
}
