class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // ✅ FIX 1: return the result
        }

        int l = 0, r = 0, t = 0;
        int[] res = new int[nums1.length + nums2.length];

        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] > nums2[r]) {
                res[t++] = nums2[r++];
            } else {
                res[t++] = nums1[l++];
            }
        }

        // ✅ FIX 2: also handle leftover elements from nums1
        while (l < nums1.length) {
            res[t++] = nums1[l++];
        }

        while (r < nums2.length) {
            res[t++] = nums2[r++];
        }

        int mid = res.length / 2;
        if (res.length % 2 == 0) {
            return (double)(res[mid] + res[mid - 1]) / 2;
        } else {
            return (double) res[mid];
        }
    }
}