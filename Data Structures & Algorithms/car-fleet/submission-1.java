class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> hm = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<position.length;i++){
            double t = (double) (target-position[i])/speed[i];
            hm.put(position[i],t);
        }
        int n = position.length;
        Arrays.sort(position);
        for(int i=n-1;i>=0;i--){
 if(st.isEmpty()||hm.get(position[i])>hm.get(st.peek())){
    st.push(position[i]);
 }
        }
        return st.size();
       
    }
}
