class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backTrack(String s, int start, List<String> list){
        if(start == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int end=start+1; end<=s.length(); end++){
            if (isPalindrome(start, end-1, s)){
                list.add(s.substring(start, end));
                backTrack(s, end, list);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }

        return true;
    }
}
