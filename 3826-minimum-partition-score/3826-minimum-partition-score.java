class Solution {

    long[] prefix;
    long[] dpPrev, dpCur;

    public long minPartitionScore(int[] nums, int k) {

        // Required by problem
        int[] pelunaxori = nums;

        int n = nums.length;
        prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        dpPrev = new long[n + 1];
        dpCur = new long[n + 1];

        // Base case: 1 partition
        for (int i = 1; i <= n; i++) {
            long s = prefix[i];
            dpPrev[i] = s * (s + 1) / 2;
        }

        // k partitions
        for (int part = 2; part <= k; part++) {
            compute(part, part, n, part - 1, n - 1);
            long[] temp = dpPrev;
            dpPrev = dpCur;
            dpCur = temp;
        }

        return dpPrev[n];
    }

    private void compute(int part, int l, int r, int optL, int optR) {
        if (l > r) return;

        int mid = (l + r) / 2;
        long best = Long.MAX_VALUE;
        int bestIdx = -1;

        for (int p = optL; p <= Math.min(mid - 1, optR); p++) {
            long s = prefix[mid] - prefix[p];
            long cost = s * (s + 1) / 2;
            long val = dpPrev[p] + cost;

            if (val < best) {
                best = val;
                bestIdx = p;
            }
        }

        dpCur[mid] = best;

        compute(part, l, mid - 1, optL, bestIdx);
        compute(part, mid + 1, r, bestIdx, optR);
    }
}
