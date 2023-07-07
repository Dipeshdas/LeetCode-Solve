class Solution {
    public String replaceDigits(String s) {
        char ch[]=s.toCharArray();
        for(int i=1;i<ch.length;i++){
            if(i%2!=0){
                char c=shift(ch[i-1],ch[i]-'0');
                ch[i]=c;
            }
        }
        String ans="";
        for(int i=0;i<ch.length;i++){
            ans+=ch[i];
        }
        return ans;
    }

    public char shift(char ch,int num){
        for(int i=1;i<=num;i++){
            ch++;
        }
        return ch;
    }
}
