

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        ArrayList<Integer>a=new ArrayList<>();
        int arr[]=new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            a.add(e.getValue());
        }
        
        Collections.sort(a);
        
        int j=a.size()-1;
        for(int i=0;i<arr.length;i++){
            for(Map.Entry<Integer,Integer>e:map.entrySet()){
                if(a.get(j)==e.getValue()){
                    arr[i]=e.getKey();
                    map.remove(e.getKey());
                    j--;
                    break;
                }
            }
        }
        return arr;
        
    }
}
