class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>res=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));

        if(intervals.length==0 || intervals==null){
            return res.toArray(new int[0][0]);
        }

        int start=intervals[0][0];
        int last=intervals[0][1];
        for(int[] e:intervals){
            if(e[0]<=last){
                last=Math.max(last,e[1]);
            }
            else{
                res.add(new int[]{start,last});
                start=e[0];
                last=e[1];
            }
        }
        res.add(new int[]{start,last});
        return res.toArray(new int[0][0]);
    }
}
