package jianzhi38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    boolean[] flag;
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        flag = new boolean[chars.length];
        Arrays.sort(chars);
        dfs(chars, 0, flag, new ArrayList<>());
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] chars, int index, boolean[] flag, List<Character> c) {

        if (chars.length == c.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(c.get(i));
            }
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && flag[i - 1] == true) {
                continue;
            }
            c.add(chars[i]);
            flag[i] = true;
            dfs(chars, i + 1, flag, c);
            flag[i] = false;
            c.remove(c.size() - 1);
        }

    }
}