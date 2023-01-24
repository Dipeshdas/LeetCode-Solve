class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer>q=new LinkedList<>();
        int n=rooms.size();
        boolean temp[]=new boolean[n];
        Arrays.fill(temp,false);

        for(int i=0;i<rooms.get(0).size();i++){
            q.add(rooms.get(0).get(i));
        }

        temp[0]=true;

        while(!q.isEmpty()){
            int x=q.peek();
            if(!temp[x]){
                int N=rooms.get(x).size();
                for(int i=0;i<N;i++){
                    if(!temp[rooms.get(x).get(i)]){
                        q.add(rooms.get(x).get(i));
                    }
                }
                temp[x]=true;
            }
            q.poll();
        }

        for(int i=0;i<temp.length;i++){
            if(temp[i]==false) return false;
        }
        return true;
    }
}
