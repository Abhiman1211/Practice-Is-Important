class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        findCombinations(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {

            // Skip duplicates
            if (i > ind && arr[i] == arr[i - 1]) continue;

            // Stop if element exceeds target
            if (arr[i] > target) break;

            // Pick element
            ds.add(arr[i]);

            // Recurse with next index
            findCombinations(i + 1, arr, target - arr[i], ans, ds);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}