class NumArray {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    int n;
    // int nums[] = new int[n];

    public NumArray(int[] nums) {
        n = nums.length;
        // this.nums = nums;
        init(n);
        buildST(0, 0, n - 1, nums);
    }

    public static void buildST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj - si) / 2;

        buildST(2 * i + 1, si, mid, arr);
        buildST(2 * i + 2, mid + 1, sj, arr);

        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public int sumRange(int left, int right) {
        return getSum(0, 0, n - 1, left, right);
    }

    public static int getSum(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) {
            return 0;
        } else if (si >= qi && sj <= qj) {
            return tree[i];
        }

        int mid = si + (sj - si) / 2;

        int left = getSum(2 * i + 1, si, mid, qi, qj);
        int right = getSum(2 * i + 2, mid + 1, sj, qi, qj);
        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */