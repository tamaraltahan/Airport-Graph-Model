import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyMatrixGraph {

    private int vertices;
    private Edge[][] matrix;


    List<Node> nodeList = new ArrayList<>();
    List<Edge> edgeList = new ArrayList<>();
    HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    AdjacencyMatrixGraph(int v) {
        vertices = v;
        matrix = new Edge[v][v];
    }


    void addEdge(Node i, Node j, double weight) {
        matrix[i.getIndex()][j.getIndex()] = new Edge(i, j, weight);
    }

    void removeEdge(int i, int j) {
        matrix[i][j] = null;
    }

    boolean hasEdge(int i, int j) {
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

    //todo: literally all of this shit


    public void displayAirportInfo(String code){
        if(nodeHashMap.containsKey(code)){

            System.out.println();
        }
    }

    public Edge cheapestRoute(Node i, Node j){

    }

    public Edge cheapestRoundTrip(Node i, node j){

    }

    public Edge fewestStops(Node i, Node j){

    }

    public void allFlightsTo(Node start, Node end){

    }

    public void visitAll(Node start){

    }

    public void addAirport(Node n){

    }

    public void displayGraph(){

    }

}
