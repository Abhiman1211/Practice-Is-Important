class Solution {
    public boolean hasDuplicate(int[] nums) {
        int freq[] = new int[100001];
        
        for(int i=0; i<nums.length; i++){
            freq[nums[i]] += 1;
            if(freq[nums[i]] > 1){
                return true;
            }
        }

        return false;
    }
}