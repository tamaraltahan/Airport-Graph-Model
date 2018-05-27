import java.util.Comparator;

public class Entry implements Comparator<Double>{

    @Override
    public int compare(Double x, Double y){
        if(x > y){
            return 1;
        }
        else if (x < y){
            return -1;
        }
        else{
            return 0;
        }
    }

    Entry(double k, Node v){
        key = k;
        val = v;
    }

    private final double key;
    private final Node val;

    double getKey() {
        return key;
    }
    Node getValue(){
        return val;
    }
}
