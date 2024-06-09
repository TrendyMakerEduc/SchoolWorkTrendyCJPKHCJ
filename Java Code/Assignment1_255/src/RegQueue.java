//import java.util.NoSuchElementException;
//import java.util.Objects;
//
//public class RegQueue<E> extends Customer<E> implements Queue<E> {
//
//    private int size;
//    private final int NOT_FOUND = -1;
//
//    public RegQueue(){
//        root = null;
//        size = 0;
//    }
//
//    public boolean offer(E object){
//      E toEnqueue = object;
//        if (isEmpty()){
//            root = toEnqueue;
//        } else{
//            root.back.setNext(toEnqueue);
//        }
//        root.back = toEnqueue;
//        size++;
//        return true;
//    }
//
////    public int maxIndex(){
////        int maxIndex = -1;
////        if(isEmpty()){
////            return maxIndex;
////        }
////       for(int i = 0; i < customers.length; i++){
////           maxIndex += i;
////       }
////       return maxIndex;
////    }
//public Node<E> getNextNode(){
//        return root.next;
//}
//
//    public E poll() {
//        if(isEmpty()){
//            throw new NoSuchElementException("Empty Queue");
//        }
//        //REMEMBER, FRONT AND BACK ARE SUPPOSED TO BE NODES
//       root = root.getNext();
//       size--;
//if(isEmpty()){
//    root.back = null;
//}
//return root.getQueueData();
//
//
//    }
//
////    public Node<E> first(){
////        if(isEmpty()){
////            throw new NoSuchElementException("No Elements");
////        }
////        return root;
////    }
//
//    public boolean isEmpty(){
//        if(size == 0){
//            return true;
//        }
//        return false;
//    }
//
//
//
////    public Customer getNext(Customer<E> c){
////        int i = find(c);
////        if(customers[i + 1] != null){
////            return customers[i + 1];
////        }
////        else{
////            return customers[i];
////        }
////    }
//
////    private int find(Customer customer){
////        for(int i = 0; i < customers.length; i++){
////            if(Objects.equals(customer, customers[i]))
////                return i;
////        }
////        return NOT_FOUND;
////    }
//
////    public boolean contains(Customer customer){
////        return find(customer) != -1;
////    }
//public int getSize(){
//        return size;
//}
//    public static void main(String[] args) {
//        RegQueue reg = new RegQueue();
//
//        System.out.println(reg.root.data);
//    }
//
//}
