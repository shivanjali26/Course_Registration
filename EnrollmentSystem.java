import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentSystem
{
    private final List<Student> students;
    private List<Branch> branches;
    private final List<Branch> FirstYear;
    private final List<Branch> SecondYear;
    private final List<Branch> ThirdYear;
    private final List<Branch> LastYear;


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
        Branch csSecond = new Branch("Computer Science", 2);
        Branch csThird = new Branch("Computer Science", 2);
        Branch csFourth = new Branch("Computer Science", 2);

        Branch itFirst = new Branch("Information Technology",2);
        Branch itSecond = new Branch("Information Technology", 2);
        Branch itThird = new Branch("Information Technology", 2);
        Branch itFourth = new Branch("Information Technology", 2);

        Branch entcFirst = new Branch("Electronics and Telecommunication",3);
        Branch entcSecond = new Branch("Electronics and Telecommunication",3);
        Branch entcThird = new Branch("Electronics and Telecommunication",3);
        Branch entcFourth = new Branch("Electronics and Telecommunication",3);
//        Branch MechFirst = new Branch("Mechanical Engineering",3);
//        Branch CivilFirst = new Branch("Civil Engineering",2);
//        Branch AiFirst = new Branch("Artificial Intelligence",3);

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


        Course csOOP = new Course("CS201", "Object Oriented Programming", 3, csSecond);
        Course csDatabase = new Course("CS202", "Database Management", 3, csSecond);
        Course csNetworks = new Course("CS203", "Computer Networks", 3, csSecond);
        Course csTheoryOfComputation = new Course("CS204", "Theory of Computation", 3, csSecond);
        Course csSoftwareEngineering = new Course("CS205", "Software Engineering", 3, csSecond);

        // Add courses to Second Year CS branch
        csSecond.addCompulsoryCourse(csOOP);
        csSecond.addCompulsoryCourse(csDatabase);
        csSecond.addCompulsoryCourse(csNetworks);
        csSecond.addElectiveCourse(csTheoryOfComputation);
        csSecond.addElectiveCourse(csSoftwareEngineering);
        SecondYear.add(csSecond);

        // Step 4: Create Courses for Third Year CS
        Course csAI = new Course("CS301", "Artificial Intelligence", 3, csThird);
        Course csML = new Course("CS302", "Machine Learning", 3, csThird);
        Course csOperatingSystems = new Course("CS303", "Operating Systems", 3, csThird);
        Course csCompilers = new Course("CS304", "Compilers", 3, csThird);
        Course csCloudComputing = new Course("CS305", "Cloud Computing", 3, csThird);

        // Add courses to Third Year CS branch
        csThird.addCompulsoryCourse(csAI);
        csThird.addCompulsoryCourse(csML);
        csThird.addCompulsoryCourse(csOperatingSystems);
        csThird.addElectiveCourse(csCompilers);
        csThird.addElectiveCourse(csCloudComputing);
        ThirdYear.add(csThird);

        // Step 5: Create Courses for Fourth Year CS
        Course csWebDev = new Course("CS401", "Web Development", 3, csFourth);
        Course csDataScience = new Course("CS402", "Data Science", 4, csFourth);
        Course csCyberSecurity = new Course("CS403", "Cyber Security", 3, csFourth);
        Course csBlockchain = new Course("CS404", "Blockchain Technology", 3, csFourth);
        Course csBigData = new Course("CS405", "Big Data", 3, csFourth);

        // Add courses to Fourth Year CS branch
        csFourth.addCompulsoryCourse(csWebDev);
        csFourth.addCompulsoryCourse(csDataScience);
        csFourth.addCompulsoryCourse(csCyberSecurity);
        csFourth.addElectiveCourse(csBlockchain);
        csFourth.addElectiveCourse(csBigData);
        LastYear.add(csFourth);

        Course networkSecurity = new Course("IT101", "Network Security",3,itFirst);
        Course databaseManagement = new Course("IT102", "Database Management",3, itFirst);
        Course cloudComputing = new Course("IT103", "Cloud Computing",3, itFirst);
        Course Data_Science = new Course("IT104", "Data Science",3, itFirst);
        Course Computer_Organization = new Course("IT105", "Computer Organization",3, itFirst);
        Course Data_Structures = new Course("IT106", "Data Structures",3, itFirst);
        itFirst.addCompulsoryCourse(networkSecurity);
        itFirst.addElectiveCourse(databaseManagement);
        itFirst.addElectiveCourse(cloudComputing);
        itFirst.addElectiveCourse(Data_Science);
        itFirst.addElectiveCourse(Computer_Organization);
        itFirst.addElectiveCourse(Data_Structures);
        FirstYear.add(itFirst);


        Course itOOP = new Course("IT201", "Object Oriented Programming", 3, itSecond);
        Course itNetworking = new Course("IT202", "Computer Networks", 3, itSecond);
        Course itWebDevelopment = new Course("IT203", "Web Development", 3, itSecond);
        Course itOperatingSystems = new Course("IT204", "Operating Systems", 3, itSecond);
        Course itSoftwareEngineering = new Course("IT205", "Software Engineering", 3, itSecond);

        // Add courses to Second Year IT branch
        itSecond.addCompulsoryCourse(itOOP);
        itSecond.addCompulsoryCourse(itNetworking);
        itSecond.addCompulsoryCourse(itWebDevelopment);
        itSecond.addElectiveCourse(itOperatingSystems);
        itSecond.addElectiveCourse(itSoftwareEngineering);
        SecondYear.add(itSecond);

        Course itCloudComputing = new Course("IT301", "Cloud Computing", 3, itThird);
        Course itBigData = new Course("IT302", "Big Data", 3, itThird);
        Course itMachineLearning = new Course("IT303", "Machine Learning", 3, itThird);
        Course itDataScience = new Course("IT304", "Data Science", 3, itThird);
        Course itAI = new Course("IT305", "Artificial Intelligence", 3, itThird);

        // Add courses to Third Year IT branch
        itThird.addCompulsoryCourse(itCloudComputing);
        itThird.addCompulsoryCourse(itBigData);
        itThird.addCompulsoryCourse(itMachineLearning);
        itThird.addElectiveCourse(itDataScience);
        itThird.addElectiveCourse(itAI);
        ThirdYear.add(csThird);

        Course itCyberSecurity = new Course("IT401", "Cyber Security", 3, itFourth);
        Course itBlockchain = new Course("IT402", "Blockchain Technology", 3, itFourth);
        Course itIot = new Course("IT403", "Internet of Things", 3, itFourth);
        Course itProjectManagement = new Course("IT404", "Project Management", 3, itFourth);
        Course itRobotics = new Course("IT405", "Robotics", 3, itFourth);

        // Add courses to Fourth Year IT branch
        itFourth.addCompulsoryCourse(itCyberSecurity);
        itFourth.addCompulsoryCourse(itBlockchain);
        itFourth.addCompulsoryCourse(itIot);
        itFourth.addElectiveCourse(itProjectManagement);
        itFourth.addElectiveCourse(itRobotics);
        LastYear.add(csFourth);

        Course basicElectronics = new Course("ET101", "Basic Electronics", 3, entcFirst);
        Course circuitAnalysis = new Course("ET102", "Circuit Analysis", 3, entcFirst);
        Course engineeringMath = new Course("ET103", "Engineering Mathematics", 4, entcFirst);
        Course digitalLogic = new Course("ET104", "Digital Logic Design", 3, entcFirst);
        Course introProgramming = new Course("ET105", "Introduction to Programming", 2, entcFirst);
        entcFirst.addCompulsoryCourse(basicElectronics);
        entcFirst.addCompulsoryCourse(circuitAnalysis);
        entcFirst.addCompulsoryCourse(engineeringMath);
        entcFirst.addElectiveCourse(digitalLogic);
        entcFirst.addElectiveCourse(introProgramming);
        FirstYear.add(entcFirst);

        Course analogElectronics = new Course("ET201", "Analog Electronics", 3, entcSecond);
        Course signalsSystems = new Course("ET202", "Signals and Systems", 3, entcSecond);
        Course microprocessors = new Course("ET203", "Microprocessors", 3, entcSecond);
        Course electromagnetics = new Course("ET204", "Electromagnetic Theory", 3, entcSecond);
        Course communicationTheory = new Course("ET205", "Communication Theory", 3, entcSecond);
        entcSecond.addCompulsoryCourse(analogElectronics);
        entcSecond.addCompulsoryCourse(signalsSystems);
        entcSecond.addCompulsoryCourse(microprocessors);
        entcSecond.addElectiveCourse(electromagnetics);
        entcSecond.addElectiveCourse(communicationTheory);
        SecondYear.add(entcSecond);

        Course controlSystems = new Course("ET301", "Control Systems", 3, entcThird);
        Course dsp = new Course("ET302", "Digital Signal Processing", 3, entcThird);
        Course vlsiDesign = new Course("ET303", "VLSI Design", 3, entcThird);
        Course embeddedSystems = new Course("ET304", "Embedded Systems", 3, entcThird);
        Course antennaWavePropagation = new Course("ET305", "Antenna and Wave Propagation", 3, entcThird);
        entcThird.addCompulsoryCourse(controlSystems);
        entcThird.addCompulsoryCourse(dsp);
        entcThird.addCompulsoryCourse(vlsiDesign);
        entcThird.addElectiveCourse(embeddedSystems);
        entcThird.addElectiveCourse(antennaWavePropagation);
        ThirdYear.add(entcThird);

        Course wirelessCommunication = new Course("ET401", "Wireless Communication", 3, entcFourth);
        Course opticalCommunication = new Course("ET402", "Optical Communication", 3, entcFourth);
        Course microwaveEngineering = new Course("ET403", "Microwave Engineering", 3, entcFourth);
        Course projectManagement = new Course("ET404", "Project Management", 3, entcFourth);
        Course aiInEntc = new Course("ET405", "Artificial Intelligence in ENTC", 3, entcFourth);
        entcFourth.addCompulsoryCourse(wirelessCommunication);
        entcFourth.addCompulsoryCourse(opticalCommunication);
        entcFourth.addCompulsoryCourse(microwaveEngineering);
        entcFourth.addElectiveCourse(projectManagement);
        entcFourth.addElectiveCourse(aiInEntc);
        LastYear.add(entcFourth);
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

    public void saveRegistrationData(Student student)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("registration_data.txt",true)))
        {
            writer.write("Student ID: "+student.getId());
            writer.newLine();
            writer.write("Name: " + student.getName());
            writer.newLine();
            writer.write("Email: " + student.getEmail());
            writer.newLine();
            writer.write("Year: " + (student.getBranch() != null ? student.getYear() : "N/A"));
            writer.newLine();
            writer.write("Branch: " + (student.getBranch() != null ? student.getBranch().getBranchName() : "Not Selected"));
            writer.newLine();
            writer.write("Courses Registered:");
            writer.newLine();
            for (Course course : student.getRegisteredCourses()) {
                writer.write("  - " + course.getCourseName() + " (ID: " + course.getCourseId() + ", Credits: " + course.getCredits() + ")");
                writer.newLine();
            }
            writer.write("------------------------------------------------------");
            writer.newLine();
            System.out.println("Registration data saved successfully.");
        }
        catch(IOException e)
        {
            System.out.println("An error occurred while saving registration data.");
            e.printStackTrace();

        }
    }
}
