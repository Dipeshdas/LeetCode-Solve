class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i=0;
        int j=0;
        int ans=0;
        int max=0;
        while(j<s.length()){
            ans+=Math.abs((int)s.charAt(j)-(int)t.charAt(j));
            if(ans<=maxCost){
                max=Math.max(max,j-i+1);
            }
             
            else {
                while(ans>maxCost){
                    ans-=Math.abs((int)s.charAt(i)-(int)t.charAt(i));
                    i++;
                }
            }
            j++;

        }
        return max;
    }
}
