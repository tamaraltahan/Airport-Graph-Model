public class Entry<K, V> {
    Entry(K k, V v){
        key = k;
        val = v;
    }

    private final K key;
    private final V val;

    K getKey() {
        return key;
    }
    V getValue(){
        return val;
    }
}
