class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int k = i;
                int j = map.get(target-nums[i]);
                if(k<j){
                    return new int[]{k,j};
                } else {
                    return new int[]{j,k};
                }
            }
            map.put(nums[i],i);
        }

        return new int[]{};
    }
}
