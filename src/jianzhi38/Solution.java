package jianzhi38;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] flag;
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        flag = new boolean[chars.length];
        dfs(chars, 0, flag, "");
    }

    private void dfs(char[] chars, int index, boolean[] flag, List<Character> c) {

        if (chars.length == c.size()) {
            list.add(new String(c.toString()));
            return;
        }

        c.add(chars[index]);
        flag[index] = true;
        for (int i = index; i < chars.length; i++) {
            if (flag[i] == false) {
                dfs(chars, );
            }
        }
        flag[index] = false;
        c.remove(c.size() - 1);

    }
}
