class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int ans=0;
        int sum=0;
        for(int e:costs){
            ans++;
            sum+=e;
            if(sum==coins){
                return ans;
            }
            if(sum>coins) return ans-1;   
        }
        return ans;
    }
}
