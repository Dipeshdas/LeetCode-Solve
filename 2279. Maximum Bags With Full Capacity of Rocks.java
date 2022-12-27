class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=rocks.length;
        for(int i=0;i<n;i++){
            capacity[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(capacity);
        int count=0;
        for(int i=0;i<n;i++){
            if(capacity[i]==0) count++;
            else if(additionalRocks>=capacity[i]){
                count++;
                additionalRocks-=capacity[i];
            }
            else{
                break;
            }
        }
        return count;
    }
}
