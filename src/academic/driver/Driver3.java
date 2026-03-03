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
        // Menggunakan ArrayList sebagai media penyimpanan koleksi objek Enrollment
        // Ini adalah implementasi array dinamis yang lebih fleksibel
        List<Enrollment> enrollments = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        // Loop untuk membaca input dari pengg  una secara terus-menerus
        while(true) {
        String line = input.nextLine();

            // Memeriksa apakah input adalah perintah untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memproses baris input untuk membuat objek Enrollment
            String[] enrollmentData = line.split("#");
            if (enrollmentData.length == 4) {
                String courseCode = enrollmentData[0];
                String studentId = enrollmentData[1];
                String academicYear = enrollmentData[2];
                String semester = enrollmentData[3];

                // Membuat objek Enrollment baru dan menambahkannya ke dalam list
                // Menggunakan constructor yang otomatis mengatur mark menjadi "None"
                Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                enrollments.add (newEnrollment);
            } else {
                // Opsional: Penanganan jika format input tidak sesuai
                System.err.println("Peringatan: Format input tidak valid untuk baris ini: " + line);
            }
        }

        // Setelah loop input berhenti, tampilkan semua Enrollment yang tersimpan
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString()); // Memanggil method toString() dari objek Enrollment
        }

        input.close(); // Menutup scanner untuk menghindari resource leak
    }
}