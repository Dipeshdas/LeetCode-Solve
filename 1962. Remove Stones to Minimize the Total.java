class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
        }
        System.out.println(pq);
        int sum=0;
        for(int e:pq){
            sum+=e;
        }
        System.out.println(sum);
        while(k!=0){
            int a=pq.peek();
            pq.poll();
            int s=a-(a/2);
            pq.add(s);
            sum-=a/2;
            k--;
        }
        

        
        return sum;
    }
}
