public class Course
{
    private String courseId;
    private String courseName;
    private static Branch branch;
    private int credits;

    public Course(String courseId,String courseName,int credits,Branch branch)
    {
        this.courseId=courseId;
        this.courseName=courseName;
        this.branch =branch;
        this.credits=credits;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public void displayCourseDetails()
    {
        System.out.println("  Course ID: " + courseId);
        System.out.println("  Course Name: " + courseName);
        System.out.println("  Course Credits: " + credits);
        System.out.println();
    }

}
