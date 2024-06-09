//Student Name: Daniel Trenholm
//Student Number: 201202966

import java.io.Serializable;
import java.util.Objects;

public class Customer<E> {

    public int compareTo(Customer anotherInteger) {
        return compare(this.getType(), anotherInteger.getType());
    }

    public static int compare (int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
    private int type;
    private int serviceTime;
    private double price;

    //DONT FORGET TO MAKE THE STATIC NODE CLASS FOR USING E for data
    //and FRONT AND REAR FOR THE NODE SYSTEM
public static class Node<E> implements Serializable {
    public Customer<E> data;
        public Node<E> next;
    public Node<E> back;
    public Node<E> front;

    public Node<E> left;
    public Node<E> right;
    public E QueueData;


    public Node(Customer<E> data){
        this.data = data;
        this.front = null;
        this.back = null;
        this.next = null;
        this.left = null;
        this.right = null;
        this.QueueData = null;
    }

    public Node(Customer<E> data, E queuePriorty){
        QueueData = queuePriorty;
        this.data = data;
        this.back = null;
        this.front = null;
        this.next = null;
        this.left = null;
        this.right = null;
    }
    public Node(){
        this(null);
    }

    public Customer<E> getData(){
        return data;
    }

    public void setData(Customer<E> data){
        this.data = data;
    }

    public E getQueueData(){
        return QueueData;
    }
    public Node<E> getNext(){
        return next;
    }

    public Node<E> getFront(){
        return front;
    }

    public Node<E> getBack(){
        return back;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }
    }
    public int size(){
    return this.size();
    }
    public Node<E> getNextNode(){
        return root.next;
    }

    public Node<E> setData(Customer<E> data){
    root.data = data;
    return root;
    }
    public Customer(){
        type = 0;
        serviceTime = 0;
        price = 0;

    }
    public Customer(int type, int serviceTime, double price){
        this.type = type;
        this.serviceTime = serviceTime;
        this.price = price;
    }


    public int getType(){
        return type;
    }

    public void setType(int i) {this.type = i; }

    public double getServiceTime(){
        return serviceTime;
    }
    public void setServiceTime(int i){this.serviceTime = i;}

    public double getPrice(){
        return price;
    }
public void setPrice(double i){this.price = i;}
    @Override
    public String toString(){
        return String.format("Customer(%s,serviceTime= %d price= %.2f)", type, serviceTime, price);
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this.getClass() == o.getClass()){
            return true;
        }
//        Customer c = (Customer) o;
//        Objects.equals(this.type == c.type && this.serviceTime
//                == c.serviceTime && this.price == c.price
//                );
        return true;
    }



//    public String hashCode(){
//        return String.hash()

public Node<E> root;
    }


