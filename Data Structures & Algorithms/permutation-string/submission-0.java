class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i=0; i<s2.length(); i++){
            freq[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<s1.length(); i++){
            if(freq[s1.charAt(i) - 'a'] == 0){
                continue;
            } else {
                freq[s1.charAt(i) - 'a']--;
            }
        }

        for(int i=0; i<s1.length(); i++){
            if(freq[s1.charAt(i) - 'a'] != 0){
                return false;
            }
        }

        return true;
    }
}
