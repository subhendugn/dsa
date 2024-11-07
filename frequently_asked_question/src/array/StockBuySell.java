package array;

public class StockBuySell {
    public int maxProfit_bruteforce(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(prices[j] > prices[i]){
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit_optimal(int[] prices) {
        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<n; i++){
            minPrice = Integer.min(minPrice, prices[i]);
            maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args){
        StockBuySell obj = new StockBuySell();
        System.out.println(obj.maxProfit_optimal(new int[]{7,1,5,3,6,4})); // 5
        System.out.println(obj.maxProfit_optimal(new int[]{7,6,4,3,1})); // 0
    }
}
