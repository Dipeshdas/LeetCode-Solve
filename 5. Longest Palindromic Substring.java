class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][]=new boolean[s.length()][s.length()];


        String ans="";
        int maxLength=0;
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=false;
                    }
                }

                if(dp[i][j]){
                    if(j-i+1>maxLength){
                        maxLength=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}
