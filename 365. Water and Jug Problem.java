class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;

        int direction[]={jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity};
        Set<Integer>visit=new HashSet<>();
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        visit.add(0);

        while(!q.isEmpty()){
            int cur=q.poll();

            for(int e:direction){
                int total=cur+e;
                if(total==targetCapacity){
                    return true;
                }

                if(total<0 || total>jug1Capacity+jug2Capacity || visit.contains(total)){
                    continue;
                }

                visit.add(total);
                q.add(total);
            }
        }
        return false;
    }
}
