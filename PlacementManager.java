import java.util.*;
import java.io.*;

public class PlacementManager {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Company> companies = new ArrayList<>();

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // Add company
    public void addCompany(Company c) {
        companies.add(c);
        System.out.println("Company added successfully!");
    }

    // Display all students
    public void displayStudents() {
        System.out.println("\nROLL | NAME | CGPA | BACKLOGS");

        for (Student s : students) {
            s.display();
        }
    }

    // Find company
    public Company findCompany(String name) {
        for (Company c : companies) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // Check eligibility
    public boolean isEligible(Student s, Company c) {
        return s.getCgpa() >= c.getMinCgpa()
            && s.getBacklogs() <= c.getMaxBacklogs();
    }

    // Display eligible students
    public void displayEligible(String companyName) {

        Company c = findCompany(companyName);

        if (c == null) {
            System.out.println("Company not found!");
            return;
        }

        System.out.println("\nEligible students for " + companyName);

        boolean found = false;

        for (Student s : students) {
            if (isEligible(s, c)) {
                s.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No eligible students found.");
        }
    }

    // Rank students by CGPA
    public void rankStudents() {

        ArrayList<Student> ranked =
            new ArrayList<>(students);

        ranked.sort(
            (s1, s2) ->
            Double.compare(s2.getCgpa(), s1.getCgpa())
        );

        System.out.println("\nSTUDENT RANKING");

        int rank = 1;

        for (Student s : ranked) {
            System.out.print("Rank " + rank + ": ");
            s.display();
            rank++;
        }
    }

    // Export eligible students to CSV
    public void exportReport(String companyName) {

        Company c = findCompany(companyName);

        if (c == null) {
            System.out.println("Company not found!");
            return;
        }

        try {
            PrintWriter writer =
                new PrintWriter(
                    new FileWriter("PlacementReport.csv")
                );

            writer.println("Roll Number,Name,CGPA,Backlogs");

            for (Student s : students) {
                if (isEligible(s, c)) {
                    writer.println(
                        s.getRollNo() + "," +
                        s.getName() + "," +
                        s.getCgpa() + "," +
                        s.getBacklogs()
                    );
                }
            }

            writer.close();

            System.out.println(
                "Report exported to PlacementReport.csv"
            );

        } catch (IOException e) {
            System.out.println("Error exporting report!");
        }
    }
}
