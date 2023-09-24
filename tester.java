public class tester {
    
    public static void main(String args[]) {
        arrayList<keyValuePair<String, Integer>> arr = new arrayList<keyValuePair<String, Integer>>();
        arr.print();

        for (int i = 0; i < 10; i++) {
            keyValuePair<String, Integer> x = new keyValuePair<String,Integer>(String.valueOf(i), i*i);
            arr.push(x);
        }

        arr.print();
        // System.out.println(arr.pop());
        // System.out.println(arr.size());
        // System.out.println(arr.tail);
        // System.out.println(arr.capacity);
        keyValuePair<String, Integer> v = arr.pop();
        arr.print();
        v.print();


        // System.out.println(arr.get(1));
        // System.out.println(arr.size());
        // arr.print();
        // arr.push(1);
        // arr.push(2);
        // arr.print();
        // arr.push(3);
        // arr.push(4);
        // arr.push(5);
        // arr.push(6);
        // arr.push(7);
        // arr.print();
        // System.out.println(arr.get(1));
        // System.out.println(arr.size());
    }

}
