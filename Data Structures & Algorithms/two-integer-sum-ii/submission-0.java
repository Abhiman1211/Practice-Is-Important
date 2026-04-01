class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        int i=0, j=numbers.length-1;

        while(i<j){
            int left = numbers[i];
            int right = numbers[j];

            if(left + right == target){
                ans[0] = left;
                ans[1] = right;
            }

            if(left + right > target){
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
