class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        int sel = 0;

        for(int i=0; i<prices.length; i++){
            buy = Math.min(buy, prices[i]);
            sel = Math.max(sel, prices[i] - buy);
        }

        return sel;
    }
}
