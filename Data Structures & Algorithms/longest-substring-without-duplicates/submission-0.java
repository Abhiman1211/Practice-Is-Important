class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int cur = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                cur++;
                ans = Math.max(ans, cur);
            } else {
                set.clear();
                set.add(s.charAt(i));
                cur = 1;
            }
        }

        return ans;
    }
}
