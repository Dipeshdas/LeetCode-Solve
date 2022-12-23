class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c=words[i].charAt(j);
                if(!allowed.contains(String.valueOf(c))){
                    count++;
                    break;
                }
            }
        }
        return words.length-count;
    }
}
