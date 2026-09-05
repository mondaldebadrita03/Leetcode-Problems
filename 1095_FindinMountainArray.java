/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

// 1. Find peak
// 2. Search target in the first half (ascending part)
// 3. If target not found in first half, search second half (descending part)
// 4. If not found return -1
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int len = mountainArr.length();
        int end = len - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);
            int nextValue = mountainArr.get(mid + 1);
            
            if(midValue < nextValue){
                start = mid + 1;
            }
            if(midValue > nextValue){
                end = mid;
            }
        }
        int ans = binarySearch(mountainArr, target, 0, end, true);
        if(ans != -1)
            return ans;
        return binarySearch(mountainArr, target, end + 1, len - 1, false);
    }

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean isAsc){

        while(left <= right){
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);

            if(midValue == target){
                return mid;
            }
            if(isAsc){
                if(midValue > target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(midValue < target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
