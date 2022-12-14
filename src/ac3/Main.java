package ac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int res = 0;
    public int reversePairs(int[] nums) {
        int [] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return res;
    }

    private void mergeSort(int[] nums, int start,int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, right, end, temp);

        merge(nums, start, end, temp);
    }

    private void merge(int[] nums, int start, int end, int[] temp) {
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                if (nums[left] > nums[right]) {
                    res += mid - left + 1;
                }
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}

