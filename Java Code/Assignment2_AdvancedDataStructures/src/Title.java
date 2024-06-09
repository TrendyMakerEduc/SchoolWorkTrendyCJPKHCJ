//Student Name: Daniel Trenholm
//Student Number: 201202966

public class Title implements Comparable<Title>{

    private String title;
    private String ID;

    public Title(){
        this.title = null;
        this.ID = null;
    }

    public Title(String title, String ID){
        this.title = title;
        this.ID = ID;
    }

    public int compareTo(Title title){
        int titles = this.title.compareTo(title.title);
        return titles == 0 ? this.ID.compareTo(title.ID) : titles;
    }

    @Override
    public String toString(){
        return String.format(title + " " + ID);
    }

    public String getID(){
        return ID;
    }

    public String getTitle(){
        return title;
    }


}
