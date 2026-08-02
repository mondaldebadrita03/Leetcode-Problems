class Solution {
    long count = 0;
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] val = new long[n + 1];
        long x = 0;
        long y = 0;
        val[0] = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                x++;
            } else {
                y++;
            }
            val[i + 1] = x * b - y * a;
        }
        count = 0;
        mergeSortAndCount(val, 0, n);
        return count;
    }

    private void mergeSortAndCount(long[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortAndCount(arr, left, mid);
        mergeSortAndCount(arr, mid + 1, right);
        countPairs(arr, left, mid, right);
    }
    private void countPairs(long[] arr, int left, int mid, int right) {
        int j = left;
        for (int i = mid + 1; i <= right; i++) {
            while (j <= mid && arr[j] >= arr[i]) {
                j++;
            }
            count += (j - left);
        }
        long[] temp = new long[right - left + 1];
        int p1 = left, p2 = mid + 1, k = 0;

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] >= arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) temp[k++] = arr[p1++];
        while (p2 <= right) temp[k++] = arr[p2++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
