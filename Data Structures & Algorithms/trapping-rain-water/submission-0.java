class Solution {
    public int trap(int[] h) {
        int left = 0;
        int right = h.length-1;
        int lMax = 0;
        int rMax = 0;
        int water = 0;

        while(left<right){
            if(h[left] < h[right]){
                if(h[left] >= lMax){
                    lMax = h[left];
                } else {
                    water += lMax - h[left];
                }
                left++;
            } else {
                if(h[right] >= rMax){
                    rMax = h[right];
                } else {
                    water += rMax - h[right];
                }
                right--;
            }
        }

        return water;
    }
}
