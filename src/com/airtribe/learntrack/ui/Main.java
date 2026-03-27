
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.Status;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import java.util.Scanner;

public class Main {

    public static void studentMenu(Scanner sc, StudentService service) {

        int choice;
        do {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Update Email");
            System.out.println("4. Remove Student");
            System.out.println("0. Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();

                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Batch: ");
                        String batch = sc.nextLine();

                        System.out.print("Active: ");
                        boolean active = sc.nextBoolean();

                        service.addStudent(fn, ln, email, batch, active);
                        break;
                    }catch(InvalidInputException e){
                        System.out.println(e.getMessage());
                    }

                case 2:
                    service.listStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    service.updateStudentEmail(id, newEmail);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    String removeId = sc.nextLine();
                    service.removeStudent(removeId);
                    break;
            }

        } while (choice != 0);
    }

    public static void courseMenu(Scanner sc, CourseService service) {

        int choice;
        do {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("0. Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Course Name: ");
                    String name = sc.nextLine();

                    System.out.print("Course Description: ");
                    String ds = sc.nextLine();

                    System.out.print("Duration: ");
                    int duration = sc.nextInt();

                    System.out.print("Active: ");
                    boolean active = sc.nextBoolean();

                    service.addCourse(name, ds, duration, active);
                    break;

                case 2:
                    service.listCourses();
                    break;
            }

        } while (choice != 0);
    }

    public static void enrollmentMenu(Scanner sc,
                                      EnrollmentService enrollmentService,
                                      StudentService studentService,
                                      CourseService courseService) {

        int choice;
        do {
            System.out.println("\n--- ENROLLMENT MENU ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. View Enrollments");
            System.out.println("3. Mark Enrollment");
            System.out.println("0. Back");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();

                    System.out.print("Enter Course ID: ");
                    String cid = sc.nextLine();

                    Student student = studentService.searchStudentById(sid);
                    Course course = courseService.searchCourseById(cid);

                    if (student != null && course != null) {
                        enrollmentService.enrollStudent(student, course);
                    } else {
                        System.out.println("Invalid Student or Course");
                    }
                    break;

                case 2:
                    enrollmentService.viewEnrollments();
                    break;

                case 3:
                    System.out.println("Enter Student ID: ");
                    String stid = sc.nextLine();

                    System.out.println("Enter Course ID: ");
                    String coid = sc.nextLine();

                    System.out.println("Enter Status: ");
                    String input = sc.nextLine();
                    Status enroll = Status.valueOf(input.toUpperCase());

                    enrollmentService.markEnrollmentById(stid, coid, enroll);
                    break;
            }

        } while (choice != 0);
    }
}

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        int choice;

        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Main.studentMenu(sc, studentService);
                    break;

                case 2:
                    Main.courseMenu(sc, courseService);
                    break;

                case 3:
                    Main.enrollmentMenu(sc, enrollmentService, studentService, courseService);
                    break;
            }

        } while (choice != 0);
    }

