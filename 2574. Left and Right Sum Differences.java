class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
            }
            right[i]=sum;
        }
        
        for(int i=n-1;i>=0;i--){
            int sum=0;
            for(int j=i-1;j>=0;j--){
                sum+=nums[j];
            }
            left[i]=sum;
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(left[i]-right[i]);
        }
        return ans;
        
    }
}
