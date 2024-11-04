import java.util.ArrayList;
import java.util.List;

public class Branch
{
    private String branchName;
    private List<Course> compulsoryCourses;
    private List<Course> electiveCourses;
    private int requiredElectives;



    public Branch(String branchName,int requiredElectives)
    {
        this.branchName=branchName;
        this.compulsoryCourses=new ArrayList<>();
        this.electiveCourses=new ArrayList<>();
        this.requiredElectives=requiredElectives;
    }

    public String getBranchName()
    {
        return branchName;
    }
    public int getRequiredElectives()
    {
        return requiredElectives;
    }
    public void addCompulsoryCourse(Course course)
    {
        compulsoryCourses.add(course);
    }
    public void addElectiveCourse(Course course)
    {
        electiveCourses.add(course);
    }
    public List<Course> getCompulsoryCourses()
    {
        return compulsoryCourses;
    }
    public List<Course> getElectiveCourses()
    {
        return electiveCourses;
    }
}
