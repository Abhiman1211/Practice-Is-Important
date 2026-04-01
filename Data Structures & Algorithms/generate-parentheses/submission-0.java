class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        reccursion(0,0,"",n);
        return ans;
    }

    private void reccursion(int left, int right, String value, int n){
        if(value.length() == 2*n){
            ans.add(value);
            return;
        }

        if(left < n){
            reccursion(left+1, right, value + "(", n);
        }

        if(right < left){
            reccursion(left, right+1, value + ")", n);
        }
    }
}
