class Solution {
    public int largestRectangleArea(int[] heights) {
        int ps[]=previousSmaller(heights);
        int ns[]=nextSmaller(heights);

        // for(int i=0;i<heights.length;i++){
        //     System.out.println(ps[i]+" "+ns[i]);
        // }

        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area=((ns[i]-ps[i]-1)*heights[i]);
            // System.out.println(area);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public int[] previousSmaller(int []arr){
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;

    }

    public int[] nextSmaller(int []arr){
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=arr.length;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;

    }
}
