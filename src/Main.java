import java.util.*;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader();
        List ports = reader.readAirPorts();
        List paths = reader.readFlights();

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(ports.size(),ports,paths,reader.getNodeHashMap(),reader.getCodeMap());
        graph.cheapestRoundTrip("LAX","JFK");



    }
}
