class Solution {
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            boolean swapped=false;
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j+1]<nums[j]){
                    swapped=true;
                    swap(nums,j+1,j);
                }
            }
            if(!swapped){
                break;
            }
        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
