public class Edge {
    private final Node start;
    private final Node end;
    private final double cost;

    Edge(Node start, Node end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    public Node getStart() {
        return start;
    }
    public Node getEnd() {
        return end;
    }
    public double getCost() {
        return cost;
    }

}