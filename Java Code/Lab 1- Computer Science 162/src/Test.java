public class Test {
        public static void main(String[] args) {
            //Declare a Friend variable
            //Create an instance of a Friend
            //Assign the variable to reference the newly created Friend
            //There is a bit going on
            //Declare the variable of type Friend = Friend aFriend
            //Create an instance of a Friend object = Friend aFriend = new Friend("Bob", "S", "Saget", 9, 9, 9, 9);
            //The single = is used for assignment
            //Be mindful about what is actually stored in the aFriend variable. The object is not stored in the varable, but
            //a reference to the object is

            Friend aFriend = new Friend("Bob", "S", "Saget", "a", "a", "a", "a");
            Friend bFriend = new Friend("Bob", "S", "Saget", "a", "a", "a", "a");


            //Be mindful the Friend is not copied when using equals
            bFriend = aFriend;
            // The reference stored in aFriend gets copied; the Friend is not copied.
            // This results in an aliases- both aFriend and bFriend reference the exact same object
            // This also means that the object that bFriend used to point to now has no reference to it
            // This would cause Java to delete the bFriend reference in memory.
        }}
}
