import java.util.Scanner;

public class Minimum_Spanning_Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select algorithm : \n\t 1. Prim's Algorithm \n\t 2. Kruskal's Algorithm \n\t 3. Shortest Path \n\t 4. Automata ");
        System.out.print("Enter your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter number of vertices: ");
                int vertices_case1 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case1 = scanner.nextInt();
                Prim prim = new Prim(vertices_case1);
                for(int i = 0; i < edgesCount_case1; i++){
                    System.out.print("Enter edge " + (i + 1) + " details (source dest weight): ");
                    String source = scanner.next();
                    String dest = scanner.next();
                    int weight = scanner.nextInt();

                    // แปลง source และ dest เป็นตัวเลข
                    int sourceIndex = source.charAt(0) - 'A';
                    int destIndex = dest.charAt(0) - 'A';

                    prim.addEdge(sourceIndex, destIndex, weight);
                }

                if (prim.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.println();
                    prim.primMethod();
                }
                else{
                    System.out.println("The graph is not a connected graph.");
                }
                break;

            case 2:
                System.out.print("Enter number of vertices: ");
                int vertices_case2 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case2 = scanner.nextInt();
                Kruskal kruskal = new Kruskal(vertices_case2);
                for(int i = 0; i < edgesCount_case2; i++){
                    System.out.print("Enter edge " + (i + 1) + " details (source dest weight): ");
                    String source = scanner.next();
                    String dest = scanner.next();
                    int weight = scanner.nextInt();

                    // แปลง source และ dest เป็นตัวเลข
                    int sourceIndex = source.charAt(0) - 'A';
                    int destIndex = dest.charAt(0) - 'A';

                    kruskal.addEdge(sourceIndex, destIndex, weight);
                }

                if (kruskal.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.println();
                    kruskal.kruskalMethod();
                }
                else{
                    System.out.println("The graph is not a connected graph.");
                }
                break;

            case 3:
                System.out.print("Enter number of vertices: ");
                int vertices_case3 = scanner.nextInt();
                System.out.print("Enter number of edges: ");
                int edgesCount_case3 = scanner.nextInt();
                Shortestpath stp = new Shortestpath(vertices_case3);
                for(int i = 0; i < edgesCount_case3; i++){
                    System.out.print("Enter edge " + (i + 1) + " details (source dest weight): ");
                    String source = scanner.next();
                    String dest = scanner.next();
                    int weight = scanner.nextInt();

                    // แปลง source และ dest เป็นตัวเลข
                    int sourceIndex = source.charAt(0) - 'A';
                    int destIndex = dest.charAt(0) - 'A';

                    stp.addEdge(sourceIndex, destIndex, weight);
                }

                if (stp.isContinuousGraph()) {
                    System.out.println("The graph is a connected graph.");
                    System.out.print("Enter starting vertex (A-Z): ");
                    char startVertex = scanner.next().charAt(0);
                    stp.shortestPathFromVertex(startVertex);
                }
                else{
                    System.out.println("The graph is not a connected graph.");
                }
                break;
            case 4:
                Scanner Scanner = new Scanner(System.in);
                System.out.println("Enter the Automata Input : ");
                String input = Scanner.nextLine();

                Automata atm = new Automata();
                atm.processInput(input);
                if (atm.isAccepted()) {
                    System.out.println("Accepted!");
                }
                else{
                    System.out.println("Rejected!");
                }
                break;
                
           
            default:
                System.out.println("Invalid choice.");
            }
    //     System.out.print("Enter number of vertices: ");
    //     int vertices = scanner.nextInt();

    //     System.out.print("Enter number of edges: ");
    //     int edgesCount = scanner.nextInt();

    //     Graph graph = new Graph(vertices);

    //     for (int i = 0; i < edgesCount; i++) {
    //         System.out.print("Enter edge " + (i + 1) + " details (source dest weight): ");
    //         String source = scanner.next();
    //         String dest = scanner.next();
    //         int weight = scanner.nextInt();

    //         // แปลง source และ dest เป็นตัวเลข
    //         int sourceIndex = source.charAt(0) - 'A';
    //         int destIndex = dest.charAt(0) - 'A';

    //         graph.addEdge(sourceIndex, destIndex, weight);
    //     }

    //     if (graph.isContinuousGraph()) {
    //         System.out.println("The graph is a connected graph.");
    //         System.out.println();

    //         // เพิ่ม switch case เพื่อให้ผู้ใช้เลือกใช้ Algorithm
    //         System.out.println("Select algorithm : \n\t 1. Prim's Algorithm \n\t 2. Kruskal's Algorithm \n\t 3. Shortest Path \n\t 4. Automata ");
            
    //         System.out.print("Enter your choice : ");

            
    //         switch (choice) {
    //             case 1:
    //                 graph.prim();
    //                 break;
    //             case 2:
    //                 graph.kruskal();
    //                 break;
    //             case 3:
    //                 System.out.print("Enter starting vertex (A-Z): ");
    //                 char startVertex = scanner.next().charAt(0);
    //                 graph.shortestPathFromVertex(startVertex);
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice.");
    //         }
    //     } else {
    //         System.out.println("The graph is not a connected graph.");
    //     }

        scanner.close();
    }
    
}
