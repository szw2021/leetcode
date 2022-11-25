package hot23;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List list = map.getOrDefault(new String(chars), new ArrayList<String>());
            list.add(str);
            map.put(new String(chars), list);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }
}
