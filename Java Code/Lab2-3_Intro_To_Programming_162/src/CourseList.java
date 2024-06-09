import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CourseList {
    private int size;
    public Course[] list;
    private static final int NOT_FOUND = -1;
    private static int DEFAULT_CAPACITY = 10;

    public CourseList(){
        this(DEFAULT_CAPACITY);
    }

    public CourseList(int initialCapacity){
        size = 0;
        list = new Course[initialCapacity];
    }

    public boolean add(Course newC){
        if(size() == list.length){
            expandCapacity();
        }
        else {
            list[size] = newC;
            size++;
            return true;
        }
        return false;
    }

    public void expandCapacity(){
        Course[] newCountrySize = new Course[list.length * 2];
        for(int i = 0; i < list.length; i++){
            newCountrySize[i] = list[i];
        }
        list = newCountrySize;

    }

    public boolean remove(Course c) {
        if (!contains(c)) {
            throw new NoSuchElementException(Objects.toString(c));
        }else{
            int removeIndex = find(c);
            list[removeIndex] = list[size - 1];
            list[size - 1] = null;
            size--;
            return true;
        }}

    public int find(Course c){
        for(int i = 0; i < size(); i++) {
            if (Objects.equals(c, list[i])) {
                return i;
            }
        }
        return NOT_FOUND;

    }


    public boolean contains(Course c) {
        return find(c) != NOT_FOUND;

    }

    public int indexOf(Course c) {
        if(!contains(c)) {
            throw new NoSuchElementException(Objects.toString(c));
        }
        return find(c);
    }

    public Course get(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
        return list[index];

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < size(); i++) {
            builder.append(list[i]);
            builder.append("/n");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o || this.getClass() != o.getClass()) {
            return false;
        }
        CourseList that = (CourseList) o;
        // Compare the arrays' contents between 0 -- size
        return Arrays.equals(this.list, 0, this.size, that.list, 0, that.size);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(this.size);
        for (int i = 0; i < this.size; i++) {
            result = 31 * result + Objects.hash(this.list[i]);
        }
        return result;
    }

    public int size(){
        return size;
    }


}
