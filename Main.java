import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlacementManager manager =
            new PlacementManager();

        // Sample company criteria
        manager.addCompany(
            new Company("Google", 8.0, 0)
        );

        manager.addCompany(
            new Company("TCS", 6.5, 1)
        );

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" STUDENT PLACEMENT CHECKER");
            System.out.println("================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Company");
            System.out.println("4. Check Eligibility");
            System.out.println("5. Display Eligible Students");
            System.out.println("6. Rank Students");
            System.out.println("7. Export Placement Report");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    System.out.print("Enter Backlogs: ");
                    int backlogs = sc.nextInt();
                    sc.nextLine();

                    manager.addStudent(
                        new Student(name, roll, cgpa, backlogs)
                    );
                    break;

                case 2:
                    manager.displayStudents();
                    break;
                case 3:
                    System.out.print("Company Name: ");
                    String company = sc.nextLine();

                    System.out.print("Minimum CGPA: ");
                    double minCgpa = sc.nextDouble();

                    System.out.print("Maximum Backlogs: ");
                    int maxBacklogs = sc.nextInt();
                    sc.nextLine();

                    manager.addCompany(
                        new Company(company, minCgpa, maxBacklogs)
                    );
                    break;

                case 4:
                    System.out.print("Enter Roll Number: ");
                    int searchRoll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Company Name: ");
                    String searchCompany = sc.nextLine();

                    Company c = manager.findCompany(searchCompany);

                    boolean found = false;

                    for (Student s : manager.students) {
                        if (s.getRollNo() == searchRoll) {
                            found = true;

                            if (c != null &&
                                manager.isEligible(s, c)) {
                                System.out.println(
                                    "Student is ELIGIBLE!"
                                );
                            } else if (c != null) {
                                System.out.println(
                                    "Student is NOT ELIGIBLE!"
                                );
                            } else {
                                System.out.println(
                                    "Company not found!"
                                );
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Company Name: ");
                    String eligibleCompany = sc.nextLine();

                    manager.displayEligible(eligibleCompany);
                    break;

                case 6:
                    manager.rankStudents();
                    break;

                case 7:
                    System.out.print("Enter Company Name: ");
                    String reportCompany = sc.nextLine();

                    manager.exportReport(reportCompany);
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
