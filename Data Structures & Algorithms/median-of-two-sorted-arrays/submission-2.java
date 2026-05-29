class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length >nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
           int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while(left<=right){
            int mid1= (left+right)/2;
            int mid2 = (m + n + 1) / 2 - mid1;
            int maxleft1 = (mid1 == 0)? Integer.MIN_VALUE : nums1[mid1 - 1];
            int maxleft2 =(mid2 == 0)? Integer.MIN_VALUE :nums2[mid2-1];
            int minright1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int minRight2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];
            if(maxleft1<=minRight2 && maxleft2 <=minright1){
                if((m+n)%2==0){
                    return (Math.max(maxleft1,maxleft2) + Math.min(minright1,minRight2))/2.0;

                }else{
                       return Math.max(maxleft1, maxleft2);
                }

            }else{
                if(maxleft1 >minRight2){
                    right=mid1-1;
                }else{
                     left = mid1 + 1;
                }

            }
        }
              throw new IllegalArgumentException();
        
    }
}