import java.util.ArrayList;


public class Node {

    private String name;
    private String code;
    private int index;


    //private ArrayList<Edge> connections;

    Node(int index, String code, String name){
        this.name = name;
        this.code = code;
        this.index = index;
    }

    public String getName(){
        return name;
    }
    public String getCode() {return code;}
    public int getIndex(){ return index;}

//    public ArrayList<Edge> getConnections(){
//        return connections;
//    }

}
