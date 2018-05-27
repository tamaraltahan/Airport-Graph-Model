import java.util.*;

public class Node implements Comparable<Node>{
    private List<Edge> adjacencies = new ArrayList<>();
    private List<Node> path = new LinkedList<>();
    private double minDistance = Double.POSITIVE_INFINITY;
    private Node previous;

    public int compareTo(Node other){
        return Double.compare(minDistance,other.minDistance);
    }

    public void addAdjacency(Edge edge){
        adjacencies.add(edge);
    }
    public List<Edge> getAdjacencies(){
        return adjacencies;
    }

    public List<Node> getPath() {
        return path;
    }
    public void setPath(List<Node> path){
        this.path = path;
    }
    public void addPath(Node node){
        path.add(node);
    }

    public void setMinDistance(double distance){
        minDistance = distance;
    }
    public double getMinDistance(){
        return minDistance;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getPrevious(){
        return previous;
    }


    private final String name;
    private final String code;
    private final int index;

    Node(int index, String code, String name) {
        this.index = index;
        this.code = code;
        this.name = name;
    }

    public String getName() { return name; }
    public String getCode() { return code; }
    public int getIndex()  { return index; }
}
