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
        String line;

        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break;
            }

            // Memproses baris input dengan mempertimbangkan prefix "enrollment-add#"
            String[] segments = line.split("#");
            
            // Kita harapkan 5 segmen jika ada prefix: "enrollment-add", dan 4 data
            if (segments.length == 5 && segments[0].equals("enrollment-add")) {
                String courseCode = segments[1];
                String studentId = segments[2];
                String academicYear = segments[3];
                String semester = segments[4];

                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add(newEnrollment);
            } 
            // Tambahan: Jika Anda masih ingin mendukung format tanpa prefix juga di Driver3
            // Anda bisa menambahkan else if untuk format lama, seperti:
            // else if (segments.length == 4) {
            //     String courseCode = segments[0];
            //     String studentId = segments[1];
            //     String academicYear = segments[2];
            //     String semester = segments[3];
            //     Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
            //     enrollments.add(newEnrollment);
            // } 
            else {
                // Pesan peringatan jika format tidak sesuai dengan yang diharapkan (baik dengan prefix maupun tanpa prefix)
                System.err.println("Peringatan: Format input tidak valid untuk baris ini: " + line);
            }
        }

        // Tampilkan semua Enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close();
    }
}