class NumArray {
    int n;
    private int arr[];
    static int tree[];

    private static void init(int n) {
        tree = new int[n * 4];
    }

    public NumArray(int[] nums) {
        n = nums.length;
        this.arr = nums;
        if(n == 0) return;
        init(n);
        buildST(0, 0, n - 1, nums);
    }

    private static int buildST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return tree[i];
        }

        int mid = si + (sj - si) / 2;
        int left = buildST(2 * i + 1, si, mid, arr);
        int right = buildST(2 * i + 2, mid + 1, sj, arr);

        tree[i] = left + right;
        return tree[i];
    }

    private static void udateUtil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) {
            return;
        }

        tree[i] += diff;

        if (si != sj) {
            int mid = si + (sj - si) / 2;
            udateUtil(2 * i + 1, si, mid, idx, diff);
            udateUtil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public void update(int index, int val) {
        int old = arr[index];
        int diff = val - old;
        arr[index] = val;
        udateUtil(0, 0, n - 1, index, diff);
    }

    private static int getSum(int i, int si, int sj, int left, int right) {
        if (si > right || sj < left) {
            return 0;
        } else if (si >= left && sj <= right) {
            return tree[i];
        }

        int mid = si + (sj - si) / 2;

        int l = getSum(2 * i + 1, si, mid, left, right);
        int r = getSum(2 * i + 2, mid + 1, sj, left, right);

        return l + r;
    }

    public int sumRange(int left, int right) {
        return getSum(0, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */