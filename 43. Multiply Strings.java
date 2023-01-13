import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) return "0";

        int l1=num1.length();
        int l2=num2.length();

        int a[]=new int[l1+l2];

        int i=l2-1;
        int pf=0;

        while(i>=0){
            int ival=num2.charAt(i)-'0';
            i--;

            int j=l1-1;
            int k=a.length-1-pf; 
            int carry=0;

            while(carry!=0 || j>=0){
                int jval=j>=0 ? num1.charAt(j)-'0':0; // this is for j val is out of range but we have carry reamaining.
                j--;

                int product=ival*jval+carry+a[k];
                
                a[k]=product%10;
                carry=product/10;

                k--;    

            }
            pf++;
        }

        //for removing leading zero
        String ans="";
        boolean flag=false;

        for(int e:a){
            if(e==0 && flag==false){
                continue;
            }
            else{
                flag=true;
                ans+=e;
            }
        }

        return ans;
    }
}
