import java.util.List;
import java.util.Scanner;

public class Minimum_Spanning_Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the numbers of vertex : ");
        int V = sc.nextInt();
        System.out.print("Enter the numbers of edges : ");
        int E = sc.nextInt();
        
        Graph graph = new Graph(V, E);
        System.out.println("Enter edges in the  form (u v w) : ");
        for  (int i=0; i<E ;i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);
        }
        if (!graph.isConnected()) {
            System.out.println("The graph is not connected");
            System.exit(0);
        }

        System.out.println("Select Algorithm : ");
        System.out.println("1. Prim's Algorithm");
        System.out.println("2. Kruskal's Algorithm");
        System.out.println("3. Shortest Path Algorithm");
        System.out.println("Enter your choice : ");
        int ch = sc.nextInt();

        List<Edge> mst ;
        switch (ch) {
            case 1:
                mst = graph.primMST();
                break;
            case 2 :
                mst  = graph.kruskalMST();
                break;
            case 3 : 
                // mst = graph.
            default:
                System.out.println("Invalid choice. Please enter again.");
                return;
        }
        System.out.println("Minimum Spanning Tree : ");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
            
        }

    }
    
}
