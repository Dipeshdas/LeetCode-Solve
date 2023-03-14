class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    public void solve(int ind,int[]candidates,int target,List<List<Integer>>ans,ArrayList<Integer>temp){
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(candidates[ind]<=target){
            temp.add(candidates[ind]);
            solve(ind,candidates,target-candidates[ind],ans,temp);//for pick
            temp.remove(temp.size()-1);//in the time of backtrack just removing the last element from the arraylist.
        }
        solve(ind+1,candidates,target,ans,temp);//for not pick

    }
}
