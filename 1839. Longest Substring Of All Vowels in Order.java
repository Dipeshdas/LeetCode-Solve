class Solution {
    public int longestBeautifulSubstring(String word) {
        int len=1;
        int count=1;
        int maxLen=0;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i-1)<=word.charAt(i)){
                if(word.charAt(i-1)!=word.charAt(i)){
                    count++;
                }
                len++;
                if(count==5){
                    maxLen=Math.max(maxLen,len);
                }
            }
            else{
                len=1;
                count=1;
            }
        }

        return maxLen;
    }
}
