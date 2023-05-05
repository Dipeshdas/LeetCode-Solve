class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int zeroCount=0;
        int max=0;
        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
            }

            if(zeroCount>1){
                while(zeroCount>1){
                    if(nums[i]==0){
                        zeroCount--;
                    }
                    i++;
                }
            }

            else{
                max=Math.max(max,j-i);
            }
            j++;
        }
        return max;
    }
}
