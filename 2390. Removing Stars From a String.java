class Solution {
    public String removeStars(String s) {

        //first approach

        // int n=s.length();
        // char ar[]=s.toCharArray();
        // int i=0;
        // int j=0;
        // while(j<n){
        //     if(ar[j]=='*'){
        //         i--;
        //     }
        //     else{
        //         ar[i++]=ar[j];
        //     }
        //     j++;
        // }

        // String ans="";
        // for(int k=0;k<i;k++){
        //     ans+=ar[k];
        // }  

        // return ans;

        //second approach
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }

        String ans="";
        for(char e:st){
            ans+=e;
        }
        return ans;
    }

    
}
