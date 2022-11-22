package jianzhi65;

class Solution {
    public int add(int a, int b) {
        while (b != 0)  {
            int sum  = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}