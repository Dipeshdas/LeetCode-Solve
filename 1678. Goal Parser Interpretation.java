
class Solution {
    public String interpret(String command) {
        String ans=command.replace("()","o");
        return ans.replace("(al)","al");
    }
}
