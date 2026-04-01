class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(0, nums, new ArrayList<>());
        return ans;
    }

    private void backTrack(int ind, int[] nums, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            backTrack(i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}