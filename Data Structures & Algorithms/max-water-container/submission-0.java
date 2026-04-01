class Solution {
    public int maxArea(int[] h) {
        int ans = 0;
        int l = h[0];
        int r = h[h.length - 1];

        int i=0, j=h.length-1;

        while(i<j){
            l = h[i];
            r = h[j];
            
            int area = (j-i)*(Math.min(l,r));
            ans = Math.max(ans, area);

            if(l<r){
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
