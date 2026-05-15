class Solution {
    public int maxProfit(int[] prices) {

        int leftmin=Integer.MAX_VALUE;
        int max=0;
        for(int i : prices){
            if(leftmin >i){
                leftmin=i;
            }else{
                max=Math.max(max,i-leftmin);

            }
        }

        return max;
        
    }
}
