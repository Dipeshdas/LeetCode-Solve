class Solution {
    public int minOperations(int n) {
        int ans=0;
        for(int i=0;i<n/2;i++){
            int x=(2 * i) + 1;
            ans+=n-x;
        }
        return ans;
    }
}
