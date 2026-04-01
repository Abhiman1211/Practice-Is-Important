class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : stones){
            heap.offer(n);
        }

        while(heap.size() > 1){
            int y = heap.poll();  
            int x = heap.poll();  
            
            if(x != y){  
                heap.offer(y - x);
            }
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
