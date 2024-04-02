import java.util.HashMap;
import java.util.Map;

public class Shortestpath  extends Graph{
    public Shortestpath(int vertices) {
        super(vertices);
        //TODO Auto-generated constructor stub
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
