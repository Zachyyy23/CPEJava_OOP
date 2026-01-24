public class Doctor extends Person {
    private String specialty;
    private double visitFee;


    public Doctor() {
        super();
        specialty = "General";
        visitFee = 0.0;
    }


    public Doctor(String name, String specialty, double visitFee) {
        super(name);
        this.specialty = specialty;
        this.visitFee = visitFee;
    }


    public String getSpecialty() { return specialty; }
    public double getVisitFee() { return visitFee; }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Doctor) {
            Doctor other = (Doctor) obj;
            return getName().equalsIgnoreCase(other.getName()) &&
                    specialty.equalsIgnoreCase(other.specialty) &&
                    visitFee == other.visitFee;
        }
        return false;
    }
}