import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Zoe Sun
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] arr = new int[n][target];
        for (int i = 0; i < target; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0) arr[i][j] += arr[i][j-1];
                if (i - coins[j] >= 0) arr[i][j] += arr[i - coins[j]][i];
            }
        }
        return arr[n-1][target-1];

        /*
        int n = coins.length;


        long[] dp = new long[target + 1];
        dp[0] = 1; // 1 way to make 0 cents

        for (int coin : coins) {
            for (int i = 1; i <= target; i++) {
                if (i - coin >= 0 && i - coin < target) dp[i] += dp[i - coin];
            }
        }

        return dp[target];
         */
    }
}
