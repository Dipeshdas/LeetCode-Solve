//LEETCODE
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (int i = 0; i < piles.size(); i++) {
            for (int j = 1; j < piles.get(i).size(); j++) {
                piles.get(i).set(j, piles.get(i).get(j) + piles.get(i).get(j-1));
            }
        }

    int n = piles.size();
    int[][] dp = new int[n+1][k+1];

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= k; j++) {
            dp[i][j] = -1;
        }
    }

    return solve(piles, k, 0, dp);
    }

    public int solve (List<List<Integer>> p,int k,int i, int[][]dp){
         if (i == p.size())
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int max = 0;
        max = Math.max(max, solve(p, k, i+1, dp));

        for (int j = 0; j < p.get(i).size(); j++) {
            if (j+1 <= k) {
                max = Math.max(max, p.get(i).get(j) + solve(p, k-j-1, i+1, dp));
            } else {
                break;
            }
        }

        return dp[i][k] = max;
    }
}
