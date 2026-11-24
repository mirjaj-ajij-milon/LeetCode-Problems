class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE; // to track the lowest buy price
        int max = 0;
        int n = prices.length;

        for(int i=0; i<n; i++){
            if(prices[i] > buy){
                int profit = prices[i] - buy;
                max = Math.max(profit, max);
            }else{
                buy = prices[i];
            }
        }

        return max;
    }
}