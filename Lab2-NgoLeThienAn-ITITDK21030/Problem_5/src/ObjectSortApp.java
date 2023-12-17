public class ObjectSortApp {
    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public static void main(String[] args) throws Exception {
        Student[] students = new Student[10];
        students[0] = new Student("John", "Doe", 85);
        students[1] = new Student("Jane", "Smith", 92);
        students[2] = new Student("Alice", "Johnson", 78);
        students[3] = new Student("Bob", "Williams", 91);
        students[4] = new Student("Eve", "Brown", 76);
        students[5] = new Student("Charlie", "Lee", 89);
        students[6] = new Student("David", "Davis", 84);
        students[7] = new Student("Grace", "Moore", 94);
        students[8] = new Student("Frank", "Anderson", 80);
        students[9] = new Student("Helen", "White", 87);

        System.out.println("Sorting by first name: ");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getFirstName().compareTo(students[j].getFirstName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        printStudents(students);

        System.out.println("\nSorting by last name: ");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getLastName().compareTo(students[j].getLastName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        printStudents(students);

        System.out.println("\nSorting by Grade: ");
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getGrade() > students[j].getGrade()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        printStudents(students);
    }
}
