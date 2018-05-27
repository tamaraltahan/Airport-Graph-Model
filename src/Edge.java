public class Edge {
    private final Node end;
    private final double cost;

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