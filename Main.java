import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnrollmentSystem system = new EnrollmentSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            // Display menu
            System.out.println("\n----- University Course Registration System -----");
            System.out.println("1. Register a Student");
            System.out.println("2. Display Branches");
            System.out.println("3. Display Courses in a Branch");
            System.out.println("4. Display Student Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String YearInput;

            switch (choice) {
                case 1: // Register a Student
                    System.out.println("Enter your year of study\n  First Year \n  Second Year\n  Third Year\n  Fourth Year");
                    YearInput = scanner.nextLine();
                    System.out.println("Enter Student ID:");
                    String studentId = scanner.nextLine();
                    System.out.println("Enter Student Name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter Student Email:");
                    String studentEmail = scanner.nextLine();

                    Student student = new Student(studentId, studentName, studentEmail,YearInput);
                    system.addStudent(student);
                    int selectedElectives=0;

                    // Display available branches
                    //System.out.println("\nAvailable Branches:");
                    system.displayBranchesByYear(YearInput);
                    System.out.println("Enter the branch name you want to enroll in:");
                    String branchChoice = scanner.nextLine();
                    system.registerStudentInBranch(student,branchChoice);
                    System.out.println("Student's branch after registration: " + (student.getBranch() != null ? student.getBranch().getBranchName() : "null"));



                    Branch selectedBranch = student.getBranch();
                    if (selectedBranch != null) {
                        System.out.println("\nCompulsory and Elective Courses for " + selectedBranch.getBranchName() + ":");
                        system.displayBranchCourses(selectedBranch);


                        System.out.println("\nSelect elective courses by entering the course name:");
                        String courseChoice;
                        System.out.println("You have to select "+selectedBranch.getRequiredElectives()+"Courses");
                        while(selectedElectives < selectedBranch.getRequiredElectives())
                            {
                                System.out.println("Select"+(selectedElectives+1)+"th Course:");
                                courseChoice = scanner.nextLine();
                                if (system.enrollInElectiveCourse(student, courseChoice))
                                {
                                    System.out.println("Successfully enrolled in: " + courseChoice);
                                    selectedElectives++;
                                }
                                else
                                {
                                    System.out.println("Invalid course selection or course not available as an elective.");
                                }

                            }
                            System.out.println("Student registration complete!");
                            system.saveRegistrationData(student);
                        }
                    else
                    {
                        System.out.println("Branch selection failed. Please try again.");
                    }
                    break;

                case 2:
                    System.out.println("Enter your year of study\n  First Year \n  Second Year\n  Third Year\n  Fourth Year");
                    YearInput = scanner.nextLine();
                    System.out.println("\nAvailable Branches:");
                    system.displayBranchesByYear(YearInput);
                    break;

                case 3:
                    System.out.println("Enter your year of study\n  First Year \n  Second Year\n  Third Year\n  Fourth Year");
                    YearInput = scanner.nextLine();

                    System.out.println("\nAvailable Branches:");
                    system.displayBranchesByYear(YearInput);
                    System.out.println("Enter the branch name to view courses:");
                    String branchName = scanner.nextLine();
                    Branch branch = system.getBranchByName(YearInput,branchName);


                    if (branch!= null) {
                        System.out.println("\nCourses in " + branch.getBranchName() + " Branch:");
                        system.displayBranchCourses(branch);
                    } else {
                        System.out.println("Branch not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Student ID to view details:");
                    String id = scanner.nextLine();
                    Student existingStudent = system.getStudent(id);
                    if (existingStudent != null) {
                        existingStudent.showInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    break;
            }
        }

        scanner.close();
    }
}
