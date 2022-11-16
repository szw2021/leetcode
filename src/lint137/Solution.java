package lint137;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        List<UndirectedGraphNode> nodes = findNode(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode gNode : nodes) {
            mapping.put(gNode, new UndirectedGraphNode(gNode.label));
        }
        for (UndirectedGraphNode gNode : nodes) {
            UndirectedGraphNode newNode = mapping.get(gNode);
            for (UndirectedGraphNode neighbor : gNode.neighbors) {
                newNode.neighbors.add(mapping.get(neighbor));
            }
        }
        return mapping.get(node);
    }

    private List<UndirectedGraphNode> findNode(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode graphNode = queue.poll();
            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.add(neighbor);
            }
        }
        return new LinkedList<>(set);
    }
}
