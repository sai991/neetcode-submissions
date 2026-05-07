class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=1;
        for(int i:piles){
            right =Math.max(right,i);
        }
        while(left<right){

            int mid =(left+right)/2;

            int total=0;

            for(int k :piles){
                total+=Math.ceil((double)k/mid);

            }
            if(total > h){
                left = mid+1;
            }else{
                right = mid;
            }

        }
        return right;
        
    }
}
