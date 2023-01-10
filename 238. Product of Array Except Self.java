class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int ans[]=new int[nums.length];
        ans[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            ans[i]=ans[i-1]*nums[i];
        }

        int product=1;
        for(int i=nums.length-1;i>0;i--){
            ans[i]=ans[i-1]*product;
            product*=nums[i];
        }
        ans[0]=product;

        return ans;

    }
}
