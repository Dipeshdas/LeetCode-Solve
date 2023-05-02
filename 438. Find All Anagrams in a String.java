class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer>map2=new TreeMap<>();
        Map<Character,Integer>temp=new TreeMap<>();
        List<Integer>ans=new ArrayList<>();

        for(int i=0;i<p.length();i++){
            map2.put(p.charAt(i),map2.getOrDefault(p.charAt(i),0)+1);
        }

        int i=0;
        int j=0;

        while(j<s.length()){
            temp.put(s.charAt(j),temp.getOrDefault(s.charAt(j),0)+1);
            if(j-i+1<p.length()){   
                j++;
            }

            else if(j-i+1==p.length()){
                //System.out.println(temp);
                if(temp.equals(map2)){
                    ans.add(i);
                }
                temp.put(s.charAt(i),temp.getOrDefault(s.charAt(i),0)-1);
                if(temp.get(s.charAt(i))==0){
                    temp.remove(s.charAt(i));
                }
                i++;
                j++;    
            }
        }
        return ans;
    }
}
