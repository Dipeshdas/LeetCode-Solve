class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character>h=new HashSet<>();
        int len=0;
        for(char e:s.toCharArray()){
            if(h.contains(e)){
                len+=2;
                h.remove(e);
            }
            else{
                h.add(e);
            }
        }

        if(h.size()>0){
            return len+1;
        }
        return len;
        
    }
}
