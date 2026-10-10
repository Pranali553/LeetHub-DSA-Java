class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        int n = nums1.length;
        int[] diff = new int[n];

        long k = (long) k1 + k2;
        long sum = 0;
        int max = 0;

        // Step 1: Calculate absolute differences
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        // Step 2: All differences can become zero
        if (sum <= k) {
            return 0;
        }

        // Step 3: Binary search the maximum difference
        int l = 0;
        int r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long required = 0;

            for (int d : diff) {
                required += Math.max(0, d - mid);
            }

            if (required <= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // Step 4: Reduce all differences to at most l
        for (int i = 0; i < n; i++) {
            int reduction = Math.max(0, diff[i] - l);
            k -= reduction;
            diff[i] = Math.min(diff[i], l);
        }

        // Step 5: Use remaining operations
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == l) {
                diff[i]--;
                k--;
            }
        }

        // Step 6: Calculate the final squared sum
        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}