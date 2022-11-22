package jianzhi67;

class Solution {
    public int strToInt(String str) {
        int k = 0;
        while (k < str.length() && str.charAt(k) == ' ') {
            k++;
        }
        if (k == str.length()) {
            return 0;
        }
        int minus = 1;
        if (str.charAt(k) == '-') {
            minus = -1;
            k++;
        } else if (str.charAt(k) == '+') {
            k++;
        }

        long res = 0;
        while (k < str.length() && str.charAt(k) >= '0' && str.charAt(k) <= '9') {
            res = res * 10 + (str.charAt(k) - '0');
            k++;
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        res *= minus;
        if (res > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int) res;
    }
}