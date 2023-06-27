class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[h]){
                l=mid+1;
            }
            else{
                h=mid;
            }
        }
        return nums[h];

    }
}
