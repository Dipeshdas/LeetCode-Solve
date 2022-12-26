class Solution {
    public int maxProfit(int[] prices) {

        //T.C-O(N^2)
        // int max=0;
        // for(int i=0;i<prices.length;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         max=Math.max(max,prices[j]-prices[i]);
        //     }
        // }
        // return max;

        //T.C-O(N) && S.C-O(N)

        int a[]=new int[prices.length];
        int max=0;
        for(int i=a.length-1;i>=0;i--){
            max=Math.max(max,prices[i]);
            a[i]=max;
        }
        int ans=0;
        for(int i=0;i<prices.length;i++){
            ans=Math.max(ans,a[i]-prices[i]);
        }
        return ans;



        //T.C-O(N)
        // int minSoFar=prices[0];
        // int maxProfit=0;
        
        // for(int i=1;i<prices.length;i++){
        //     minSoFar=Math.min(minSoFar,prices[i]);
        //     int profit=prices[i]-minSoFar;
        //     maxProfit=Math.max(maxProfit,profit);
        // }
        // return maxProfit;
    }
}
