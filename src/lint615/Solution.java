package lint615;

import java.util.*;

public class Solution {
    /**
     * @param numCourses:    a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    //todo
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
//        HashMap<Integer, Integer> map = new HashMap<>();
//        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
//        Set<Integer> courseSet = new HashSet<>();
//        for (int i = 0; i < numCourses; i++) {
//            preMap.put(i, new LinkedList<>());
//        }
//        for (int[] pre : prerequisites) {
//            int a = pre[0];
//            int b = pre[1];
//            courseSet.add(a);
//            courseSet.add(b);
//            if (map.containsKey(a)) {
//                map.put(a, map.get(a) + 1);
//            } else {
//                map.put(a, 1);
//            }
//            preMap.get(b).add(a);
//        }
//        List<Integer> res = new ArrayList<>();
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        for (int c : courseSet) {
//            if (!map.containsKey(c)) {
//                res.add(c);
//                queue.add(c);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int course = queue.poll();
//            for (int c : preMap.get(course)) {
//                System.out.println(map.get(c));
//                map.put(c, map.get(c) - 1);//wocaole
//                System.out.println(map.get(c));
//                if (map.get(c) == 0) {
//                    res.add(c);
//                    queue.add(c);
//                }
//            }
//        }
//        return res.size() == courseSet.size();

        List<List<Integer>> edges = new ArrayList<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            count++;
            for(int nei : edges.get(c)) {
                degree[nei]--;
                if (degree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int[][] course = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        boolean b = canFinish(10, course);
        System.out.println(b);
    }
}
