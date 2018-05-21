public class Edge {
    public Node start;
    public Node end;
    public double cost;

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