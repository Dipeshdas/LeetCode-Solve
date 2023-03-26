class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans[]=new int[numOnes+numZeros+numNegOnes];
        int i=0;
        while(numOnes>0){
            ans[i++]=1;
            numOnes--;
        }
        while(numZeros>0){
            ans[i++]=0;
            numZeros--;
        }
        
        while(numNegOnes>0){
            ans[i++]=-1;
            numNegOnes--;
        }
        
        int sum=0;
        int j=0;
        while(k>0){
            
            sum+=ans[j++];
            
            k--;
        }
        return sum;
    }
}
