class Solution {
    public int countAsterisks(String s) {
        int count=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                count++;
            }
            if(count%2==0 && s.charAt(i)=='*'){
                ans++;
            }
        }
        return ans;
    }
}
