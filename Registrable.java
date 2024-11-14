import java.util.List;

public interface Registrable {
    void registerCompulsoryCourses(List<Course> CompulsoryCourses);
    boolean registerForElectiveCourse(Course course);
    List<Course> getRegisteredCourses();

}
