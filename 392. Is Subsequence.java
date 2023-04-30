class Solution {

    public boolean f(String s,int idx,String t){
        int j=0;

        while(idx<s.length() && j<t.length()){
            if(s.charAt(idx)==t.charAt(j)){
                idx++;
                j++;
            }
            else{
                j++;
            }
        }
        if(idx==s.length()) return true;
        return false;
    }

    public boolean isSubsequence(String s, String t) {
        return f(s,0,t);
    }
}
