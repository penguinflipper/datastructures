public class queue<E> {

    private int capacity = 1;
    private int tail = 0;
    Object[] arr;

    public queue() {
        this.arr = new Object[this.capacity];
    }

    public queue(int cap) {
        if (cap > this.capacity) {
            this.capacity = cap;
        }
        this.arr = new Object[this.capacity];
    }

    private void expandArr() {
        this.capacity++;
        Object[] clonedArr = new Object[this.capacity];
        
        for (int i = 0; i < this.tail; i++) {
            clonedArr[i] = this.arr[i];
        }
        
        this.arr = clonedArr;
    }

    public E dequeue() {

        E v = (E) this.arr[0];

        Object[] newArr = new Object[1];

        if (this.tail - 1 > 0) {
            newArr = new Object[this.tail - 1];
            for (int i = 1; i < this.tail; i++) {
                newArr[i-1] = this.arr[i];
            }
        }

        this.arr = newArr;
        
        this.tail--;
        
        return v;
        
    }
    
    public void enqueue(E val) {
        expandArr();
        this.arr[this.tail] = val;
        this.tail += 1;

    }

    public E peek() {
        return (E) this.arr[0];
    }

    public void print() {
        String s = "[";
        
        for (int i = 0; i < this.tail; i++) {
            if (this.arr[i] != null) {
                s += this.arr[i].toString();
            } else {
                s += "null";
            }
            if (i < this.tail - 1) {
                s += ", ";
            }
        }

        s += "]";
        System.out.println(s);
    }

    public int size() {
        return this.tail;
    }

    public Object[] getArr() {
        return this.arr;
    }
    

}
