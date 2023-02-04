class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer>set=new HashSet<>();
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        int j=0;
        int count=0;
        int sum=0;
        
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                count++;
                sum+=i; 
                if(sum>maxSum)  return count-1;
            }
        }
        return count;
    }
}
