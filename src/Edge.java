public class Edge {
    private Node start;
    private Node end;
    private double cost;

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