package ac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int[] nums = new int[n];
        String[] str = bf.readLine().split(" ");
        int len = str.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(str[i]);
        }
        int[] temp = new int[nums.length];
        mergesort(nums, 0, nums.length - 1, temp);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        bf.close();
    }

    public static void mergesort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        mergesort(nums, start, (start + end) / 2, temp);
        mergesort(nums, (start + end) / 2 + 1, end, temp);
        merge(nums, start, end, temp);
    }

    public static void merge(int[] nums, int start, int end, int[] temp) {

        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int index = left;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
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
