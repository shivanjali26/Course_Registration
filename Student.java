import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Registrable
{
    private final List<Course> registeredCourses;
    private Branch branch;
    private final String year;
    public Student(String Id,String Name,String Email,String year)
    {
        super(Id,Name,Email);
        this.year=year;
        this.registeredCourses = new ArrayList<>();
    }
    public String getYear() {
        return year;
    }
    public void chooseBranch(Branch branch)
    {
        this.branch=branch;
        registerCompulsoryCourses(branch.getCompulsoryCourses());
    }

    public Branch getBranch()
    {
        return branch;
    }
    @Override
    public void registerCompulsoryCourses(List<Course> compulsoryCourses)
    {
        for(Course course : compulsoryCourses)
        {
            if(!registeredCourses.contains(course))
            {
                registeredCourses.add(course);
            }
        }
    }
    @Override
    public boolean registerForElectiveCourse(Course course)
    {
        if(branch!=null && branch.getElectiveCourses().contains(course) && !registeredCourses.contains(course))
        {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }
    @Override
    public List<Course> getRegisteredCourses()
    {
        return registeredCourses;
    }

    public void showInfo()
    {
        System.out.println("Student ID:"+ getId() +",Name: "+ getName() +",Email: "+ getEmail());
        System.out.println("Branch: " + (branch != null ? branch.getBranchName() : "Not Selected"));
        System.out.println("Registered Courses:");
        for(Course course : registeredCourses)
        {
            System.out.println("  " + course.getCourseName());
        }

    }
}
