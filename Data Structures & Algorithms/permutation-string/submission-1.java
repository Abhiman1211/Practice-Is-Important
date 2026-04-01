class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();

        if (k > n) return false;

        // sort s1
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        // sliding window of length k
        for (int i = 0; i <= n - k; i++) {
            String sub = s2.substring(i, i + k);
            char[] subArr = sub.toCharArray();
            Arrays.sort(subArr);

            if (sortedS1.equals(new String(subArr))) {
                return true;
            }
        }

        return false;
    }
}
