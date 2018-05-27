import java.io.*;
import java.util.*;

public class Reader {

    private final String AIRPORTS = "C:\\Users\\Tamar\\Downloads\\P4Airports.txt";
    private final String FLIGHTS = "C:\\Users\\Tamar\\Downloads\\P4Flights.txt";

//    private  final String AIRPORTS = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\P4Airports.txt";
//    private  final String FLIGHTS = "C:\\Users\\tamar\\Desktop\\stuff\\CS stuff\\P4Flights.txt";

    private List<Node> nodeList = new ArrayList<>();
    private List<Edge> edgeList = new ArrayList<>();
    private HashMap<Integer, Node> indexHashMap = new HashMap<>();
    private HashMap<String, Node> codeMap = new HashMap<>();


    Reader(){
        readAirPorts();
        readFlights();
    }

    public List readAirPorts() {
        read(AIRPORTS);
        return nodeList;
    }

    public List readFlights() {
        read(FLIGHTS);
        return edgeList;
    }

    private void read(String FILENAME) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                //if reading airport file
                //airports act as vertices in the graph
                //put them into a list
                if (FILENAME.equals(AIRPORTS)) {
                    String[] line = sCurrentLine.split("\\s+");
                    int index = Integer.parseInt(line[1]);
                    String code = line[2];

                    String name = "";
                    if(line.length > 3)
                    for(int i = 3; i < line.length; i++){
                        name += line[i] + " ";
                    }
                    else
                        name = line[3];

                    Node node = new Node(index, code, name);
                    nodeList.add(node);
                    indexHashMap.put(index, node);
                    codeMap.put(code, node);

                } else {
                    String[] line = sCurrentLine.split("\\s+");
                    Node to = indexHashMap.get(Integer.parseInt(line[2]));
                    double cost = Double.parseDouble(line[3]);
                    edgeList.add(new Edge(to, cost));
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
        System.out.println();
    }

    public AdjacencyMatrixGraph createGraph() {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(nodeList, edgeList, codeMap);
        return graph;
    }


}