class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0,j=n-1;
        int res=0;
        while(i<j){
            int h= Math.min(height[i],height[j]);
            res=Math.max(res,h*(j-i));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }


        }
        return res;
    }
}