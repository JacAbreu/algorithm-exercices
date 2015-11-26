package me.jacquelineabreu.algorithms;

import java.util.*;

public class Graph {

    private final HashMap<Integer, List<Integer>> nodes = new HashMap<>();

    public void addNode(int node, List<Integer> connections) {
        nodes.put(node, connections);
    }

    public List<Integer> findPath(int source, int dest) {

        Map<Integer, Integer> parent = bfs(source);

        return makePath(source, dest, parent);
    }

    private ArrayList<Integer> makePath(int source, int dest, Map<Integer, Integer> parent) {
        ArrayList<Integer> path = new ArrayList<>();

        Integer node = dest;

        while (node != null) {
            path.add(node);
            node = parent.get(node);
        }

        Collections.reverse(path);

        if (!(path.contains(source) && path.contains(dest))) {
            path = new ArrayList<Integer>();
        }
        return path;
    }

    private Map<Integer, Integer> bfs(int source) {

        Deque<Integer> adjacents = new ArrayDeque<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        distance.put(source, 0);
        adjacents.addLast(source);

        while (!adjacents.isEmpty()) {
            Integer node = adjacents.pollFirst();
            List<Integer> neighbors = nodes.get(node);
            if (neighbors != null) {
                for (Integer other : neighbors) {
                    if (!distance.containsKey(other)) {
                        distance.put(other, (distance.get(node) + 1));
                        parent.put(other, node);
                        adjacents.addLast(other);
                    }
                }
            }
        }
        return parent;
    }

}
