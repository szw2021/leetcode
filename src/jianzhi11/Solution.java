package jianzhi11;

class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int start = 0;
        int end = numbers.length - 1;
        if (numbers[end] > numbers[start]) {
            return numbers[start];
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (numbers[mid] < numbers[0]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(numbers[start], numbers[end]);
        
    }
}
