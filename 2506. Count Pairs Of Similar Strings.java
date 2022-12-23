class Solution {
    public int similarPairs(String[] words) { 
        int count=0;

        for(int i=0;i<words.length-1;i++){
            for(int l=i+1;l<words.length;l++){
                HashSet<Character>h=new HashSet<>();
                HashSet<Character>h1=new HashSet<>();
                for(int j=0;j<words[i].length();j++){
                    h.add(words[i].charAt(j));
                }
                for(int k=0;k<words[l].length();k++){
                    h1.add(words[l].charAt(k));
                }
                boolean m=false;
                for(char e:h){
                    if(!h1.contains(e)){
                        m=true;
                        break;
                    }
                }
                for(char e:h1){
                    if(!h.contains(e)){
                        m=true;
                        break;
                    }
                }
                if(!m){
                    count++;
                }
            }
        }
        return count;
        
    }
}
