import java.util.*;

public class AdjacencyMatrixGraph {

    private double[][] matrix;
    private List<Node> nodeList;
    private HashMap<String, Node> codeHashMap;
    private double total = 0;
    private List<Edge> edgeList = new ArrayList<>();


    AdjacencyMatrixGraph(List<Node> nodes, List<Edge> edges, HashMap<String, Node> codeMap) { //takes in a list of all airports (nodes/vertices), a list of all edges, and a hashmap of <Code/Vertex>
        nodeList = nodes;
        codeHashMap = codeMap;
        matrix = new double[nodes.size()][nodes.size()];

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
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
        Edge edge1 = new Edge(j, weight);
        edge1.setFrom(i);
        i.addAdjacency(edge1);
        edgeList.add(edge1);
    }


    /**
     * remove flight from A to B
     *
     * @param i start
     * @param j finish
     */
    public void removeEdge(String i, String j) { //remember to adjust because i fucked with edges and nodes so much
        if (codeHashMap.containsKey(i) && codeHashMap.containsKey(j)) {
            Node a = codeHashMap.get(i);
            Node b = codeHashMap.get(j);
            matrix[a.getIndex()][b.getIndex()] = 0;
            matrix[b.getIndex()][a.getIndex()] = 0;
            a.removeAdjacency(b);
            b.removeAdjacency(a);
        } else {
            System.out.println("Invalid code entered");
        }
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


    public void dijkstra(Node start) {
        for(Node n : nodeList){ //reset per use
            n.setMinDistance(Double.POSITIVE_INFINITY);
            n.setPath(new ArrayList<>());
        }

        start.setMinDistance(0);

        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(start);

        while (!PQ.isEmpty()) {
            Node u = PQ.poll();

            for (Edge neighbour : u.getAdjacencies()) {
                Double newDist = u.getMinDistance() + neighbour.getCost();

                if (neighbour.getEnd().getMinDistance() > newDist) {
                    PQ.remove(neighbour.getEnd());
                    neighbour.getEnd().setMinDistance(newDist);
                    neighbour.getEnd().setPath(new LinkedList<>(u.getPath()));
                    neighbour.getEnd().addPath(u);

                    PQ.add(neighbour.getEnd());
                }
            }
        }
    }
    /**
     * Find the cheapest route from airport a to airport b utilizing Dijkstra's algorithm
     *
     * @param a Code for airport A
     * @param b Code for airport B
     */

    private void printDijkstra(String a, String b) {
        dijkstra(codeHashMap.get(a));
        Node nodeB = codeHashMap.get(b);

        Node v = nodeList.get(nodeB.getIndex());
        total += v.getIndex();
        System.out.print("Starting: " + a + ", Cost: $" + v.getMinDistance() + ", Path: ");
        List<Node> path = v.getPath();
        for (int j = 0; j < path.size(); j++) {
            Node pathvert = path.get(j);
            System.out.print(pathvert.getCode() + " -> ");
        }
        System.out.println(v.getCode());
    }


    /**
     * Gives the cheapest path to get from A to B using Dijkstra's algorithm
     * @param a code for airport A
     * @param b code for airport B
     */
    public void cheapestRoute(String a, String b) {
        if (!codeHashMap.containsKey(a) || !codeHashMap.containsKey(b)) {
            System.out.println("Airport not found");
        } else {
            printDijkstra(a, b);
        }
    }


    /**
     * Find the cheapest rout from A->B & from B->A (Double Dijkstra)
     *
     * @param a Code for airport A
     * @param b Code for airport B
     */
    public void cheapestRoundTrip(String a, String b) {
        cheapestRoute(a, b);
        cheapestRoute(b, a);
        System.out.println("Total: " + total);
        total = 0;//reset for next operation
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
        System.out.println("Matrix Data:");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nVertices Data:\nIndex\tCode\tName");
        for(Node n: nodeList){
            System.out.println(n.getIndex() + "\t   " + n.getCode() + "\t   " + n.getName());
        }

        System.out.println("\nEdge Data:\nStart\tEnd\t  Weight");
        for(Edge edge:edgeList){
            System.out.println(edge.getStart().getCode() + "\t   " + edge.getEnd().getCode() + "\t   " + edge.getCost());
        }
    }
}
