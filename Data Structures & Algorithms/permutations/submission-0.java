class Solution {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums, new ArrayList<>());
        return list;
    }

    private void backTrack(int [] nums, List<Integer> temp){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        } else {
            for(int i=0; i<nums.length; i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(nums, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
