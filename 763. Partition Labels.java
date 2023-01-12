// i)I have put all character of the string in a HashMap with their last occurence.

// iii)Then i have declared a prev variable which is initialize to -1;

// ii)Next i have declared a max variable which will continuously updated with the last maximum occurence of each character.

// iii)if any time that particular index and max is same,that means we got our first partition and calculate the length(max-prev) and add this in arraylist.

// iv) atlast i update the prev value so that we can recognize the starting index of second partition.that is help to calculate the length again.

class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer>map=new HashMap<>();
        List<Integer>ans =new ArrayList<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int prev=-1;
        int max=0;

        for(int i=0;i<s.length();i++){
            max=Math.max(max,map.get(s.charAt(i)));
            if(max==i){
                ans.add(max-prev);
                prev=max;
            }
        }
        return ans;
    }
}
