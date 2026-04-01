class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxF = 0;
        int[] freq = new int[26];

        for(char c: tasks){
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        maxF = freq[25];

        int slots = (maxF-1)*n;

        for(int i=24; i>=0; i--){
            slots -= Math.min(freq[i], (maxF-1));
        }

        return Math.max(0, slots) + tasks.length;
    }
}
