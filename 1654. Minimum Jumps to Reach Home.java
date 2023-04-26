class Pair{
    int pos;
    boolean isBackward;
    Pair(int pos,boolean isBackward){
        this.pos=pos;
        this.isBackward=isBackward;
    }
}



class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer>visited=new HashSet<>();
        for(int e:forbidden){
            visited.add(e);
        }

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,false));
        visited.add(0);

        int limit=6000;// given in constarints (2000+2000+2000)
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int pos=q.peek().pos;
                boolean isBackward=q.peek().isBackward;
                q.poll();

                if(pos==x) return level;

                if(!isBackward){

                    int nextBackPos=pos-b;
                    if(nextBackPos>0 && !visited.contains(nextBackPos)){
                        visited.add(nextBackPos);
                        q.add(new Pair(nextBackPos,true));
                    }
                    
                }
                int nextForPos=pos+a;
                if(nextForPos<limit && !visited.contains(nextForPos)){
                    visited.add(nextForPos);
                    q.add(new Pair(nextForPos,false));
                }   
            }
            level++;
        }
        return -1;
    }
}
