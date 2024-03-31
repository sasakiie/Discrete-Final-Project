import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}
class Graph {
    int vertices;
    ArrayList<Edge> edges;

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


    //prim algorithm
    public void prim() {
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];
    
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
    
        key[0] = 0;
        parent[0] = -1;
    
        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
    
            for (Edge edge : edges) {
                if (edge.source == u && !mstSet[edge.dest] && edge.weight < key[edge.dest]) {
                    parent[edge.dest] = u;
                    key[edge.dest] = edge.weight;
                }
            }
        }
    
        printMST(parent);
    }
    
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
    
        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
    
        return minIndex;
    }
    
    private void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + getEdgeWeight(parent[i], i));
        }
    }
    
    private int getEdgeWeight(int u, int v) {
        for (Edge edge : edges) {
            if ((edge.source == u && edge.dest == v) || (edge.source == v && edge.dest == u)) {
                return edge.weight;
            }
        }
        return -1;
    }
    
    //kruskal 

    public void kruskal() {
        ArrayList<Edge> result = new ArrayList<>();
        edges.sort(Comparator.comparingInt(e -> e.weight));
    
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }
    
        int e = 0, i = 0;
        while (e < vertices - 1 && i < edges.size()) {
            Edge nextEdge = edges.get(i++);
            int x = find(parent, nextEdge.source);
            int y = find(parent, nextEdge.dest);
    
            if (x != y) {
                result.add(nextEdge);
                e++;
                union(parent, x, y);
            }
        }
    
        System.out.println("Edge \tWeight");
        for (Edge edge : result) {
            System.out.println(edge.source + " - " + edge.dest + "\t" + edge.weight);
        }
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }
    
    
    //shortest
    public void shortestPathFromVertex(char startVertex) {
        int[][] dist = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (Edge edge : edges) {
            dist[edge.source][edge.dest] = edge.weight;
            dist[edge.dest][edge.source] = edge.weight;
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        Map<Integer, Character> reverseMapping = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            reverseMapping.put(i, (char) ('A' + i));
        }

        System.out.println("Shortest paths from vertex " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            if (reverseMapping.get(i) != startVertex) {
                System.out.println("To vertex " + reverseMapping.get(i) + ": " + dist[startVertex - 'A'][i]);
            }
        }
    }
    


}

