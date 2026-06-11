class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
        for(int st:stones){
            pq.offer(st);
        }

        while(pq.size()>1){
            int a= pq.poll();
            int b=pq.poll();
            if((a-b)>0){
                pq.offer(a-b);
            }
        }
        if(pq.size()==1)
        return pq.poll();
return 0;
        
    }
}
