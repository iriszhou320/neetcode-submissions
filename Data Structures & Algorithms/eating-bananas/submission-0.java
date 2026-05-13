class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        // binary search on 0 to max;
        int res = Integer.MAX_VALUE;
        int left = 1;
        int right = max;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if (canFinish(piles, mid, h)) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    boolean canFinish(int[] piles, int rate, int h) {
        // O(n) - n = the number of piles in piles
        double totalHours = 0;
        for (int pile: piles) {
            double hour = Math.ceil((double)pile/rate);
            totalHours += hour;
        }
        System.out.println(totalHours <= h);
        return totalHours <= h;
    }
}
