//Student Name: Daniel Trenholm
//Student Number: 201202966

public class Rating implements Comparable<Rating>{

    private String rating;
    private String ID;

    public Rating(String rating, String ID){
        this.rating = rating;
        this.ID = ID;
    }

    public int compareTo(Rating rating){
        int ratings = this.rating.compareTo(rating.rating);
        return ratings == 0 ? this.ID.compareTo(rating.ID) : ratings;
    }

    @Override
    public String toString(){
        return String.format(rating +" " + ID);
    }

    public String getID(){
        return ID;
    }

    public String getRating(){
        return rating;
    }


}
