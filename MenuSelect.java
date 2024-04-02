import java.util.Scanner;

public class MenuSelect {
    private static String source;
    private static String dest;
    private static int weight;
    private static int sourceIndex;
    private static int destIndex;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Select algorithm : \n\t 1. Prim's Algorithm \n\t 2. Kruskal's Algorithm \n\t 3. Shortest Path \n\t 4. Finite-State Automata ");
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter number of vertices: ");
                int vertices_case1 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case1 = scanner.nextInt();
                Prim prim = new Prim(vertices_case1);
                for (int i = 0; i < edgesCount_case1; i++) {
                    edgeInput(i+1);
                    prim.addEdge(sourceIndex, destIndex, weight);
                }

                if (prim.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.println();
                    prim.primMethod();
                } else {
                    System.out.println("The graph is not a connected graph.");
                }
                break;

            case 2:
                System.out.print("Enter number of vertices: ");
                int vertices_case2 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case2 = scanner.nextInt();
                Kruskal kruskal = new Kruskal(vertices_case2);
                for (int i = 0; i < edgesCount_case2; i++) {
                    edgeInput(i+1);
                    kruskal.addEdge(sourceIndex, destIndex, weight);
                }

                if (kruskal.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.println();
                    kruskal.kruskalMethod();
                } else {
                    System.out.println("The graph is not a connected graph.");
                }
                break;

            case 3:
                System.out.print("Enter number of vertices: ");
                int vertices_case3 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case3 = scanner.nextInt();
                Shortestpath stp = new Shortestpath(vertices_case3);
                for (int i = 0; i < edgesCount_case3; i++) {
                    edgeInput(i+1);
                    stp.addEdge(sourceIndex, destIndex, weight);
                }

                if (stp.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.print("Enter starting vertex (A-Z): ");
                    char startVertex = scanner.next().charAt(0);
                    stp.shortestPathFromVertex(startVertex);
                } else {
                    System.out.println("The graph is not a connected graph.");
                }
                break;
                
            case 4:
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the Automata Input (using 1 or 0 ex.110101): ");
                String input = sc.nextLine();

                Automata atm = new Automata();
                atm.processInput(input);
                if (atm.isAccepted()) {
                    System.out.println("Accepted!");
                } else {
                    System.out.println("Rejected!");
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }

    public static void edgeInput(int i) {
        System.out.print("Enter edge " + i + " details -> source dest weight (using A-Z ex.A G 5): ");
        source = scanner.next();
        dest = scanner.next();
        weight = scanner.nextInt();

        sourceIndex = source.charAt(0) - 'A';
        destIndex = dest.charAt(0) - 'A';
    }

}
