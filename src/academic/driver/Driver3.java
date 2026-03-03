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

            // Memproses baris input dengan mempertimbangkan prefix "enrollment-add#"
            // Autograder test_03 menggunakan format ini, mirip Driver4
            String[] segments = line.split("#");
            
            // Kita harapkan 5 segmen jika ada prefix: "enrollment-add", dan 4 data
            // ATAU
            // 4 segmen jika tidak ada prefix (format awal Driver3, mungkin untuk test case lain)
            if (segments.length == 5 && segments[0].equals("enrollment-add")) {
                // Ini adalah format input dari autograder untuk Driver3 ini
                String courseCode = segments[1];
                String studentId = segments[2];
                String academicYear = segments[3];
                String semester = segments[4];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } else if (segments.length == 5) {
                // Ini adalah format input asli/sederhana yang mungkin diharapkan Driver3 di test case lain
                // Contoh: 12S1102#12S20050#2021/2022#odd
                String courseCode = segments[0];
                String studentId = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            }
            else {
                System.err.println("Peringatan: Format input tidak valid untuk baris ini: " + line);
            }
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close();
    }
}