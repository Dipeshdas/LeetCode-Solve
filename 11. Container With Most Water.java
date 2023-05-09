class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int area=0;
        int maxArea=0;

        while(i<j){
            area=Math.min(height[i],height[j])*(j-i);
            if(area>maxArea){
                maxArea=area;
            }

            if(height[i]<=height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}
