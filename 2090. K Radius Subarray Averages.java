class Solution {
    public int[] getAverages(int[] nums, int k) {
        int arr[] = new int[nums.length];
        
        int midIndex = k;
        int window = 2*k+1;
        
        
        int i=0,j=0;
        long sum = 0l;
        
        Arrays.fill(arr,-1);
        
        while(j<nums.length){
            
            sum = sum + nums[j];
            
            if(j-i+1 < window){
                j++;
            }
            else if(j-i+1 == window){
                arr[midIndex++] = (int)(sum/window);
                
                sum = sum - nums[i];
                i++;
                j++;
            }
            
        }
        
       
        
        return arr;
    }
}
