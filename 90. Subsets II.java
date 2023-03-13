class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void solve(int ind,int[]nums,ArrayList<Integer>temp,List<List<Integer>>ans){
        ans.add(new ArrayList<>(temp));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;//for duplicate checking
            temp.add(nums[i]);
            solve(i+1,nums,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
