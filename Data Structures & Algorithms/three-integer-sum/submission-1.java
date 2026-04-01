class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int j = i+1;
            int k = nums.length - 1;

            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    ans.add(curr);
                    j++;
                    k--;
                    
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }

                if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
