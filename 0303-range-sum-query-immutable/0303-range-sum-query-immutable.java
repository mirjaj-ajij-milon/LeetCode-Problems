class NumArray {
    private int tree[];
    int n;

    private void init(int n){
        tree = new int[n*4];
    }
    
    public NumArray(int[] nums) {
        n = nums.length;
        init(n);
        buildST(0, 0, n-1, nums);
    }

    private int buildST(int i, int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return tree[i];
        }

        int mid = si + (sj - si)/2;

        int l = buildST(2*i+1, si, mid, arr);
        int r = buildST(2*i+2, mid+1, sj, arr);
        tree[i] = l + r;

        return tree[i];
    }
    
    public int sumRange(int left, int right) {
        return getSum(0, 0, n-1, left, right);
    }

    private int getSum(int i, int si, int sj, int st, int end){
        if(si > end || sj < st){
            return 0;
        }else if(si >= st && sj <= end){
            return tree[i];
        }

        int mid = si + (sj - si)/2;

        int left = getSum(2*i+1, si, mid, st, end);
        int right = getSum(2*i+2, mid+1, sj, st, end);

        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */