import java.util.ArrayList;
import java.util.List;

public class Student extends User
{
    private List<Course> registeredCourses;
    private Branch branch;
    public Student(String Id,String Name,String Email)
    {
        super(Id,Name,Email);
        this.registeredCourses = new ArrayList<>();
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
    private void registerCompulsoryCourses(List<Course> compulsoryCourses)
    {
        for(Course course : compulsoryCourses)
        {
            if(!registeredCourses.contains(course))
            {
                registeredCourses.add(course);
            }
        }
    }

    public boolean registerForElectiveCourse(Course course)
    {
        if(branch!=null && branch.getElectiveCourses().contains(course) && !registeredCourses.contains(course))
        {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public void showInfo()
    {
        System.out.println("Student ID:"+Id+",Name: "+Name+",Email: "+Email);
        System.out.println("Branch: " + (branch != null ? branch.getBranchName() : "Not Selected"));
        System.out.println("Registered Courses:");
        for(Course course : registeredCourses)
        {
            System.out.println("  " + course.getCourseName());
        }

    }

}
