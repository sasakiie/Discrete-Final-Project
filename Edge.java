import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Edge {
    int src , dest , weight;

    public Edge(int scr , int dest , int weight){
        this.src = scr ;
        this.dest = dest ;
        this.weight = weight ;
    }
    
}

class Graph{
    int V , E ;
    List<Edge>edges;

    public Graph(int  V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }

    public void addEdge(int src , int dest , int weight ){
        edges.add(new Edge(src , dest , weight));
    }

    //check  if the graph is connected or not
    public boolean isConnected(){
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        DFS(0, visited);

        //check  if all vertices are visited or not
        for(int i = 0; i<V ;i++){
            if(!visited[i]) return false;
        }
        return true;

        
    }

    //Depth First Search
    private void DFS(int v ,boolean[] visited){
        visited[v] = true;
        for (Edge edge : edges) {
            if (edge.src == v && !visited[edge.dest]) {
                DFS(edge.dest, visited);
            }
            else if(edge.dest == v &&  !visited[edge.src]){
                DFS(edge.src, visited);
            } 
        }
    }

    //Kruskal's algorithm
    public List<Edge> kruskalMST(){
        List<Edge> mst = new ArrayList<>();
        //sort edges by weight
        edges.sort(Comparator.comparingInt(o -> o.weight));

        DisjointSet ds = new DisjointSet(V);
        
        for (Edge edge : edges) {
            int srcSet = ds.find(edge.src);
            int destSet = ds.find(edge.dest);

            if (srcSet != destSet) {
                mst.add(edge);
                ds.union(srcSet , destSet);
            }
        }
        return  mst;
    }

    //Prim's Algorithm
    public List<Edge> primMST(){
        List<Edge> mst = new ArrayList<>();
        boolean [] visited = new boolean[V];
        int [] key = new int[V];
        int [] parent = new int[V];
        Arrays.fill(visited,false);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0; //start from vertex 0

        for (int i = 0; i < V-1; i++) {
            int u = minKey(key,visited);
            visited[u] = true;

            for(Edge edge : edges){
                if ((edge.src == u || edge.dest == u) && !visited[edge.dest]) {
                    int v = (edge.src == u ) ? edge.dest : edge.src;
                    if (edge.weight < key[v]) {
                        parent[v] = u;
                        key[v] = edge.weight;
                    }
                    
                }
            }
        }
        
        //construct mst
        for (int i = 0; i < V; i++) {
            mst.add(new Edge(parent[i], i, key[i]));
        }
        return mst;
    }
    private int minKey(int []key , boolean []visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v=0;v<V;v++){
            if (!visited[v] && key[v]<min){
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    
}

class DisjointSet{
    int  [] parent , rank ;
    
    public DisjointSet(int n ){
        parent = new int [n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            makeSet(i);
        }
    }

    private void makeSet(int v){
        parent[v] = v ;
        rank[v] = 0;
    }

    public int find(int v){
        if (v != parent[v]) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    public void union(int u , int v){
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            }
            else if(rank[rootU] < rank[rootV]){
                parent[rootU] = rootV;
            }
            else{
                parent[rootV] = rootU;
                rank[rootU]++;
            }          
        }

    }
}
