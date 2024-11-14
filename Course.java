public class Course
{
    private final String courseId;
    private final String courseName;
    private final int credits;

    public Course(String courseId,String courseName,int credits,Branch branch)
    {
        this.courseId=courseId;
        this.courseName=courseName;
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

    public String getCourseId() {
        return courseId;
    }

    public int getCredits() {
        return credits;
    }
}
