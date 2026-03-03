package academic.driver;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24034_Immanuel Alexander Tambunan
 */
public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            String[] parts = line.split("#");
            // Asumsi input selalu valid sesuai format karena autograder
            String courseCode = parts[0];
            String studentId = parts[1];
            String academicYear = parts[2];
            String semester = parts[3];

            Enrollment enrollment = new Enrollment(courseCode, studentId, academicYear, semester);
            enrollments.add(enrollment);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        input.close();
    }
}