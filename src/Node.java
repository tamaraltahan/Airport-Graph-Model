

public class Node {

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
