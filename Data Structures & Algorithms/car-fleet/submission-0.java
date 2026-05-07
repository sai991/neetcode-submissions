class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Map<Integer, Double> mp = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // 1️⃣ Use double for accurate time
        for (int i = 0; i < n; i++) {
            double targetReachTime = (double)(target - position[i]) / speed[i];
            mp.put(position[i], targetReachTime);
        }

        // 2️⃣ Sort positions ascending
        Arrays.sort(position);

        // 3️⃣ Traverse from closest to farthest
        for (int i = n - 1; i >= 0; i--) {
            int k = position[i];

            if (st.isEmpty() || mp.get(k) > mp.get(st.peek())) {
                st.push(k);
            }
        }

        return st.size();
    }
}