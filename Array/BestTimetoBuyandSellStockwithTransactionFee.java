package Array;
/*
 * Your are given an array of integers prices, for which the i-th element is the price 
 * of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction 
fee for each transaction. You may not buy more than 1 share of a stock at a time 
(ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.
 * 
 * */
public class BestTimetoBuyandSellStockwithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
        //Using DP to solve
		//create two arrays to store the profit that hold or unhold the stock on i day
		int length = prices.length;
		if(length <= 1)
		{
			//then don't do anything since if only one day and buy one stock the profit
			//will be less then do nothing
			return 0;
		}
		int[] hold = new int[length]; //The max profit by holding the stock till day i
		int[] unhold = new int[length]; //The max profit by not holding the stock till day i
		//set up the initial value for these two arrays
		hold[0] = - prices[0];//If buy the stock the first day, then profit is minus since need to buy stock from profit 0
		unhold[0] = 0;//if don't buy the stock the first day
		//Note that the transaction fee will cost only when a buy-sell process finished
		for(int i = 1;i<prices.length;i++)
		{
			//the value of profit depend on the previous day
			//If want to hold one stock one day i, then there are two choice based on day i-1 that need to compare:
			//1) if on day i-1 still hold one stock, the profit is hold[i-1] since can't buy again before sell
			//2) if on day i-1 don't hold one stock, the profit is unhold[i-1]-prices[i],
			//notice that don't minus fee when buy stock
			hold[i] = Math.max(hold[i-1], unhold[i-1]-prices[i]);
			//If don't want to hold one stock on day i meaning sell stock, 
			//then there are also two choice based on day i-1 that need to compare:
			//1) if on day i-1 still hold one stock, the profit is hold[i-1]+prices[i]-fee
			//2) if on day i-1 don't hold one stock, the profit is unhold[i-1]
			//notice that must minus fee when sell, because a buy-sell process is just finished!
			unhold[i] = Math.max(unhold[i-1],prices[i]-fee+hold[i]);
			
		}
		//For the result, we need to return the unhold profit we got the last day
		//Since if still hold one stock then the profit can't be maximum
		return unhold[length-1];
		
    }
	public static void main(String[] args)
	{
		BestTimetoBuyandSellStockwithTransactionFee test = new BestTimetoBuyandSellStockwithTransactionFee();
		int[] testArray = {1, 3, 2, 8, 4, 9};
		test.maxProfit(testArray, 2);
	}

}
