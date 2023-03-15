class Solution {
    public String getPermutation(int n, int k) {
        List<Integer>list=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
        list.add(n);
        k=k-1;
        String ans="";
        while(true){
            ans+=list.get(k/fact);
            list.remove(k/fact);
            if(list.size()==0){
                break;
            }
            k=k%fact;
            fact=fact/list.size();
        }
        return ans;
    }
}
