class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> comp = (a, b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];

            return distB - distA;
        };

        PriorityQueue<int[]> pq = new PriorityQueue<>(comp);
        int ans[][] = new int[k][2];

        for(int[] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }

        return ans;
    }
}
