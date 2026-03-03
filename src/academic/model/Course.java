package academic.model;

/**
 * @author 12S24034 - Immanuel Alexander Tambunan
 */
public class Course {

    private String code;
    private String name;
    private int credits;
    private String grade; // Diasumsikan grade adalah String (A, B, C, D, E)

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Method untuk mendapatkan representasi String sesuai format output
    public String toString() {
        return this.code + "|" + this.name + "|" + this.credits + "|" + this.grade;
    }

    // Anda bisa menambahkan getter methods jika diperlukan di masa depan
    // public String getCode() { return code; }
    // public String getName() { return name; }
    // public int getCredits() { return credits; }
    // public String getGrade() { return grade; }
}