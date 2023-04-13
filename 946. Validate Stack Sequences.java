class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer>st=new Stack<>();
        int i=0,j=0;
        while(i<pushed.length && j<popped.length){
            st.push(pushed[i]);
            if(pushed[i]==popped[j] ){
                while(!st.isEmpty() && st.peek()==popped[j]){
                    st.pop();
                    j++;
                }    
            }
            i++;
        }
        return st.isEmpty();
    }
}
