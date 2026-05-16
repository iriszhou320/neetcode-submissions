class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCosts = new int[n + 1];
        minCosts[0] = 0;
        minCosts[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            minCosts[i] = Math.min(minCosts[i-1] + cost[i-1], minCosts[i-2] + cost[i-2]);
        }
        return minCosts[n];   
    }
}
