public class Edge {
    private final Node end;
    private final double cost;


    private Node from;
    public void setFrom(Node from){
        this.from = from;
    }
    public Node getStart(){
        return from;
    }

    Edge(Node end, double cost) {
        this.end = end;
        this.cost = cost;
    }

    public Node getEnd() {
        return end;
    }
    public double getCost() {
        return cost;
    }
}