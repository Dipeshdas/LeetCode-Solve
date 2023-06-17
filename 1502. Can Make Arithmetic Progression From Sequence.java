class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int x=Math.abs(arr[1]-arr[0]);
        if(arr.length==2){
                return true;
        }
        for(int i=1;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])!=x){
                return false;
            }
        }
        return true;
    }
}
