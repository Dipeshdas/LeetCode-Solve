class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
    public void quicksort(int[]nums,int l,int r){
        if(l<r){
            int pivot=quick(nums,l,r);
            quicksort(nums,l,pivot-1);
            quicksort(nums,pivot+1,r);
            
        }
    }
    public int quick(int[]arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low) {
                j--;
            }
            if (i < j){
                int t = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = t; 
            }
        }

        int t = arr[j]; 
        arr[j] = arr[low]; 
        arr[low] =t; 
        return j;
    }
}
