class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<k;i++){
            int num=nums[nums.length-1];
            ans+=num;
            nums[nums.length-1]=num+1;
        }
        return ans;
    }
}
