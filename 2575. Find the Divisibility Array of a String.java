

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n=word.length();
        int ans[]=new int[n];
        long s=0;
        for(int i=0;i<n;i++){
            s=(s*10+(word.charAt(i)-'0'))%m;
            if(s==0){
                ans[i]=1;
            }
            
        }
        return ans;
    }
}
