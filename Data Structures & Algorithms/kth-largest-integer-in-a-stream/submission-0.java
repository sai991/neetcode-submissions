class KthLargest {
   private PriorityQueue<Integer> pq = new PriorityQueue<>();

private int k;
    public KthLargest(int k, int[] nums) {

        this.k=k;
        for(int num:nums){
            pq.add(num);
  if(pq.size()>k){
            pq.poll();
        }

        }
      
        
    }
    
    public int add(int val) {

        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
        
    }
}
