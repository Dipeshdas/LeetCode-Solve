class Solution {
    HashMap<Character,Integer>map=new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }

        for(int i=0;i<words.length-1;i++){
            if(!check(words[i],words[i+1])) return false;
        }
        return true;
    }

    public boolean check(String s1,String s2){
        int m=s1.length();
        int n=s2.length();

        int min=Math.min(m,n);

        for(int i=0;i<min;i++){
            if(map.get(s1.charAt(i))<map.get(s2.charAt(i))) return true;
            else if(map.get(s1.charAt(i))>map.get(s2.charAt(i))) return false;
        }
        if(n>=m) return true;
        return false;
    }
}
