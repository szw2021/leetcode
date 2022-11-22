package jianzhi51;

class Solution {
    int res = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int start,int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, right, end);

        merge(nums, start, end);
    }

    private void merge(int[] nums, int start, int end) {
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int [] temp = new int[nums.length];
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index++] = temp[left++];
            } else {
                if (nums[left] > nums[right]) {
                    res += mid - left + 1;
                }
                temp[index++] = temp[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = temp[left++];
        }
        while (right <= end) {
            temp[index++] = temp[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
