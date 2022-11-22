package jianzhi40;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start;
        int r = end;
        int mid = (l + r) / 2;
        int pivot = arr[mid];
        while (l <= r) {
            while (l <= r && arr[l] < pivot) {
                l++;
            }
            while (l <= r && arr[r] > pivot) {
                r--;
            }
            if (l <= r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(arr, start, r);
        quickSort(arr, l, end);
    }
}