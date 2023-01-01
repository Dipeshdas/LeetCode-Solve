class Solution {
    public boolean isMatching(char a,char b){
        return (a==')' && b=='(') ||
            (a==']' && b=='[')||
            (a=='}' && b=='{');
            
    }
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='[' ||ch=='{'){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else if(!isMatching(ch,st.peek())){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
