import java.util.*;

public class Node {

    Node prev;
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    private List<Entry<Double,Node>> paths = new ArrayList<>();

    public void addAdjacency(Node node, Double weight){
        paths.add(new Entry<>(weight, node));
    }
    public List<Entry<Double,Node>> getAdjacencies() {
        return paths;
    }

    public void removeAdjacency(Node node){
        for(int i = 0 ; i < paths.size(); i++){
            if(paths.get(i).getValue() == node){
                paths.remove(i);
                break;
            }
        }
    }
    public void removeAdjacency(Entry<Double,Node> entry){
        paths.remove(entry);
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
