import java.util.Objects;

public class Data {
    //Data Objects stored from .cvs list
    private final String[] Data;
    private final String Column1;
    private final String Column2;
    private final String Column3;
    private final String Column4;
    private final String Column5;
    private final String Column6;
    private final String Column7;
    private final String Column8;

    public cvsData(String Data1, String Data2, String Data3, String Data4, String Data5, String Data6, String Data7, String Data8){
        this.Column1 = Data1;
        this.Column2 = Data2;
        this.Column3 = Data3;
        this.Column4 = Data4;
        this.Column5 = Data5;
        this.Column6 = Data6;
        this.Column7 = Data7;
        this.Column8 = Data8;
    }

    public String toString(){
        return String.format("Current Illness Looked Up:(%s, %s, %s, %s, %s, %s, %s, %s)", Column1, Column2, Column3, Column4, Column5, Column6, Column7, Column8);
    }

    @Override
    public boolean equals(Object o) {
        // If o is actually in the same memory address of this
        if (o == this) {
            return true;
        }
        // If o is null, then it's not equal
        if (o == null) {
            return false;
        }
        // if o and this are of different classes, they're not the equal
        if (o.getClass() != this.getClass()) {
            return false;
        }
        // Cast o as a friend
        Data other = (Data) o;
        return Objects.equals(this.column1, other.column1) &&
                Objects.equals(this.column2, other.column2) &&
                Objects.equals(this.column3, other.column3) &&
                Objects.equals(this.column4, other.column4) &&
                Objects.equals(this.column5, other.column5) &&
                Objects.equals(this.column6, other.column6) &&
                Objects.equals(this.column7, other.column7) &&
                Objects.equals(this.column8, other.column8);
    }
        public static int linearSearch(int[] arr, int key){
            for(int i=0;i<arr.length;i++){
                if(arr[i] == key){
                    return i;
                }
            }
            return -1;
        }

    }
}
