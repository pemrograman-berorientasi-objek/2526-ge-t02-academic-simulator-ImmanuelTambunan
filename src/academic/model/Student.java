package academic.model;

/**
 * @author 12S24034 - Immanuel Alexander Tambunan
 */
public class Student {
private String id;
    private String name;
    private String entranceYear; // Tahun masuk
    private String studyProgram; // Program studi

    public Student(String id, String name, String entranceYear, String studyProgram) {
        this.id = id;
        this.name = name;
        this.entranceYear = entranceYear;
        this.studyProgram = studyProgram;
    }

    // Method untuk mendapatkan representasi String sesuai format output
    public String toString() {
        return this.id + "|" + this.name + "|" + this.entranceYear + "|" + this.studyProgram;
    }

    // Anda bisa menambahkan getter methods jika diperlukan di masa depan
    // public String getId() { return id; }
    // public String getName() { return name; }
    // public String getEntranceYear() { return entranceYear; }
    // public String getStudyProgram() { return studyProgram; }
}