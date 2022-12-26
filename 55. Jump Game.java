class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int maxInd=0;
        for(int i=0;i<nums.length-1 && maxInd>=i;i++){
            maxInd=Math.max(maxInd,i+nums[i]);
            if(maxInd>=nums.length-1){
                return true;
            }

        }
        return false;
    }
}
