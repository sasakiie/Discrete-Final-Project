import java.util.ArrayList;
import java.util.Comparator;

public class Kruskal extends Graph {
    // kruskal

    public Kruskal(int vertices) {
        super(vertices);
    }

    public void kruskalMethod() {
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

        printMST(result);
    }

    public void printMST(ArrayList<Edge> result) {
        System.out.println("Edge \tWeight");
        for (Edge edge : result) {
            char u = (char) ('A' + edge.source);
            char v = (char) ('A' + edge.dest);
            System.out.println(u + " - " + v + "\t" + edge.weight);
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
}
