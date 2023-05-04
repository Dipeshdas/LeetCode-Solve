class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int zeroCount=0;
        int max=Integer.MIN_VALUE;
        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
                
            } 
            
            while(zeroCount>k && i<=j){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
