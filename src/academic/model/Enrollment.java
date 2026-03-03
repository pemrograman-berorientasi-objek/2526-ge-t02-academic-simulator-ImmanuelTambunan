package academic.model;

/**
 * @author 12S24034 - Immanuel Alexander Tambunan
 */
public class Enrollment {
private String courseCode;
    private String studentId;
    private String academicYear;
    private String semester;
    private String mark; // Diasumsikan sebagai nilai atau grade untuk enrollment, default "None"

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.mark = "None"; // Default value sesuai contoh output
    }

    // Constructor tambahan jika suatu saat mark perlu diinisialisasi
    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String mark) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.mark = mark;
    }

    // Method untuk mendapatkan representasi String sesuai format output
    public String toString() {
        return this.courseCode + "|" + this.studentId + "|" + this.academicYear + "|" + this.semester + "|" + this.mark;
    }

    // Anda bisa menambahkan getter methods jika diperlukan di masa depan
    // public String getCourseCode() { return courseCode; }
    // public String getStudentId() { return studentId; }
    // public String getAcademicYear() { return academicYear; }
    // public String getSemester() { return semester; }
    // public String getMark() { return mark; }
}