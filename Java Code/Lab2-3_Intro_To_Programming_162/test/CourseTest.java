import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    void getProgramCode_generalCase_returnsProgramCode(){
        Course course = new Course("CSCI", 162, "Intro To Programming");
        assertEquals("CSCI", course.getProgramCode());
    }
    @Test
    void getCourseCode_generalCase_returnCourseCode(){
        Course course = new Course("CSCI", 162, "Intro To Programming");
        assertEquals(162, course.getCourseCode());
    }

    @Test
    void getCourseTitle_generalCase_returnCourseTitle(){
        Course course = new Course("CSCI", 162, "Intro To Programming");
        assertEquals("Intro To Programming", course.getCourseTitle());
    }

    @Test
    void gettoString_generalCase_returnString(){
        Course course = new Course("CSCI", 162, "Intro To Programming");
        assertEquals("Course(CSCI, 162, Intro To Programming)", course.toString());
    }
    @Test
    void getEquals_generalCase_returnTwoIdenticalObjects(){
        Course course = new Course("CSCI", 162, "Intro To Programming");
        Course course2 = new Course("CSCI", 162, "Intro To Programming");
        assertEquals(course, course2);
    }


}
