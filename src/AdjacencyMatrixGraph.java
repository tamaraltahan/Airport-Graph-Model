import java.util.*;

public class AdjacencyMatrixGraph {

    private int vertices;
    private double[][] matrix;

    private List<Node> nodeList;
    private HashMap<Integer, Node> nodeHashMap;
    private HashMap<String, Node> codeHashMap;


    AdjacencyMatrixGraph(int v, List nodes, List<Edge> edges, HashMap nodeMap, HashMap codeMap) {
        vertices = v;
        nodeList = nodes;
        nodeHashMap = nodeMap;
        codeHashMap = codeMap;
        matrix = new double[v][v];
        for (Edge edge : edges) {
            addEdge(edge.getStart(), edge.getEnd(), edge.getCost());
        }
    }

    /**
     * Add flight from airport A to airport B
     *
     * @param a      code for starting destination
     * @param b      code for final destination
     * @param weight price
     */
    public void addFlight(String a, String b, double weight) {
        if (codeHashMap.containsKey(a) && codeHashMap.containsKey(b)) {
            Node n1 = codeHashMap.get(a);
            Node n2 = codeHashMap.get(b);
            addEdge(n1, n2, weight);
        } else {
            System.out.println("Invalid Input");
        }
    }

    private void addEdge(Node i, Node j, double weight) {
        matrix[i.getIndex()][j.getIndex()] = weight;
        i.addAdjacency(j, weight);
    }

    /**
     * remove flight from A to B
     *
     * @param i start
     * @param j finish
     */
    public void removeEdge(String i, String j) {
        if (codeHashMap.containsKey(i) && codeHashMap.containsKey(j)) {
            Node a = codeHashMap.get(i);
            Node b = codeHashMap.get(j);
            matrix[a.getIndex()][b.getIndex()] = 0;
        } else {
            System.out.println("Invalid code entered");
        }
    }

    public boolean hasEdge(int i, int j) {
        return matrix[i][j] > 0;
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
    public double[] dijkstra(Node start) {

        double[] distance = new double[matrix.length];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[start.getIndex()] = 0;

        PriorityQueue<Entry<Double, Node>> PQ = new PriorityQueue<>();

        for (int i = 0; i < nodeList.size(); i++) {
            PQ.offer(new Entry(distance[i], nodeList.get(i)));
        }

        while (!PQ.isEmpty()) {
            Entry<Double, Node> U = PQ.poll();
            List list = U.getValue().getAdjacencies();

            for (int i = 0; i < list.size(); i++) {
                Entry<Double,Node> entry = (Entry<Double, Node>) list.get(i);
                Node node = entry.getValue();
                double weight = entry.getKey();
                double dist = U.getKey() + weight;

                if (dist < distance[node.getIndex()])
                    PQ.remove(node);

                distance[node.getIndex()] = dist;
            }
        }
        return distance;
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
            double[] distances = dijkstra(codeHashMap.get(a));
            for(double D : distances){
                System.out.println(D);
            }

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
