
import java.util.Scanner;

public class Minimum_Spanning_Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int edgesCount = scanner.nextInt();

        Graph graph = new Graph(vertices);

        for (int i = 0; i < edgesCount; i++) {
            System.out.print("Enter edge " + (i + 1) + " details (source dest weight): ");
            String source = scanner.next();
            String dest = scanner.next();
            int weight = scanner.nextInt();

            // แปลง source และ dest เป็นตัวเลข
            int sourceIndex = source.charAt(0) - 'A';
            int destIndex = dest.charAt(0) - 'A';

            graph.addEdge(sourceIndex, destIndex, weight);
        }

        if (graph.isContinuousGraph()) {
            System.out.println("The graph is a connected graph.");

            // เพิ่ม switch case เพื่อให้ผู้ใช้เลือกใช้ Algorithm
            System.out.println("Select algorithm:");
            System.out.println("1. Prim's Algorithm");
            System.out.println("2. Kruskal's Algorithm");
            System.out.println("3. Shortest Path Algorithm");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    graph.prim();
                    break;
                case 2:
                    graph.kruskal();
                    break;
                case 3:
                    System.out.print("Enter starting vertex (A-Z): ");
                    char startVertex = scanner.next().charAt(0);
                    graph.shortestPathFromVertex(startVertex);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("The graph is not a connected graph.");
        }

        scanner.close();
    }
    
}
