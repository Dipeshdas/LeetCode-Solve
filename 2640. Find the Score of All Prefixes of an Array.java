class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];
        long max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            max=Math.max(max>nums[i]?max:nums[i],max);
            ans[i]=nums[i]+max;
        }
        
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=ans[i];
            ans[i]=sum;
        }
        
        return ans;
        
        
        //TLE-------------
//         int n=nums.length;
//         long conver[]=new long[n];
        
//         for(int i=0;i<nums.length;i++){
//             conver[i] = nums[i];
//             long max=0;
//             for(int j=0;j<=i;j++){
//                 if(nums[j]>max){
//                     max=nums[j];
//                 }
                
//             }
//             conver[i]=conver[i]+max;
//         }
        
//         for(int i=1;i<n;i++){
//             conver[i]=conver[i]+conver[i-1];
//         }
//         return conver;
        
    }
    
}
