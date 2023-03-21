class Solution {
    public long zeroFilledSubarray(int[] nums) {

        // 1st qpproach
        // long count=0;
        // long ans=0;
        // for(int e:nums){
        //     if(e!=0){
        //         ans+=(count*(count+1))/2;
        //         count=0;
                
        //     }
        //     else{
        //         count++;
        //     }
        // }
        // ans+=(count*(count+1))/2;
        // return ans;

        //2nd approach
        long count=0;
        long ans=0;
        for(int e:nums){
            if(e!=0){
                count=0;
            }
            else{
                count++;
            }
            ans+=count;
        }
        return ans;
    }
}
