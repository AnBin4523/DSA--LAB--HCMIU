import java.util.List;

public class MapApp {
    public static void main(String[] args) throws Exception {
        Graph graph = buildGraph();

        Node start = graph.getNode("A");
        Node end = graph.getNode("K");

        int numberOfPaths = graph.getNumberOfPaths(start, end);
        System.out.println("Number of paths from A to K: " + numberOfPaths);

        List<Node> shortestPath = graph.getShortestPath(start, end);
        int shortestCost = graph.calculatePathCost(shortestPath);
        System.out.println("Shortest path from A to K: " + shortestPath + ", cost: " + shortestCost);

        List<Node> longestPath = graph.getLongestPath(start, end);
        int longestCost = graph.calculatePathCost(longestPath);
        System.out.println("Longest path from A to K: " + longestPath + ", cost: " + longestCost);

        // Apply Dijkstra's Algorithm
        // Find the shortest path from A to H
        List<Node> shortestPathAH = graph.dijkstraShortestPath(graph.getNode("A"), graph.getNode("H"));
        System.out.println("Shortest path from A to H: " + shortestPathAH);

        // Find the shortest path from B to J
        List<Node> shortestPathBJ = graph.dijkstraShortestPath(graph.getNode("B"), graph.getNode("J"));
        System.out.println("Shortest path from B to J: " + shortestPathBJ);
    }

    public static Graph buildGraph() {
        Graph graph = new Graph();

        // Create nodes
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node l = new Node("L");
        Node k = new Node("K");
        Node _2 = new Node("2");

        // Add nodes to the graph
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        graph.addNode(i);
        graph.addNode(j);
        graph.addNode(l);
        graph.addNode(k);
        graph.addNode(_2);

        // Add edges to form the graph structure
        graph.addEdge(a, b, 6);
        graph.addEdge(a, _2, 10);
        graph.addEdge(b, _2, 12);
        graph.addEdge(b, c, 11);
        graph.addEdge(b, d, 14);
        graph.addEdge(c, f, 3);
        graph.addEdge(c, _2, 12);
        graph.addEdge(c, e, 6);
        graph.addEdge(d, e, 4);
        graph.addEdge(d, h, 6);
        graph.addEdge(d, k, 15);
        graph.addEdge(e, h, 12);
        graph.addEdge(h, k, 12);
        graph.addEdge(h, f, 16);
        graph.addEdge(h, i, 13);
        graph.addEdge(h, l, 18);
        graph.addEdge(j, k, 9);
        graph.addEdge(j, l, 20);
        graph.addEdge(l, i, 17);
        graph.addEdge(i, f, 6);
        graph.addEdge(f, _2, 8);
        graph.addEdge(i, g, 8);
        graph.addEdge(g, _2, 16);

        return graph;
    }

}
