import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getName(), node);
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public void addEdge(Node source, Node destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        source.addEdge(edge);
        destination.addEdge(edge);
    }

    public Edge getEdge(Node source, Node destination) {
        for (Edge edge : source.getEdges()) {
            if (edge.getDestination().equals(destination)) {
                return edge;
            }
        }
        return null;
    }

    public List<List<Node>> findPaths(Node start, Node end) {
        List<List<Node>> paths = new ArrayList<>();
        List<Node> currentPath = new ArrayList<>();
        currentPath.add(start);
        findPathsDFS(start, end, currentPath, paths);
        return paths;
    }

    private void findPathsDFS(Node current, Node end, List<Node> currentPath, List<List<Node>> paths) {
        if (current == end) {
            paths.add(new ArrayList<>(currentPath)); // Add a copy of the path
            return;
        }

        for (Edge edge : current.getEdges()) {
            Node neighbor = edge.getDestination();
            if (!currentPath.contains(neighbor)) {
                currentPath.add(neighbor);
                findPathsDFS(neighbor, end, currentPath, paths);
                currentPath.remove(currentPath.size() - 1); // Backtrack
            }
        }
    }

    public int calculatePathCost(List<Node> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node source = path.get(i);
            Node destination = path.get(i + 1);
            Edge edge = getEdge(source, destination);
            cost += edge.getWeight();
        }
        return cost;
    }

    public int getNumberOfPaths(Node start, Node end) {
        List<List<Node>> paths = findPaths(start, end);
        return paths.size();
    }

    public List<Node> getShortestPath(Node start, Node end) {
        List<List<Node>> paths = findPaths(start, end);
        List<Node> shortestPath = null;
        int shortestCost = Integer.MAX_VALUE;

        for (List<Node> path : paths) {
            int pathCost = calculatePathCost(path);
            if (pathCost < shortestCost) {
                shortestPath = path;
                shortestCost = pathCost;
            }
        }
        return shortestPath;
    }

    public List<Node> getLongestPath(Node start, Node end) {
        List<List<Node>> paths = findPaths(start, end);
        List<Node> longestPath = null;
        int longestCost = 0;

        for (List<Node> path : paths) {
            int pathCost = calculatePathCost(path);
            if (path.size() > longestCost) {
                longestPath = path;
                longestCost = pathCost;
            }
        }
        return longestPath;
    }

    public List<Node> dijkstraShortestPath(Node start, Node end) {
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node, Node> predecessor = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distance::get));

        // Initialize distances
        for (Node node : nodes.values()) {
            distance.put(node, Integer.MAX_VALUE);
            predecessor.put(node, null);
        }
        distance.put(start, 0);

        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Edge edge : current.getEdges()) {
                Node neighbor = edge.getDestination();
                int newDistance = distance.get(current) + edge.getWeight();

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    predecessor.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Reconstruct the path
        List<Node> path = new ArrayList<>();
        Node current = end;
        while (current != null) {
            path.add(current);
            current = predecessor.get(current);
        }
        Collections.reverse(path);

        return path;
    }
}
