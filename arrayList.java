
// make removeVal and removeIndex

public class arrayList<E> {

    public int capacity = 1;
    private Object[] arr = new Object[this.capacity];
    public int tail = 0;
    private int holding = 0;

    public arrayList() {}

    public arrayList(int cap) {
        this.capacity = cap;
        this.arr = new Object[this.capacity];
    }

    private void expandArr() {
        if (this.tail == this.capacity) {
            this.capacity *= 2;
            Object[] clonedArr = new Object[this.capacity];
            
            for (int i = 0; i < this.holding; i++) {
                clonedArr[i] = this.arr[i];
            }
            
            this.arr = clonedArr;
        }
    }

    public void push(E val) {
        this.arr[this.tail] = val;
        this.tail += 1;
        this.holding += 1;

        
        expandArr();
    }

    public E pop() {
        E v = (E) this.arr[this.tail - 1];
        this.arr[this.tail - 1] = null;
        this.tail -= 1;
        this.holding -= 1;
        return v;
    }


    public E get(int i) {
        if (i < this.holding) {
            return (E) this.arr[i];
        }
        return null;
    }

    public int size() {
        return this.holding;
    }

    public void print() {
        String s = "[";
        
        for (int i = 0; i < this.holding; i++) {
            if (this.arr[i] != null) {
                s += this.arr[i].toString();
            } else {
                s += "null";
            }
            if (i < this.holding - 1) {
                s += ", ";
            }
        }

        s += "]";
        System.out.println(s);
    }

    public Object[] getArrayObject() {
        return this.arr;
    }

}