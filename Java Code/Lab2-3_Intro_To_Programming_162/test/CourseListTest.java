import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseListTest {

    //Adding element test
    @Test
    void addOneElement_assertTrue_forCourseListArray(){
    CourseList courseList = new CourseList();
    courseList.add(new Course("1", 2, "3"));
    assertEquals(1, courseList.size());

    }
//Subtracting an element test
    @Test
    void addTwoSubrtract1Element_assertEquals_forCourseListArray_EqualsOne(){
        CourseList courseList = new CourseList();
        Course course1 = new Course("1", 2, "4");
        Course course2 = new Course("1", 2, "3");
        courseList.add(course1);
        courseList.add(course2);

        courseList.remove(course1);
        assertEquals(1, courseList.size());

    }
//Asserting it is true that course 1 is in the courseList
    @Test
    void containscourseOne_assertTrue_forCourseListArray(){
        CourseList courseList = new CourseList();
        Course course1 = new Course("1", 2, "4");
        Course course2 = new Course("1", 2, "3");
        courseList.add(course1);
        courseList.contains(course1);
        assertTrue(courseList.contains(course1));

    }
//Finding course one at the beginning of the array
    @Test
    void FindCourseOne_assertTrue_forCourseListArray(){
        CourseList courseList = new CourseList();
        Course course1 = new Course("1", 2, "4");
        courseList.add(course1);

        assertEquals( 0 , courseList.find(course1));
    }
    //Testing size to be set to 1 in the array
    @Test
    void SizeOfOne_assertEquals_forCourseListArray(){
        CourseList courseList = new CourseList();
        Course course1 = new Course("1", 2, "4");
        courseList.add(course1);

        assertEquals( 1 , courseList.size());
    }
//Getting index at one
    @Test
    void getIndexAtOne_assertEquals_forCourseListArray(){
        CourseList courseList = new CourseList();
        Course course1 = new Course("1", 2, "4");
        Course course2 = new Course("1", 2, "3");
        courseList.add(course1);
        courseList.add(course2);

        assertEquals( course2 , courseList.get(1));
    }

@Test
    void IsEmpty_assertTrue_forEmptyArray(){
    CourseList courseList = new CourseList();
    Course course1 = new Course("1", 2, "4");
    Course course2 = new Course("1", 2, "3");
    courseList.add(course1);
    courseList.add(course2);
    courseList.remove(course1);
    courseList.remove(course2);

    assertTrue(courseList.isEmpty());
}
}
