

class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max-Heap: stores [value, index]
        // Ordered by value descending (largest value on top)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < n; i++) {
            // 1. Add current element [value, index] to heap
            maxHeap.offer(new int[]{nums[i], i});

            // 2. Remove elements outside the current window from the top
            //    (lazy deletion — only remove when they're at the top)
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // 3. Once we have a full window, record the max (heap top)
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }

   
}
    
