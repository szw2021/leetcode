package lint605;

import java.util.*;

public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
//        if (org.length == 0 && seqs.length == 0) {
//            return true;
//        }
//        int num = org.length;
//        int[] degree = new int[num + 1];
//        List<List<Integer>> edges = new ArrayList<>();
//        for (int i = 0; i <= num; i++) {
//            edges.add(new ArrayList<>());
//        }
//
//        int  n = seqs.length;
//        for (int i = 0; i < n; i++) {
//            degree[seqs[i][1]]++;
//            edges.get(seqs[i][0]).add(seqs[i][1]);
//        }
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int i = 1; i <= n; i++) {
//            if (degree[i] == 0) {
//                queue.add(i);
//            }
//        }
//
//        int[] res = new int[num];
//        int index = 0;
//        while (!queue.isEmpty()) {
//            if (queue.size() > 1) {
//                return false;
//            }
//            int a = queue.poll();
//            res[index++] = a;
//            for (int nei : edges.get(a)) {
//                degree[nei]--;
//                if (degree[nei] == 0) {
//                    queue.add(nei);
//                }
//            }
//        }
//        for (int i = 0; i < num; i++) {
//            if (res[i] != org[i]) {
//                return false;
//            }
//        }
//
//        return true;
        Map<Integer, Set<Integer>> graph = buildGraph(seqs);
        Map<Integer, Integer> inDgrees = getIndegrees(seqs, graph);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int i : inDgrees.keySet()) {
            if (inDgrees.get(i) == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }

            int i = queue.poll();
            res.add(i);

            for (int next : graph.get(i)) {
                inDgrees.put(next, inDgrees.get(next) - 1);
                if (inDgrees.get(next) == 0) {
                    queue.offer(next);
                }
            }

            if (res.size() != org.length) {
                return false;
            }

            for (int j = 0; j < org.length; j++) {
                if (org[j] != res.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Integer, Integer> getIndegrees(int[][] seqs, Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length; j++) {
                inDegrees.put(seqs[i][j], 0);
            }
        }
        for (int i : graph.keySet()) {
            for (int nei : graph.get(i)) {
                inDegrees.put(nei, inDegrees.get(nei) + 1);
            }
        }
        return inDegrees;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < seqs.length; i++) {
            for (int j = 0; j < seqs[i].length - 1; j++) {
                if (!graph.containsKey(seqs[i][j])) {
                    Set<Integer> set = new HashSet<>();
                    set.add(seqs[i][j + 1]);
                    graph.put(seqs[i][j], set);
                } else {
                    graph.get(seqs[i][j]).add(seqs[i][j + 1]);
                }
            }
        }
        return graph;
    }
}
