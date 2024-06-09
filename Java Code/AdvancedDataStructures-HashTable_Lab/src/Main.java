public class Main {
    public static void main(String[] args) {

        HashTableOpenDouble table = new HashTableOpenDouble();
        table.put(1, 2);
        table.put(3, 7);
        table.put(5, 6);
        System.out.println(table.find(-1));



    }
}