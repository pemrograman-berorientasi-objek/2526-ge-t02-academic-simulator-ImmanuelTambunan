package academic.driver;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24034_Immanuel Alexander Tambunan
 */
public class Driver3 {

    public static void main(String[] _args) {
        List<Enrollment> enrollments = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while(true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] segments = line.split("#");
            
            // Skenario 1: Input autograder dengan prefix "enrollment-add#" (total 5 segmen)
                String courseCode = segments[1];
                String studentId = segments[2];
                String academicYear = segments[3];
                String semester = segments[4];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close();
    }
}