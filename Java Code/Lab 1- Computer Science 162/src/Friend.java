import java.util.Objects;

    public final class Friend{
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final String emailAddress;
        private final String phoneNumber;
        private final String userName;
        private final String password;

        // This is the def __init__method like in Python.
        public Friend(String firstName, String middleName, String lastName, String emailAddress, String phoneNumber, String userName, String password){
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.emailAddress = emailAddress;
            this.phoneNumber = phoneNumber;
            this.userName = userName;
            this.password = password;
        }
// These string of functions are to return Friend Object Data, so should be accessible outside class
// (hence the public keyword, or in this case visibility modifiers). Also remember to use String,
// As you are doing a return type this time.

        public String getFirstName(){
            return firstName;
        }

        public String getLastName(){
            return lastName;
        }

        public String getMiddleName(){
            return middleName;
        }

        public String getEmailAddress(){
            return emailAddress;
        }

        public String getPhoneNumber(){
            return phoneNumber;
        }

        public String getUserName(){
            return userName;
        }

        public String getPassword(){
            return password;
        }


// This method is the same as def __repr__ in Python. (toString in this case).. The trick is
        // To use private final methods to make the data immutable. It can be
        //accessed easily with toString, and automatically returns the string, so be
        // careful

        // It is important to understand the difference between these three things
        // someObject == someOtherObject
        // someObject.equals(someOtherObject)
        // Objects.equals(someObject, someOtherObject).

        // With someObject == someOtherObject, it checks if it is referencing the same
        // object - aliases

        // someObject.equals(someOtherObject) checks if someObject and someOtherObject are
        // equivalent based on someObject class's equals methods (good to hide data here)

        // Objects.equals(someObject, someOtherObject) is the same as someObjects.equals(someOtherObject),
        // but it makes the equality check null safe. In other words, it first checks if both someObject and someOtherObject
        // are null, because then they are equal. Further, it won't produce a NullPointerException if someObject
        // happens to be null.
        @Override
        public String toString(){
            return ("Friend = " + firstName + " " + lastName +", Email_Address = " + emailAddress + ".");
        }

        // This is the same as the def __eq__ method, which would check if everything equals a copy of the other
        // object. At override is written so that it can be inherited in the class
        @Override
        public boolean equals(Object o) {
            //If o is the actual memory address
            if (o == this){
                return true;
            }
            // If o is null, then it is not equal
            if (o == null){
                return false;
            }
            // if o and this are of different classes, they're not equal
            if (o.getClass() != this.getClass()){
                return false;
            }
            Friend other = (Friend) o;
            return Objects.equals(this.firstName, other.firstName) &&
                    Objects.equals(this.middleName, other.middleName) &&
                    Objects.equals(this.lastName, other.lastName) &&
                    Objects.equals(this.emailAddress, other.emailAddress) &&
                    Objects.equals(this.phoneNumber, other.phoneNumber) &&
                    Objects.equals(this.userName, other.userName) &&
                    Objects.equals(this.password, other.password);
        }

        //When properly writing the equals method, one should also write another special method- hashCode()
        // Briefly, it is a function used to convert the object into an int hash value
        // Any two objects that are equal must have the same hash value
        // Ideally, the hash value should aim to have different hashes

        // Any unequal objects should have different hash values
        // Unfortunately, hash collisions- cases where unequal things have the same
        // hash- are inevitable

        // Below is an example of hashCode for the Friend class
        // This hashCode effectively returns the sum of the hash values of the current amount of String attributes chosen
        // include. For simple classes like the Friend class, this pattern will be typical.
        @Override
        public int hashCode() {
            return Objects.hash(firstName, middleName, lastName, emailAddress);
        }




    }

