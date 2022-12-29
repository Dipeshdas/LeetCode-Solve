class Solution {
    public int firstUniqChar(String s) {
        //T.C-->O(N) & S.C--O(N)
        // HashMap<Character,Integer>map=new LinkedHashMap<>();
        // for(int i=0;i<s.length();i++){
        //     map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        // }
        // for(int i=0;i<s.length();i++){
        //     if(map.get(s.charAt(i))==1){
        //         return i;
        //     }
        // }
        // return -1;

        //T.C-->O(N^2) & S.C--O(1)
        for(int i=0;i<s.length();i++){
            boolean flag=false;
            for(int j=0;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && i!=j){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                return i;
            }
        }
        return -1;
    }
}
