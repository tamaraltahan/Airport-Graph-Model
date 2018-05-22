import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AdjacencyMatrixGraph {

    private int vertices;
    private Edge[][] matrix;


   private List<Node> nodeList;
   private List<Edge> edgeList;
   private HashMap<Integer, Node> nodeHashMap;
   private HashMap<String,Node> codeHashMap;


    AdjacencyMatrixGraph(int v, List nodes, List edges, HashMap nodeMap, HashMap codeMap) {
        vertices = v;
        nodeList = nodes;
        edgeList = edges;
        nodeHashMap = nodeMap;
        codeHashMap = codeMap;
        matrix = new Edge[v][v];
    }


    public void addEdge(Node i, Node j, double weight) {
        matrix[i.getIndex()][j.getIndex()] = new Edge(i, j, weight);
    }

    public void removeEdge(int i, int j) {
        matrix[i][j] = null;
    }

    public boolean hasEdge(int i, int j) {
        return matrix[i][j] != null;
    }


    List<Integer> outEdges(int i) {
        List<Integer> edges = new ArrayList<>();
        for (int j = 0; j < matrix.length; j++)
            if (matrix[i][j] != null) edges.add(j);
        return edges;
    }

    List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<>();
        for (int j = 0; j < matrix.length; j++)
            if (matrix[j][i] != null) edges.add(j);
        return edges;
    }


    public void displayAllAirportInfo(List<Node> nodeList) {
        System.out.println("Airport Index:\tAirport Code:\tAirport Name:");
        for (int i = 0; i < nodeList.size(); i++) {
            Node port = nodeList.get(i);
            System.out.println(port.getIndex() + "\t" + port.getCode() + "\t" + port.getName());
        }
    }

    public void displayAirportInfo(String code){
        if(nodeHashMap.containsKey(code)){
            Node port = nodeHashMap.get(code);
            System.out.println("Airport Index: " + port.getIndex() + "Airport Code: " + port.getCode() + "Airport name: " +  port.getName());
        }
        else{
            System.out.println("Airport not found.");
        }
    }


    //todo: literally all of this shit

    ////////Quarantine CHAMBER//////////////
    private int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < vertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    private void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i +" tt "+ dist[i]);
    }

    void dijkstra(Node src) {
        int dist[] = new int[vertices];
        Boolean sptSet[] = new Boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src.getIndex()] = 0;
        for (int count = 0; count < vertices-1; count++){
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < vertices; v++)
                if (!sptSet[v] && matrix[u][v]!= null &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + matrix[u][v].getStart().getIndex() < dist[v]) //def gonna be problems here
                    dist[v] = dist[u] + matrix[u][v].getStart().getIndex();     //and here too
                                                                                //added .getstart.getindex
        }
        printSolution(dist, vertices);
    }

    public Edge cheapestRoute(String a, String b){
        if(!codeHashMap.containsKey(a) || !codeHashMap.containsKey(b)){
            System.out.println("Invalid input");
            return null;
        }
        else{

        }
    }

    public Edge cheapestRoundTrip(Node i, Node j){

    }

    public Edge fewestStops(Node i, Node j){ //DFS I think?

    }

    public void allFlightsTo(Node start, Node end){

    }

    public void visitAll(Node start){

    }

    public void addAirport(int index, String code, String name){
        Node node = new Node(index,code,name);
        nodeList.add(node);
    }

    public void displayGraph(){

    }

}
