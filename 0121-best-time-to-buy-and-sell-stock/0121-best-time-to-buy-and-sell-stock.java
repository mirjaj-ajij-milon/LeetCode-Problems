class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] > buy){
                int profit = prices[i] - buy;
                max = Math.max(max, profit);
            }else{
                buy = prices[i];
            }
        }

        return max;
    }
}