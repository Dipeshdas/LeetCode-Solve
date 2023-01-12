class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String arr[]=s.split(" ");
        Map<Character,String> map=new HashMap<>();
        Set<String>h=new HashSet<>();
        
        if(arr.length!=pattern.length()){
            return false;
        }
        
        boolean flag=false;
        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i)) && !h.contains(arr[i])){
                map.put(pattern.charAt(i),arr[i]);
                h.add(arr[i]);
            }
            if(map.containsKey(pattern.charAt(i)) && map.get(pattern.charAt(i)).equals(arr[i])){
                flag=true;
            }
            else{
                return false;
            }

        }
        return flag;
    }
}
