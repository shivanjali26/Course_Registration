import java.util.ArrayList;
import java.util.List;

public class EnrollmentSystem
{
    private List<Student> students;
    private List<Branch> branches;
    private List<Branch> FirstYear;
    private List<Branch> SecondYear;
    private List<Branch> ThirdYear;
    private List<Branch> LastYear;


    public EnrollmentSystem()
    {
        this.students=new ArrayList<>();
        this.branches=new ArrayList<>();
        FirstYear = new ArrayList<>();
        SecondYear = new ArrayList<>();
        ThirdYear = new ArrayList<>();
        LastYear = new ArrayList<>();

        initializeBranchesAndCourses();
    }
    public void initializeBranchesAndCourses()
    {
        Branch csFirst = new Branch("Computer Science",3);
        Branch itFirst = new Branch("Information Technology",3);
        Branch EntcFirst = new Branch("Electronics and Telecommunication",3);
        Branch MechFirst = new Branch("Mechanical Engineering",3);
        Branch CivilFirst = new Branch("Civil Engineering",2);
        Branch AiFirst = new Branch("Artificial Intelligence",3);



        Course dataStructures = new Course("CS101", "Data Structures",3, csFirst);
        Course algorithms = new Course("CS102", "Algorithms",2, csFirst);
        Course webDevelopment = new Course("CS103", "Web Development",4, csFirst);
        Course DataScience = new Course("CS104", "Data Science",4, csFirst);
        Course DiscreteMath = new Course("CS105", "Discrete Mathematics",4, csFirst);
        Course MA = new Course("CS106", "Microprocessor Architecture",4, csFirst);
        csFirst.addCompulsoryCourse(dataStructures);
        csFirst.addCompulsoryCourse(DiscreteMath);
        csFirst.addElectiveCourse(algorithms);
        csFirst.addElectiveCourse(webDevelopment);
        csFirst.addElectiveCourse(DataScience);
        csFirst.addElectiveCourse(MA);

        FirstYear.add(csFirst);

        Course networkSecurity = new Course("IT101", "Network Security",3,itFirst);
        Course databaseManagement = new Course("IT102", "Database Management",3, itFirst);
        Course cloudComputing = new Course("IT103", "Cloud Computing",3, itFirst);
        itFirst.addCompulsoryCourse(networkSecurity);
        itFirst.addElectiveCourse(databaseManagement);
        itFirst.addElectiveCourse(cloudComputing);
        FirstYear.add(itFirst);
    }
    public void displayBranchesByYear(String year)
    {
        switch(year.toLowerCase())
        {
            case "first year":
                branches = FirstYear;
                break;

            case "second year":
                branches = SecondYear;
                break;

            case "third year":
                branches = ThirdYear;
                break;

            case "last year":
                branches = LastYear;
                break;

            default:
                System.out.println("Invalid year selected.");
                return;
        }

        System.out.println("\nAvailable Branches for " + year +":");
        for(Branch branch : branches)
        {
            System.out.println(branch.getBranchName());
        }
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
    public void displayBranchCourses(Branch branch)
    {
        System.out.println("\nCompulsory Courses for "+branch.getBranchName()+":");
        for(Course course:branch.getCompulsoryCourses())
        {
//            System.out.println(course.getCourseName());
            course.displayCourseDetails();
        }

        System.out.println("Elective Courses for "+branch.getBranchName()+":");
        for(Course course : branch.getElectiveCourses())
        {
//            System.out.println(course.getCourseName());
            course.displayCourseDetails();

        }

    }


    public void registerStudentInBranch(Student student,String branchName)
    {
        for(Branch branch : branches)
        {
            if(branch.getBranchName().equalsIgnoreCase(branchName))
            {
                student.chooseBranch(branch);
                break;
            }
        }
        System.out.println("branch after selection:"+(student.getBranch()!=null ? student.getBranch().getBranchName() : "null"));
    }




    public boolean enrollInElectiveCourse(Student student,String courseName)
    {
        for(Course course : student.getBranch().getElectiveCourses())
        {
            if(course.getCourseName().equalsIgnoreCase(courseName))
            {
                return student.registerForElectiveCourse(course);
            }
        }
        return false;
    }

    public Branch getBranchByName( String year, String branchName)
    {
        //List<Branch> branches;
        switch(year.toLowerCase())
        {
            case "first year":
                branches = FirstYear;
                break;

            case "second year":
                branches = SecondYear;
                break;

            case "third year":
                branches = ThirdYear;
                break;

            case "last year":
                branches = LastYear;
                break;

            default:
                return null;
        }
        for(Branch branch : branches)
        {
            if(branch.getBranchName().equalsIgnoreCase(branchName))
            {
                return branch;
            }
        }
        return null;
    }

    public Student getStudent(String Id)
    {
        for(Student student : students)
        {
            if(student.getId().equalsIgnoreCase(Id))
            {
                return student;
            }
        }
        return null;
    }
}
