class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return ans;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, map, 0, new StringBuilder());
        return ans;    
    }

    private void backTrack(String digi, Map<Character, String> map, int idx, StringBuilder sb){
        if(idx == digi.length()){
            ans.add(sb.toString());
            return;
        }

        String letters = map.get(digi.charAt(idx));
        for(char letter : letters.toCharArray()){
            sb.append(letter);
            backTrack(digi, map, idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
