import java.util.*;

public class AdjacencyMatrixGraph {

    private int vertices;
    private Edge[][] matrix;

    private List<Node> nodeList;
    private HashMap<Integer, Node> nodeHashMap;
    private HashMap<String, Node> codeHashMap;


    AdjacencyMatrixGraph(int v, List nodes, List<Edge> edges, HashMap nodeMap, HashMap codeMap) {
        vertices = v;
        nodeList = nodes;
        nodeHashMap = nodeMap;
        codeHashMap = codeMap;
        matrix = new Edge[v][v];

        for(Edge edge : edges){
            addEdge(edge.getStart(),edge.getEnd(),edge.getCost());
        }

    }

    public void addFlight(String a, String b, double weight){
        if(codeHashMap.containsKey(a) && codeHashMap.containsKey(b)){
            Node n1 = codeHashMap.get(a);
            Node n2 = codeHashMap.get(b);
            addEdge(n1,n2,weight);
        }
        else{
            System.out.println("Invalid Input");
        }
    }

    private void addEdge(Node i, Node j, double weight) {
        matrix[i.getIndex()][j.getIndex()] = new Edge(i, j, weight);
    }

    /**
     * remove flight from A to B
     *
     * @param i start
     * @param j finish
     */
    public void removeEdge(String i, String j) {
        try {
            Node a = codeHashMap.get(i);
            Node b = codeHashMap.get(j);
            matrix[a.getIndex()][b.getIndex()] = null;
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
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


    /**
     * Print all airport info (index, code, & name)
     *
     * @param nodeList list of vertices
     */
    public void displayAllAirportInfo(List<Node> nodeList) {
        System.out.println("Airport Index:\tAirport Code:\tAirport Name:");
        for (int i = 0; i < nodeList.size(); i++) {
            Node port = nodeList.get(i);
            System.out.println(port.getIndex() + "\t" + port.getCode() + "\t" + port.getName());
        }
    }

    /**
     * Displays info of an airport from code
     *
     * @param code 3 letter code
     */
    public void displayAirportInfo(String code) {
        if (codeHashMap.containsKey(code)) {
            Node port = codeHashMap.get(code);
            System.out.println("Airport Index: " + port.getIndex() + "\nAirport Code: " + port.getCode() + "\nAirport name: " + port.getName());
        } else {
            System.out.println("Airport not found.");
        }
    }

    //---------------------------------------Dijkstra's Quarantine Chamber-------------------------------------------
    private double dijkstra(Node start, Node end){
        double[] best = new double[matrix.length];
        boolean[] visited = new boolean[matrix.length];
        double max = Double.MAX_VALUE; // Infinity equivalent.
        for (int i = 0; i < matrix.length; i++) {
            best[i] = max;
            visited[i] = false;
        }

        best[start.getIndex()] = start.getIndex(); // Changed the 0 to variable start.

        for(int i = 0; i < matrix.length; i++) {
            Double min = max;
            int currentNode = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (!visited[j] && best[j] < min) {
                    currentNode = j;
                    min = best[j];
                }
            }
            visited[currentNode] = true;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[currentNode][j].getCost() < max && best[currentNode] + matrix[currentNode][j].getCost() < best[j]) {
                    best[j] = best[currentNode] + matrix[currentNode][j].getCost();
                }
            }
        }
        return best[end.getIndex()-1];
    }
    //-----------------------------------------------------------------------------------------------------

    /**
     * Find the cheapest route from airport a to airport b utilizing Dijkstra's algorithm
     *
     * @param a Code for airport A
     * @param b Code for airport B
     */
    public void cheapestRoute(String a, String b) {
        if (!codeHashMap.containsKey(a) || !codeHashMap.containsKey(b)) {
            System.out.println("Airport not found");
            return;
        } else {
            dijkstra(codeHashMap.get(a),codeHashMap.get(b));
        }
    }

    /**
     * Find the cheapest rout from A->B & from B->A (Double Dijkstra)
     *
     * @param a Code for airport A
     * @param b Code for airport B
     */
    public void cheapestRoundTrip(String a, String b) {
        System.out.println(a + " " + b);
        if (!codeHashMap.containsKey(a) || !codeHashMap.containsKey(b)) {
            System.out.println("Invalid input");
            return;
        } else {
            Node n1 = codeHashMap.get(a);
            Node n2 = codeHashMap.get(b);

            dijkstra(n1, n2);
            dijkstra(n2, n1);
        }


    }

    public void allFlightsTo(Node start, Node end) {

    }

    public void visitAll(Node start) {

    }

    public void addAirport(String code, String name) {
        Node node = new Node(matrix.length + 1, code, name);
        nodeList.add(node);
        Edge temp[][] = new Edge[matrix.length + 1][matrix.length + 1];
        System.arraycopy(temp, 0, matrix, 0, temp.length);
    }

    public void displayGraph() {
        System.out.println("Soon :^)");
    }

}
