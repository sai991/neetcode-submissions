class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> min = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] p:points){
            int d= p[0]*p[0] +p[1]*p[1];
            min.offer(new int[]{d,p[0],p[1]});
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            int[] q = min.poll();
            res[i]= new int[]{q[1],q[2]};
        }
        return res;
    }
}
