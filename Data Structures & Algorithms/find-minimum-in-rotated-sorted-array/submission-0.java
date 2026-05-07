class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return remin(nums,0,nums.length-1);  

        }
    
    private int remin(int[] nums, int l, int r){
        if(l==r){
            return nums[l];
        }
        int mid =l+(r-l)/2;
        int lmax=remin(nums,l,mid);
        int rmax=remin(nums,mid+1,r);
        return Math.min(lmax,rmax);
    }
}