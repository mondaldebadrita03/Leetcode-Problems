// Solved by shifting elements T.C: O(m*n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m + n == 1){
            if(n == 1){
                nums1[0] = nums2[0];
            }
        }
        else{
            int i = 0;
            int j = 0;

            while(i < m && j < n){
                if(nums1[i] <= nums2[j]){
                    i++;
                }
                else{
                    int temp = nums2[j];

                    for (int k = m - 1; k >= i; k--) {
                        nums1[k + 1] = nums1[k];
                    }
                    nums1[i] = temp;
            
                    m++; 
                    i++;
                    j++;
                }
            }
            while(j < n){
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
    }
}

// Solved by two pointers reverse merge approach T.C: O(m + n)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
