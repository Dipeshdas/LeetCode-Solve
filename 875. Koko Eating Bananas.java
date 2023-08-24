class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int e:piles){
            high=Math.max(high,e);
        }
        
        while(low<=high){

            int mid=(low+high)/2;
            int totalTime=0;
            for(int k=0;k<piles.length;k++){
                totalTime+=Math.ceil((double)(piles[k]) /(double)(mid));
            }

            if(totalTime<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
}
