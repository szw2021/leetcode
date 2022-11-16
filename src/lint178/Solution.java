package lint178;

import java.util.*;

public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n - 1 != edges.length) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> graph = initGraph(n, edges);
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.add(neighbor);
            }
        }
        return (set.size() == n);

    }

    private HashMap<Integer, HashSet<Integer>> initGraph(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return map;
    }
}
