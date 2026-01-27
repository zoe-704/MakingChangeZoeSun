/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Zoe Sun
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        long[] dp = new long[target + 1];
        dp[0] = 1; // 1 way to make 0 cents

        for (int coin : coins) {
            for (int i = 1; i <= target; i++) {
                if (i - coin >= 0 && i - coin < target) dp[i] += dp[i - coin];
            }
        }

        return dp[target];
    }
}
