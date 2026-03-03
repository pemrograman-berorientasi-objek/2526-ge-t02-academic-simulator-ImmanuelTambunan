package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author 12S24034_Immanuel Alexander Tambunan
 */
public class Driver4 {

    public static void main(String[] _args) {
        // Menggunakan ArrayList untuk setiap jenis entitas
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        String line;

        // Loop untuk membaca input dari pengguna secara terus-menerus
        while (input.hasNextLine()) {
            line = input.nextLine();

            // Memeriksa apakah input adalah perintah untuk berhenti
            if (line.equals("---")) {
                break; // Keluar dari loop jika "---" ditemukan
            }

            // Memproses baris input berdasarkan prefix
            String[] segments = line.split("#");
            if (segments.length > 0) {
                String command = segments[0];
                String[] data = new String[segments.length - 1];
                System.arraycopy(segments, 1, data, 0, segments.length - 1); // Salin sisa segmen ke array data

                switch (command) {
                    case "course-add":
                        if (data.length == 4) {
                            String code = data[0];
                            String name = data[1];
                            int credits = Integer.parseInt(data[2]);
                            String grade = data[3];
                            Course newCourse = new Course(code, name, credits, grade);
                            courses.add(newCourse);
                        } else {
                            System.err.println("Peringatan: Format input course-add tidak valid: " + line);
                        }
                        break;
                    case "student-add":
                        if (data.length == 4) {
                            String id = data[0];
                            String name = data[1];
                            String entranceYear = data[2];
                            String studyProgram = data[3];
                            Student newStudent = new Student(id, name, entranceYear, studyProgram);
                            students.add(newStudent);
                        } else {
                            System.err.println("Peringatan: Format input student-add tidak valid: " + line);
                        }
                        break;
                    case "enrollment-add":
                        if (data.length == 4) { // Input enrollment hanya 4 segmen, mark default "None"
                            String courseCode = data[0];
                            String studentId = data[1];
                            String academicYear = data[2];
                            String semester = data[3];
                            // Menggunakan constructor Enrollment yang otomatis mengatur mark "None"
                            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
                            enrollments.add(newEnrollment);
                        } else {
                            System.err.println("Peringatan: Format input enrollment-add tidak valid: " + line);
                        }
                        break;
                    default:
                        System.err.println("Peringatan: Perintah tidak dikenal: " + command);
                        break;
                }
            }
        }

        // Setelah loop input berhenti, tampilkan semua entitas dalam urutan yang ditentukan
        // 1. Tampilkan Course
        for (Course course : courses) {
            System.out.println(course.toString());
        }

        // 2. Tampilkan Student
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // 3. Tampilkan Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.toString());
        }

        input.close(); // Menutup scanner
    }
}