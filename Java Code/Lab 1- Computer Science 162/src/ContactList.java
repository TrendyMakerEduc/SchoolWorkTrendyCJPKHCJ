import java.lang.reflect.Array;

public class ContactList {
    //define a friend array
    private Friend[] friends;
    //Making a constant that will define the array size
    private static final int defaultSize = 10;

    // The not found label
    private static final int NOT_FOUND = -1;
    //A number that will make the size
    private int size;

    //Default Constructor when defining without parameter
    public ContactList(){
        //Defining the constant size of the array in ContactList for initialization
        this(defaultSize);
    }

    //When defining with one parameter, then this constructor is called
    public ContactList(int initialCapacity){
        //Defining your own size for the ContactList
        size = 0;
        friends = new Friend[initialCapacity];
    }
    //Adding a friend by using a newFriend to add to a new Array, and return
    //the array
    public boolean add(Friend newFriend){
        if(size() == friends.length) {
            expandCapacity();
        }
        friends[size] = newFriend;
        size++;
        return true;
        }


   // This is the way to expand the Capacity of the array, via doubling a new array
    // length and then returning it as the friends array that was made before
    private void expandCapacity(){
        Friend[] newFriends = new Friend[friends.length * 2];
        for(int i = 0; i < size(); i++){
            newFriends[i] = friends[i];
        }
        friends = newFriends;
    }


    //Returning the size of the array
    public int size(){
        return size;
    }




}
