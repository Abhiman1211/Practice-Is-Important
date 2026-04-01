class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;

        while (left + k <= nums.length) {
            int val = maxInWindow(nums, left, left + k);
            list.add(val);
            left++;
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int maxInWindow(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
