import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adj;

    Graph(int v) {
        vertices = v;
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}

public class BFSProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices, edges, source;

        System.out.println("--- BFS Implementation ---");
        System.out.print("Enter number of vertices: ");
        vertices = sc.nextInt();

        Graph g = new Graph(vertices);

        System.out.print("Enter number of edges: ");
        edges = sc.nextInt();

        System.out.println("Enter " + edges + " edges (Source Destination):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u < vertices && v < vertices && u >= 0 && v >= 0) {
                g.addEdge(u, v);
            } else {
                System.out.println("Error: Vertex index out of range (0 to " + (vertices - 1) + ")");
                i--;
            }
        }

        System.out.print("\nEnter starting vertex for BFS: ");
        source = sc.nextInt();

        if (source >= 0 && source < vertices) {
            g.BFS(source);
        } else {
            System.out.println("Invalid starting vertex.");
        }

        sc.close();
    }
}
