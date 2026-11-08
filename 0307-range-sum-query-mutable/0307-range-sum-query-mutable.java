class NumArray {

    static int tree[];
    public int n;
    private int nums[];
    public static void init(int n){
        tree = new int[4 * n];
    }

    public static void buildST(int i, int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = si + (sj - si)/2;
        buildST(2*i+1, si, mid, arr);
        buildST(2*i+2, mid+1, sj, arr);

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        init(n);
        buildST(0, 0, n-1, nums);
    }
    
    public void update(int index, int val) {
        int old = nums[index];
        int diff = val - old;
        nums[index] = val;
        updateUtil(0, 0, n-1, index, diff);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }

        tree[i] += diff;

        if(si != sj){
            int mid = si + (sj - si)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    
    public int sumRange(int left, int right) {
        return sumUtil(0, 0, n-1, left, right);
    }

    public static int sumUtil(int i, int si, int sj, int qi, int qj){
        if(si > qj || sj < qi){
            return 0;
        }else if(qi <= si && qj >= sj){
            return tree[i];
        }

        int mid = si + (sj - si)/2;
        int left = sumUtil(2*i+1, si, mid, qi, qj);
        int right = sumUtil(2*i+2, mid+1, sj, qi, qj);

        return left + right;
    }
    
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */