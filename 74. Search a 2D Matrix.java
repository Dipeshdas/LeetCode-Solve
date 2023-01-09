class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==0) return false;

        int n=matrix.length;
        int m=matrix[0].length;

        //set the low value and high value by indices.
        int low=0,high=(n*m)-1;
        
        while(low<=high){
            int mid=(low+(high-low)/2);

            //calculating the (rowIndex,colIndex) where mid is right now.
            int rInd=mid / m;
            int cInd=mid % m;

            //Simple Binary Search
            if(matrix[rInd][cInd]==target){
                return true;
            }
            else if(matrix[rInd][cInd]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return false;
        
    }
}
