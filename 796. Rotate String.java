class Solution {
    public boolean rotateString(String s, String goal) {
        String a=s+s;
        if(s.length()==goal.length() && a.contains(goal)){
            return true;
        }
        return false;
    }
}
