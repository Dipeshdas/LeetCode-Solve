class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c=0;
        while(m<nums1.length){
            nums1[m++]=nums2[c++];
        }
        Arrays.sort(nums1);
    }
}
