class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));

        int start=intervals[0][0];
        int end=intervals[0][1];

        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                count++;
            }
            else{
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        return count;

    }
}
