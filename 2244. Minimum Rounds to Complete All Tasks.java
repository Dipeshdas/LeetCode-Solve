class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer>map=new TreeMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        for(int e:tasks){
            if(map.get(e)<2){
                return -1;
            }
        }

        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int x=entry.getValue();
            int count=0;
            while(x!=0){
               count++;
               x--;
               if(x==0 || count>=3){
                   ans++;
                   count=0;
               }
            }
        }

        return ans;

    }
}
