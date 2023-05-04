class Solution {
    public int maxVowels(String s, int k) {
        Set<Character>set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int i=0;
        int j=0;
        int ans=0;
        int max=Integer.MIN_VALUE;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                    ans++;
            }
            if(j-i+1<k){
                
                j++;
            }
            else if(j-i+1==k){
                max=Math.max(max,ans);
                if(set.contains(s.charAt(i))){
                    ans--;
                }
                i++;
                j++;
            }
        }
        return max;

    }
}
