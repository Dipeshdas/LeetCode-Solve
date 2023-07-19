class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int p=1;
        int ans=0;
        for(int i=0,j=0;j<nums.length;j++){
            p=p*nums[j];

            while(p>=k && i<j){
                p/=nums[i];
                i++;
            }

            if(p<k){
                ans+=(j-i+1);
            }
        }
        return ans;
    }
}
