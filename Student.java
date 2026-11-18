public class Student {
    private String name;
    private int rollNo;
    private double cgpa;
    private int backlogs;

    public Student(String name, int rollNo,
                   double cgpa, int backlogs) {
        this.name = name;
        this.rollNo = rollNo;
        this.cgpa = cgpa;
        this.backlogs = backlogs;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void display() {
        System.out.println(
            rollNo + " | " + name + " | " +
            cgpa + " | " + backlogs
        );
    }
}
