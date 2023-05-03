class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int ans=0;
        Map<Character,Integer>map=new HashMap<>();
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            // System.out.println(map);
            if(!map.containsKey('a') || !map.containsKey('b') || !map.containsKey('c')){
                j++;
            } 
            
            else{
                while(map.containsKey('a') && map.containsKey('b') && map.containsKey('c')){
                    ans+=n-j;
                    char ch=s.charAt(i);
                    map.put(ch,map.getOrDefault(ch,0)-1);
                    if(map.get(ch)==0){
                        map.remove(ch);
                    }
                    i++;
                }
                j++;
            } 

        }
        return ans;
    }
}
