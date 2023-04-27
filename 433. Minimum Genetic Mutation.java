
class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            set.add(bank[i]);
        }

        char seq[]={'A', 'C', 'G','T'};

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(start,0));
        set.remove(start);

        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.poll();

            if(word.equals(end)) return steps;

            for(int i=0;i<word.length();i++){
                for(int k=0;k<4;k++){
                    char ans[]=word.toCharArray();
                    ans[i]=seq[k];
                    String newWord=new String(ans);

                    if(set.contains(newWord)){
                        q.add(new Pair(newWord,steps+1));
                        set.remove(newWord);
                    }
                }  

            }
        }
        return -1;
    }
}
