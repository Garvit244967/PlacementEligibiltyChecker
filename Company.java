public class Company {
    private String name;
    private double minCgpa;
    private int maxBacklogs;

    public Company(String name, double minCgpa,
                   int maxBacklogs) {
        this.name = name;
        this.minCgpa = minCgpa;
        this.maxBacklogs = maxBacklogs;
    }

    public String getName() {
        return name;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public int getMaxBacklogs() {
        return maxBacklogs;
    }
}
