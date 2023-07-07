

// class Solution {
//     public int maximumNumberOfStringPairs(String[] words) {
//         int count=0;
//         for(int i=0;i<words.length;i++){
//             for(int j=i+1;j<words.length;j++){
//                 if(words[i].charAt(0)==words[j].charAt(1) && words[i].charAt(1)==words[j].charAt(0)){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }


//Another Solution
class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String>set=new HashSet<>();
        for(String s:words){
            set.add(s);
        }
        //System.out.println(set);

        int count=0;
        for(int i=0;i<words.length;i++){
            String rev=reverse(words[i]);
            set.remove(words[i]);
            if(set.contains(rev)){
                count++;
                set.remove(rev);
                
            }
        }
        return count;


    }

    public String reverse(String temp){
        char ch[]=temp.toCharArray();
        char cur=ch[0];
        ch[0]=ch[1];
        ch[1]=cur;
        String ans="";
        for(int i=0;i<ch.length;i++){
            ans+=ch[i];
        }

        return ans;
    }
}




