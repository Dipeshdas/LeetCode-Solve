class Solution {
    public String reversePrefix(String word, char ch) {
        String ans="";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                ans=rev(i,word);
                break;
            }
        }
        if(ans==""){
            return word;
        }
        return ans;
    }

    public String rev(int end,String str){
        char ch[]=str.toCharArray();
        int len=(end+1)/2;
        
        for(int i=0,j=end;i<len;i++,j--){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            
        }
        
        String ans=new String(ch);
        return ans;
        
    }
}

// class Solution {
//     public String reversePrefix(String word, char ch) {
//         String ans="";
//         for(int i=0;i<word.length();i++){
//             if(word.charAt(i)==ch){
//                 ans=rev(i,word);
//                 break;
//             }
//         }
//         if(ans==""){
//             return word;
//         }
//         return ans;
//     }

//     public String rev(int start,String str){
//         String ans="";
//         for(int i=start;i>=0;i--){
//             ans+=str.charAt(i);
//         }
//         for(int i=start+1;i<str.length();i++){
//             ans+=str.charAt(i);
//         }
//         return ans;
//     }
// }
