package academic.driver;
import academic.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24034_Immanuel Alexander Tambunan
 */
public class Driver2 {

    public static void main(String[] _args) {
        // Menggunakan ArrayList sebagai media penyimpanan koleksi objek Student
        // Ini adalah implementasi array dinamis yang lebih fleksibel
        List<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String line;

        // Loop untuk membaca input dari pengguna secara terus-menerus
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Memeriksa apakah input adalah perintah untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memproses baris input untuk membuat objek Student
            String[] studentData = line.split("#");
            if (studentData.length == 4) {
                String id = studentData[0];
                String name = studentData[1];
                String entranceYear = studentData[2];
                String studyProgram = studentData[3];

                // Membuat objek Student baru dan menambahkannya ke dalam list
                Student newStudent = new Student(id, name, entranceYear, studyProgram);
                students.add(newStudent);
            } else {
                // Opsional: Penanganan jika format input tidak sesuai
                System.err.println("Peringatan: Format input tidak valid untuk baris ini: " + line);
            }
        }

        // Setelah loop input berhenti, tampilkan semua Student yang tersimpan
        for (Student student : students) {
            System.out.println(student.toString()); // Memanggil method toString() dari objek Student
        }

        input.close(); // Menutup scanner untuk menghindari resource leak
    }
}