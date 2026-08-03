import java.util.*;

class Solution {

    int[] dp;
    int n;

    public String stoneGameIII(int[] stoneValue) {

        n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int diff = solve(0, stoneValue);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }

    private int solve(int i, int[] stoneValue) {

        if (i >= n)
            return 0;

        if (dp[i] != Integer.MIN_VALUE)
            return dp[i];

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int k = 0; k < 3 && i + k < n; k++) {
            sum += stoneValue[i + k];
            ans = Math.max(ans, sum - solve(i + k + 1, stoneValue));
        }

        return dp[i] = ans;
    }
}