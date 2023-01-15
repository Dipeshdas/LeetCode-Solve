class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        int n=s.length();
        HashMap<Character,Integer>map=new HashMap<>();
        int maxLength=0;
        while(right<n){
            if(map.containsKey(s.charAt(right))){
                left=Math.max(map.get(s.charAt(right))+1,left);
            }

            map.put(s.charAt(right),right);
            maxLength=Math.max(right-left+1,maxLength);
            right++;
            
        }
        return maxLength;
    }
}
