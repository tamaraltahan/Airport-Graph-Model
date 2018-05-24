import java.io.*;
import java.util.*;

public class Reader {

    //private  final String AIRPORTS = "C:\\Users\\Tamar\\Downloads\\P4Airports.txt";
    //private  final String FLIGHTS = "C:\\Users\\Tamar\\Downloads\\P4Flights.txt";

    private  final String AIRPORTS = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\P4Airports.txt";
    private  final String FLIGHTS = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\P4Flights.txt";

    private  List<Node> nodeList = new ArrayList<>();
    private  List<Edge> edgeList = new ArrayList<>();
    private  HashMap<Integer, Node> nodeHashMap = new HashMap<>();
    private  HashMap<String,Node> codeMap = new HashMap<>();

    private  int lines = 0;

    public  List readAirPorts() {
        read(AIRPORTS);
        return nodeList;
    }

    public  List readFlights() {
        read(FLIGHTS);
        return edgeList;
    }

    private  void read(String FILENAME) {
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
                    codeMap.put(code,node);

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

    public  AdjacencyMatrixGraph createGraph() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(lines,nodeList,edgeList,nodeHashMap,codeMap);
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            graph.addEdge(edge.getStart(), edge.getEnd(), edge.getCost());
        }
        return graph;
    }

    public  List getNodeList() {
        return nodeList;
    }
    public  List getEdgeList() {
        return edgeList;
    }
    public  HashMap getNodeHashMap() {
        return nodeHashMap;
    }
    public  HashMap getCodeMap(){ return codeMap; }


}