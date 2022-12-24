class Solution {
    int a[];
    Random random;
    public Solution(int[] nums) {
        this.a=nums;
        random=new Random();
    }
    
    public int[] reset() {
        return a;
    }
    
    public int[] shuffle() {
        if(a==null) return null;
        int k[]=a.clone();
        for(int i=0;i<a.length;i++){
            int j=random.nextInt(i+1);

            int temp=k[i];
            k[i]=k[j];
            k[j]=temp;
        }
        return k;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
