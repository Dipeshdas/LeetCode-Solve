class Solution {
    public int maxSubArray(int[] nums) {
        int maximum=Integer.MIN_VALUE;
        int cur=0;
        for(int i=0;i<nums.length;i++){
            cur+=nums[i];
            if(cur>maximum){
                maximum=cur;
            }
            if(cur<0){
                cur=0;
            }
            
        }
        return maximum;
    }
}
