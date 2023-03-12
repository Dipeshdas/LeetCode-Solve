import java.util.*;

class Solution {
    public int maxScore(int[] nums) {
        desc(nums);
        int n=nums.length;
        long[]pre=new long[n];
        int maxScore=0;
        pre[0]=nums[0];
        if(pre[0]>0) maxScore++;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
            if(pre[i]>0){
                maxScore++;
            }
        }
        return maxScore;
    }
    
    public void desc(int[]nums){
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n/2;i++){
            int temp=nums[i];
            nums[i]=nums[n-i-1];
            nums[n-1-i]=temp;
        }
    }
}
