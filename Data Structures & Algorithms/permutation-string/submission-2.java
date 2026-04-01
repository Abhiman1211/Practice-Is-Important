class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int l = s2.length();
        int left = 0;
        int freq[] = new int[26];

        if(k > l) return false;

        for(int i=0; i<k; i++){
            freq[s1.charAt(i) - 'a']++;
        }

        for(int i=0; i<l; i++){
            freq[s2.charAt(i)-'a']--;

            while(i-left+1>k){
                freq[s2.charAt(left) - 'a']++;
                left++;
            }

            if(i-left+1 == k){
                boolean match = true;
                for(int j=0; j<26; j++){
                    if(freq[j] != 0){
                        match = false;
                        break;
                    }
                }

                if (match) return true;
            }
        }

        return false;
    }
}
