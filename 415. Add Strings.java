import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        ArrayList<Character>ans=new ArrayList<>();
        while(i>=0 || j>=0){
            if(i<0){
                ans.add((char)(((num2.charAt(j)-48+carry)%10)+48));
                carry=(num2.charAt(j)-48+carry)/10;
                j--;
            }
            else if(j<0){
                ans.add((char)(((num1.charAt(i)-48+carry)%10)+48));
                carry=(num1.charAt(i)-48+carry)/10;
                i--;
            }
            else{
                ans.add((char)((((num1.charAt(i)-48)+(num2.charAt(j)-48)+carry)%10)+48));
                carry=((num1.charAt(i)-48)+(num2.charAt(j)-48)+carry)/10;
                i--;
                j--;
            }
        }
        
        if(carry!=0){
            ans.add((char)(carry+48));
        }

        String res="";
        for(int k=ans.size()-1;k>=0;k--){
            res+=ans.get(k);
        }
        return res;
    }
}
