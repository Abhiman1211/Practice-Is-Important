class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int ans = 0;

        for(int num : set){
            if(!set.contains(num-1)){
                int score = num;
                int streak = 1;

                while(set.contains(score+1)){
                    score++;
                    streak++;
                }

                ans = Math.max(ans, streak);
            }
        }

        return ans;
    }
}
