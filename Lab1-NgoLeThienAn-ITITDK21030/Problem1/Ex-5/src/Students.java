import java.io.File;
import java.io.IOException;
import java.util.*;

public class Students {
    public static void main(String[] args) throws IOException {
        String first_name, last_name;
        int grade, total = 0, count = 0;
        double average;

        // Define an enum type for student types
        enum StudentType {
            EXCELLENT, OK, FAILURE
        }

        // Initialize counters for each student type
        int excellentCount = 0;
        int okCount = 0;
        int failureCount = 0;

        Scanner fileInput = new Scanner(new File("students.txt"));
        while (fileInput.hasNext()) {
            first_name = fileInput.next();
            last_name = fileInput.next();
            grade = fileInput.nextInt();

            Student st = new Student(first_name, last_name, grade);

            System.out.println(st);

            // Determine student type based on the grade
            StudentType studentType;
            if (grade > 89) {
                studentType = StudentType.EXCELLENT;
                excellentCount++;
            } else if (grade >= 60) {
                studentType = StudentType.OK;
                okCount++;
            } else {
                studentType = StudentType.FAILURE;
                failureCount++;
            }

            // Print student type
            System.out.println("Student Type: " + studentType);

            total = total + grade;
            count++;
        }
        average = (double) total / count;
        System.out.println("There are " + count + " students with an average grade of " + average);

        // Print the counts of each student type
        System.out.println("Excellent Students: " + excellentCount);
        System.out.println("Ok Students: " + okCount);
        System.out.println("Failure Students: " + failureCount);
    }
}
