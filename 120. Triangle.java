class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sum=0;

        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int first=triangle.get(i+1).get(j);
                int second=triangle.get(i+1).get(j+1);
                int min=Math.min(first,second);
                sum=min+triangle.get(i).get(j);
                triangle.get(i).set(j,sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
