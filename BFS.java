import java.util.*;

public class BFS {

    private int vertices;
    private List<List<Integer>> adjList;

    BFS(int v) {
        vertices = v;
        adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    void bfs(int start) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        BFS graph = new BFS(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("BFS Traversal:");
        graph.bfs(0);
    }
}
