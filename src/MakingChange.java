import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Zoe Sun
 */

public class MakingChange {
    /*
    static long[][] dp; // table to store amounts from memoization
    static int[] c;

    public static long dfs(int i, int amount) {
        // base cases: exact amount made OR negative amount / no coins left
        if (amount == 0) return 1;
        if (amount < 0 || i == c.length) return 0;
        if (dp[i][amount] != -1) return dp[i][amount]; // return if already computed

        long useCoin = dfs(i, amount-c[i]); // dfs and use coin at index i
        long skipCoin = dfs(i+1, amount); // dfs and skip coin

        // memoize results
        dp[i][amount] = useCoin + skipCoin;
        return dp[i][amount];
    }
    */

    public static long countWays(int target, int[] coins) {
        int n = coins.length;
        /* // memoization
        dp = new long[n][target + 1];
        c = coins;
        // fill dp array with -1 to mark as uncomputed
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // dfs from index 0 to get target amount
        return dfs(0, target);
        */



        /* // 2D tabulation
        long[][] dp = new long[n][target+1]; // table to store calculations from tabulation
        Arrays.sort(coins); // sorting coins makes code faster

        // base case when amount is 0
        for (int i = 0; i < n; i++) dp[i][0] = 1;

        // iterate through each coin and amount of money
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (i-1 >= 0) dp[i][j] += dp[i-1][j]; // don't use coin i
                if (j-coins[i] >= 0) dp[i][j] += dp[i][j-coins[i]]; // use coin i
            }
        }
        return dp[n-1][target]; // number of ways to make target with all coins
        */



        // 1D tabulation
        long[] dp = new long[target + 1];
        dp[0] = 1; // base case: 1 way to make 0 cents
        // iterate through each coin value and 1-target amount of money
        for (int coin : coins) {
            for (int i = 1; i <= target; i++) {
                // prevent going out of bounds
                if (i - coin >= 0 && i - coin < target)
                    dp[i] += dp[i - coin]; // calculate ways to make i amount of money
            }
        }
        return dp[target];
    }
}
