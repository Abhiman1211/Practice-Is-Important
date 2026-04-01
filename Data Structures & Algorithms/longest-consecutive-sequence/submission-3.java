class Solution {
    public int longestConsecutive(int[] nums) {
    if (nums.length == 0) return 0;

    Set<Integer> seen = new HashSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int x : nums) {
        if (seen.add(x)) {
            pq.add(x);
        }
    }

    int longest = 1;
    int curr = 1;
    int prev = pq.poll();

    while (!pq.isEmpty()) {
        int val = pq.poll();
        if (val == prev + 1) {
            curr++;
        } else {
            curr = 1;
        }
        longest = Math.max(longest, curr);
        prev = val;
    }

    return longest;
}

}
