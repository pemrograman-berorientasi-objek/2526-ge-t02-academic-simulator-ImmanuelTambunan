package academic.driver;
import academic.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24034 - Immanuel Alexander Tambunan
 */
public class Driver1 {

    public static void main(String[] args) {
        // Menggunakan ArrayList sebagai media penyimpanan koleksi objek Course
        // Ini adalah implementasi array dinamis yang lebih fleksibel
        List<Course> courses = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String line;

        // Loop untuk membaca input dari pengguna secara terus-menerus
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Memeriksa apakah input adalah perintah untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memproses baris input untuk membuat objek Course
            String[] courseData = line.split("#");
            if (courseData.length == 4) {
                String code = courseData[0];
                String name = courseData[1];
                int credits = Integer.parseInt(courseData[2]); // Konversi string ke integer
                String grade = courseData[3];

                // Membuat objek Course baru dan menambahkannya ke dalam list
                Course newCourse = new Course(code, name, credits, grade);
                courses.add(newCourse);
            } else {
                // Opsional: Penanganan jika format input tidak sesuai
                System.err.println("Peringatan: Format input tidak valid untuk baris ini: " + line);
            }
        }

        // Setelah loop input berhenti, tampilkan semua Course yang tersimpan
        for (Course course : courses) {
            System.out.println(course.toString()); // Memanggil method toString() dari objek Course
        }

        input.close(); // Menutup scanner untuk menghindari resource leak
    }
}