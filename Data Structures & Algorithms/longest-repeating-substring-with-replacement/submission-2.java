class Solution {
    public int characterReplacement(String s, int k) {
        int iL = 0;
        int mFreq = 0;
        int mSize = 0;
        int freq[] = new int[26];

        for(int iR=0; iR<s.length(); iR++){
            freq[s.charAt(iR) - 'A']++;
            mFreq = Math.max(mFreq, freq[s.charAt(iR)-'A']);

            while(iR-iL+1-mFreq > k){
                freq[s.charAt(iL) - 'A']--;
                iL++;
            }

            mSize = Math.max(iR-iL+1, mSize);
        }

        return mSize;
    }
}
