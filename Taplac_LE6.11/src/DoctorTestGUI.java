import javax.swing.*;

public class DoctorTestGUI {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("Hugh Jackman", "Physical Therapist", 500.0);
        Doctor d2 = new Doctor("Chris Evans", "Pediatrician", 500.0);


        JTextArea area = new JTextArea(10, 30);
        area.append("Doctor Name: " + d1.getName() + "\n");
        area.append("Specialty: " + d1.getSpecialty() + "\n");
        area.append("Visit Fee: " + d1.getVisitFee() + "\n");
        area.append("Equals d2? " + d1.equals(d2));


        JFrame frame = new JFrame("Doctor Test");
        frame.add(new JScrollPane(area));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}