class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i=0;
        int j=prices.length-1;

        while(i<j){
            int buy = prices[i];
            int sell = prices[j];

            profit = Math.max(profit, (sell - buy));
            i++;
            j--;
        }

        return profit;
    }
}
