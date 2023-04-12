class Solution {
    public String simplifyPath(String path) {
        Stack<String>st=new Stack<>();
        
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='/') continue;

            String temp="";
            while(i<path.length() && path.charAt(i)!='/'){
                temp+=path.charAt(i);
                i++;
            }

            if(temp.equals(".")) continue;
            else if(temp.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }

            }
            else{
                st.push(temp);
            }
        }
        
        String ans="";
        while(!st.isEmpty()){
            ans="/"+st.pop()+ans;
        }
        if(ans.length()==0) return "/";
        return ans;
    }
}
