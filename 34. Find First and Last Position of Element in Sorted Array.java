class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int ans[]=new int[2];
        ans[0]=searchFirst(nums,target);
        ans[1]=searchLast(nums,target);
        return ans;
    }

    public int searchFirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int res=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            
            if(nums[mid]==target){
                res=mid;
                high=mid-1;
            }
            
            else if(target>nums[mid]){             
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }

    public int searchLast(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int res=-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            
            if(nums[mid]==target){
                res=mid;
                low=mid+1;
            }
            
            else if(target>nums[mid]){             
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }
}
