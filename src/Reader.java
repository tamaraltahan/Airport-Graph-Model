import java.io.*;
import java.util.*;

public class Reader {

    private static final String AIRPORTS = "C:\\Users\\Tamar\\Downloads\\P4Airports.txt";
    private static final String FLIGHTS = "C:\\Users\\Tamar\\Downloads\\P4Flights.txt";

    private static List<Node> nodeList = new ArrayList<>();
    private static List<Edge> edgeList = new ArrayList<>();
    private static HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    private static int lines = 0;

    public static List readAirPorts() {
        read(AIRPORTS);
        return nodeList;
    }

    public static List readFlights() {
        read(FLIGHTS);
        return nodeList;
    }

    private static void read(String FILENAME) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                lines++;
            }

            while ((sCurrentLine = br.readLine()) != null) {
                String[] line = sCurrentLine.split("\\s+");
                if (FILENAME.equals(AIRPORTS)) {

                    int index = Integer.parseInt(line[1]);
                    String code = line[2];
                    String name = line[3];

                    Node node = new Node(index, code, name);
                    nodeList.add(node);
                    nodeHashMap.put(index, node);

                } else {
                    Node from = nodeHashMap.get(line[1]);
                    Node to = nodeHashMap.get(line[2]);
                    double cost = Double.parseDouble(line[3]);
                    edgeList.add(new Edge(from, to, cost));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static AdjacencyMatrixGraph createGraph() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(lines);
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            graph.addEdge(edge.getStart(), edge.getEnd(), edge.getCost());
        }
        return graph;
    }

    public static List getNodeList() {
        return nodeList;
    }

    public static List getEdgeList() {
        return edgeList;
    }

    public static HashMap getNodeHashMap() {
        return nodeHashMap;
    }
}