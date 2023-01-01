class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String arr[]=s.split(" ");
        Map h=new HashMap<>();
        
        if(arr.length!=pattern.length()){
            return false;
        }
        
        for(Integer i=0;i<pattern.length();i++){
            if(h.put(arr[i],i)!=h.put(pattern.charAt(i),i)){
                return false;
            }
        }
        return true;
    }
}
