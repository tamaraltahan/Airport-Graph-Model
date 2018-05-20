import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {

    private int vertices;
    private Boolean[][] matrix;


    AdjacencyMatrixGraph(int v) {
        vertices = v;
        Boolean[][] matrix = new Boolean[v][v];
    }


    void addEdge(int i, int j) {
        matrix[i][j] = true;
    }
    void removeEdge(int i, int j) {
        matrix[i][j] = false;
    }
    boolean hasEdge(int i, int j) {
        return matrix[i][j];
    }


    List<Integer> outEdges(int i) {
        List<Integer> edges = new ArrayList<>();
        for (int j = 0; j < matrix.length; j++)
            if (matrix[i][j]) edges.add(j);
        return edges;
    }

    List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<>();
        for (int j = 0; j < matrix.length; j++)
            if (matrix[j][i]) edges.add(j);
        return edges;
    }

}
