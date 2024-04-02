import java.util.ArrayList;

public class Graph {
    protected int vertices;
    protected ArrayList<Edge> edges;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int dest, int weight) {
        edges.add(new Edge(source, dest, weight));
    }

    public boolean isContinuousGraph() {
        boolean[] visited = new boolean[vertices];
        dfs(0, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (Edge edge : edges) {
            if (edge.source == vertex && !visited[edge.dest]) {
                dfs(edge.dest, visited);
            }
        }
    }
}
