class Pair{
    String first;
    int second;

    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }

        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.poll();

            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char original[]=word.toCharArray();
                    original[i]=ch;
                    String newWord=new String(original);

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
