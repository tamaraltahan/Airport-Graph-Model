import java.util.*;

public class Node {

    private List<Node> connections = new ArrayList<>();
    public void addConnection(Node n){
        connections.add(n);
    }
    public List getConnections(){
        return connections;
    }
    public void removeConnection(Node n){
        connections.remove(n);
    }

    private List<Edge> adjacencies = new ArrayList<>();
    public void addAdjacency(Edge edge){
        adjacencies.add(edge);
    }
    public List<Edge> getAdjacencies() {
        return adjacencies;
    }
    public void removeAdjacency(Edge edge){
        adjacencies.remove(edge);
    }

    private final String name;
    private final String code;
    private final int index;


    Node(int index, String code, String name) {
        this.index = index;
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getIndex() {
        return index;
    }

}
