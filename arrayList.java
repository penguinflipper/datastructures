import java.util.Arrays;

// make removeVal and removeIndex

public class arrayList<E extends Comparable<E>> {

    private int capacity = 1;
    private Object[] arr = new Object[this.capacity];
    private int tail = 0;

    public arrayList() {}

    public arrayList(int cap) {
        if (cap > this.capacity) {
            this.capacity = cap;
        }
        this.arr = new Object[this.capacity];
    }

    private void expandArr() {
        if (this.tail == this.capacity) {
            this.capacity++;
            Object[] clonedArr = new Object[this.capacity];
            
            for (int i = 0; i < this.tail; i++) {
                clonedArr[i] = this.arr[i];
            }
            
            this.arr = clonedArr;
        }
    }

    public void push(E val) {
        this.arr[this.tail] = val;
        this.tail += 1;

        
        expandArr();
    }

    public E pop() {
        E v = (E) this.arr[this.tail - 1];
        this.arr[this.tail - 1] = null;
        this.tail--;
        return v;
    }

    public E pop(int index) {

        if (index < 0 || index >= this.tail) {
            return null;
        }

        Object[] newArr = new Object[this.tail - 1];
        E v = (E) this.arr[index];
        for (int i = 0; i < this.tail; i++) {
            if (index != i) {
                newArr[i] = this.arr[i];
            }
        }
        this.arr = newArr;
        this.tail--;

        return v;

    }


    public E get(int index) {
        if (index < this.tail) {
            return (E) this.arr[index];
        }
        return null;
    }

    public int size() {
        return this.tail;
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

    public Object[] getArrayObject() {
        return this.arr;
    }

    public void sort() {

        this.arr = mergeSort(this.arr);

    }
    private Object[] mergeSort(Object[] subArr) {
        
        if (subArr.length == 1) {
            return subArr;
        }
        
        int len = subArr.length;
        if (Arrays.equals(subArr, this.arr)) {
            len = subArr.length - 1;
        }
        int mid = (int) Math.floor(len/ 2);
        Object[] left = Arrays.copyOfRange(subArr, 0, mid);

        Object[] right = Arrays.copyOfRange(subArr, mid, len);

        return compare(mergeSort(left), mergeSort(right));
        
    }

    private Object[] compare(Object[] left, Object[] right) {
        Object[] sorted = new Object[left.length + right.length];
        int lPointer = 0;
        int rPointer = 0;
        int count = 0;
        while (lPointer < left.length || rPointer < right.length) {
            if (lPointer >= left.length) {
                sorted[count] = right[rPointer];
                rPointer++;
            } else if (rPointer >= right.length) {
                sorted[count] = left[lPointer];
                lPointer++;
            } else {
                if (((E) left[lPointer]).compareTo((E) right[rPointer]) <= 0) {
                    sorted[count] = left[lPointer];
                    lPointer++;
                } else {
                    sorted[count] = right[rPointer];
                    rPointer++;
                }
            }
            count++;
        }

        return sorted;
    }


}