import java.util.*;

public class DFS {

    private int vertices;
    private List<List<Integer>> adjList;

    DFS(int v) {
        vertices = v;
        adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    void dfsUtil(int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {

            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    void dfs(int start) {

        boolean[] visited = new boolean[vertices];

        dfsUtil(start, visited);
    }

    public static void main(String[] args) {

        DFS graph = new DFS(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("DFS Traversal:");
        graph.dfs(0);
    }
}
