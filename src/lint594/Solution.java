package lint594;

import java.util.Base64;

public class Solution {
    /**
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int BASE = 1000000;
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        int m = target.length();
        if (m == 0) {
            return 0;
        }

        int pow = 1;
        for (int i = 0; i < m; i++) {
            pow = (pow * 31) % BASE;
        }

        int targetCode = 0;
        for (int i = 0; i < m; i++) {
            targetCode = (targetCode * 31 + target.charAt(i) - 'a') % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {

            hashCode = (hashCode * 31 + source.charAt(i) - 'a') % BASE;
            if (i < m - 1) {
                continue;
            }

            if (i >= m) {
                hashCode = hashCode - ((source.charAt(i - m) - 'a') * pow) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            if (hashCode == targetCode) {
                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}
