package ac1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = cin.nextInt();
//        }
//        quicksort(nums, 0, nums.length - 1);
//        for (int i = 0; i < n; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        cin.close();
        int[] arr = {49,59,88,37,98,97, 68,54, 31,3};
        quicksort(arr, 0, arr.length - 1);
    }

    public static void quicksort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int l = start;
        int r = end;
        int mid = (l + r) >> 1;
        int pivot = nums[mid];
        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l <= r) {
                int temp = nums[l];
                nums[l] =  nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        quicksort(nums, start, r);
        quicksort(nums, l, end);
    }
}
