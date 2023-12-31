package pl.ReFZero.records;

public class RecordClass {
    public static void main(String[] args) {
        Student student1 = new Student(1L, "John", "Davis", 27);
        Student student2 = new Student(2L, "Eva", "Johanson");
        System.out.println(student1);
        System.out.println(student2);
    }

}
