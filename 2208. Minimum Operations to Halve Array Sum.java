class Solution {
    public int halveArray(int[] nums) {
        
        PriorityQueue<Double>pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int e:nums){
            sum+=(double)e;
            pq.add((double)e);
        }

        double reduce=0;
        int count=0;
        while(!pq.isEmpty() && reduce<sum/2){
            double half=pq.poll()/2;
            reduce+=half;
            pq.add(half);
            count++;
        }
        return count;
    }
}
