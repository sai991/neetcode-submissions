class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int n :nums){
             hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> hm.get(a) - hm.get(b)
        );
 for (int num : hm.keySet()) {
            pq.offer(num);
            // Keep heap size at most k
            if (pq.size() > k) {
                pq.poll();  // remove least frequent
            }
        }

        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[i++]=pq.poll();
        }

        return res;
    }
}
