import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {

    private static final String AIRPORTS = "C:\\Users\\Tamar\\Downloads\\P4Airports.txt";
    private static final String FLIGHTS = "C:\\Users\\Tamar\\Downloads\\P4Flights.txt";


   private static List<Node> nodeList = new ArrayList<>();
   private static List<Edge> edgeList = new ArrayList<>();

    public static List readAirPorts(){
        read(AIRPORTS);
        return nodeList;
    }

    public static List readFlights(){
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

            int lines = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                lines++;
            }

            while ((sCurrentLine = br.readLine()) != null) {
                String[] line = sCurrentLine.split("\\s+");
                if(FILENAME.equals(AIRPORTS)) {
                    for (int i = 0; i < line.length; i++) {
                        nodeList.add(new Node(Integer.parseInt(line[0]), line[1], line[2]));
                    }
                }
                else{
                    for(int i = 0; i < line.length; i++){
                        //wtf do i do with this data
                        int from = Integer.parseInt(line[0]);
                        int to = Integer.parseInt(line[1]);
                        double cost = Double.parseDouble(line[2]);
                        edgeList.add(new Edge(from,to,cost));
                    }
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

}