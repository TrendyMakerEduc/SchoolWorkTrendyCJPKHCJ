import java.util.Objects;

public class Course {
    //program Code (i.e: CSCI)
    private final String programCode;
    //course Code (i.e: CSCI courseCode=162)
    private final int courseCode;
    //course Title (i.e. a name of the course)
    private final String courseTitle;

    //Writing a constructor which takes the 3 variables
    public Course(String programCode, int courseCode, String courseTitle){
    this.programCode = programCode;
    this.courseCode = courseCode;
    this.courseTitle = courseTitle;
    }

    public String getProgramCode(){
        return programCode;
    }

    public int getCourseCode(){
        return courseCode;
    }

    public String getCourseTitle(){
        return courseTitle;
    }
    @Override
    public String toString(){
        return String.format("Course(%s, %s, %s)", programCode, courseCode, courseTitle);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (null == o || this.getClass() != o.getClass()) {
            return false;
        }
        Course country = (Course) o;
        return Objects.equals(this.programCode, country.programCode) &&
                Objects.equals(this.courseCode, country.courseCode) &&
                Objects.equals(this.courseTitle, country.courseTitle) ;



    }

    @Override
    public int hashCode(){
        return Objects.hash(programCode, courseCode, courseTitle);
    }


}
