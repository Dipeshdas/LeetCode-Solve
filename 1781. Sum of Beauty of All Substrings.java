class Solution {
    public int beautySum(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            int fr[]=new int[26];
            for(int j=i;j<s.length();j++){
                fr[s.charAt(j)-'a']++;//suppose char is 'b' then freq['b'-'a']++ means freq[1]++ then 'c'-'a'=2 and going on.
                res+=solve(fr);
            }
        }
        return res;
    }

    public int solve(int frq[]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<frq.length;i++){
            if(frq[i]==0){
                continue;
            }

            min=Math.min(min,frq[i]);
            max=Math.max(max,frq[i]);
        }
        return max-min;
    }
}
