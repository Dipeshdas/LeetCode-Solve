import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        char nums[]=s.toCharArray();
        List<String>ans=new ArrayList<>();
        solve(0,nums,ans);
        return ans;
    }

    public static void solve(int ind,char[] nums,List<String>ans){
        if(ind==nums.length){
            String str="";
            for(int i=0;i<nums.length;i++){
                str+=nums[i];
            }
            ans.add(str);
            return;
        }

        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            solve(ind+1,nums,ans);
            swap(i,ind,nums);//backtrack
        }
    }

    public static void swap(int i,int j,char[]nums){
        char temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
