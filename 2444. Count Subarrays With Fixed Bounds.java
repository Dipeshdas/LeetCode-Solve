class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0;
        int start=0,minstart=0,maxstart=0;
        boolean isMin=false,isMax=false;

        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(num<minK || num>maxK){
                isMin=false;
                isMax=false;
                start=i+1;
            }
            if(num==minK){
                isMin=true;
                minstart=i;
            }
            if(num==maxK){
                isMax=true;
                maxstart=i;
            }
            if(isMin==true && isMax==true){
                res+=Math.min(minstart,maxstart)-start+1;
            }
        }
        return res;
    }
}
