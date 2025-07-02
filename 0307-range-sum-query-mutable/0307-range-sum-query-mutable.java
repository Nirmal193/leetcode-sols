class NumArray {
    int n;
    int data[];
    public NumArray(int[] nums) {
        this.n = nums.length;
        data = new int[nums.length * 4];
        build(nums,0,0,nums.length-1);
    }
    private void build(int arr[], int node,int start,int end){
        if(start == end){
            data[node] = arr[start];
            return;
        }
        int mid = start + (end - start)/2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        build(arr,leftChild,start,mid);
        build(arr,rightChild,mid+1,end);
        data[node] = data[leftChild] + data[rightChild];
    }
    public void update(int index, int val) {
        updateHelper(0,0,n-1,index,val);
    }
    private void updateHelper(int node, int start, int end, int index, int val){
        if(start == end){
            data[node] = val;
            return;
        }
        int mid = start + (end-start)/2;
        if(index <= mid)
            updateHelper(2 * node + 1,start, mid,index,val);
        else
            updateHelper(2 * node + 2,mid+1,end, index, val);
        data[node] = data[2 * node + 1] + data[2 * node + 2];
    }
    
    public int sumRange(int left, int right) {
        return findRange(0,0,n-1,left,right);
    }
    private int findRange(int node, int left, int right, int start, int end){
        if(start > right || end  < left)
            return 0;
        if(left >= start && right <= end){
            return data[node];
        }
        int mid = left + (right-left)/2;
        int leftValue = findRange(2 * node + 1,left,mid,start, end);
        int rightValue = findRange(2 * node + 2,mid+1,right,start,end);
        return leftValue + rightValue;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */