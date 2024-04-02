public class Prim extends Graph {
    public Prim(int vertices) {
        super(vertices);
    }
    //prim algorithm
    public void primMethod() {
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
            char u = (char) ('A' + parent[i]);
            char v = (char) ('A' + i);
            System.out.println(u + " - " + v + "\t" + getEdgeWeight(parent[i], i));
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
}
