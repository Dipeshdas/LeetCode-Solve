class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int prefixSum[]=new int [nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){

            int qr=queries[i];
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(prefixSum[j]<=qr){
                    count++;
                }
                else{
                    break;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}
