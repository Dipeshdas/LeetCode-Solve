class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
           return findMedianSortedArrays(nums2,nums1);//we have to calculate with minimum length of array
        }
        int n1=nums1.length;
        int n2=nums2.length;

        int low=0,high=n1;

        while(low<=high){
            int cut1=(low+high)/2;
            int cut2=(n1+n2+1)/2-cut1;//(n1+n2+1)/2 is for calculate the medianPosition

            int l1 = (cut1 == 0)? Integer.MIN_VALUE:nums1[cut1-1];//if there is no element pick from left of the first array assign it to min value;
            int l2 = (cut2 == 0)? Integer.MIN_VALUE:nums2[cut2-1];//if there is no element pick from left of the second array assign it to min value;

            int r1 = (cut1 == n1)? Integer.MAX_VALUE:nums1[cut1];//if there is no element pick from right of the first array assign it to max value;
            int r2 = (cut2 == n2)? Integer.MAX_VALUE:nums2[cut2];//if there is no element pick from right of the second array assign it to max value;

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){//even the length is even
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }

            else if(l1>r2){
                high=cut1-1;
            }
            else{
                low=cut1+1;
            }

        }
        
        return 0.0;
    }
}
