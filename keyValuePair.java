public class keyValuePair<K, V> {
    
    private K key;
    private V value;

    public keyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return String.format("[%s : %s]", this.key.toString(), this.value.toString());
    }

    public void print() {
        System.out.println(String.format("Key: %s, Value: %s", this.key, this.value));
    }

}
