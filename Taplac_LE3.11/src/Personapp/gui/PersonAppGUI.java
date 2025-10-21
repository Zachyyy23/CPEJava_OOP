package Personapp.gui;

import Personapp.model.Person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonAppGUI extends JFrame {
    private JTextField nameField1, ageField1;
    private JTextField nameField2, ageField2;
    private JTextField nameField3, ageField3;
    private JTextArea resultArea;
    private JButton compareButton;

    public PersonAppGUI() {
        setTitle("Person Comparison App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Person Info"));

        inputPanel.add(new JLabel("Person 1 Name:"));
        nameField1 = new JTextField();
        inputPanel.add(nameField1);

        inputPanel.add(new JLabel("Person 1 Age:"));
        ageField1 = new JTextField();
        inputPanel.add(ageField1);

        inputPanel.add(new JLabel("Person 2 Name:"));
        nameField2 = new JTextField();
        inputPanel.add(nameField2);

        inputPanel.add(new JLabel("Person 2 Age:"));
        ageField2 = new JTextField();
        inputPanel.add(ageField2);

        inputPanel.add(new JLabel("Person 3 Name:"));
        nameField3 = new JTextField();
        inputPanel.add(nameField3);

        inputPanel.add(new JLabel("Person 3 Age:"));
        ageField3 = new JTextField();
        inputPanel.add(ageField3);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Results"));
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        compareButton = new JButton("Compare Persons");
        add(compareButton, BorderLayout.SOUTH);

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comparePersons();
            }
        });
    }

    private void comparePersons() {
        try {
            String name1 = nameField1.getText();
            int age1 = Integer.parseInt(ageField1.getText());

            String name2 = nameField2.getText();
            int age2 = Integer.parseInt(ageField2.getText());

            String name3 = nameField3.getText();
            int age3 = Integer.parseInt(ageField3.getText());

            Person person1 = new Person(name1, age1);
            Person person2 = new Person(name2, age2);
            Person person3 = new Person(name3, age3);

            StringBuilder sb = new StringBuilder();
//Check if equal or not
            sb.append("Test Result Person 1 and Person 2 = " + (person1.equals(person2) ? "Equal\n" : "Not Equal\n"));
            sb.append("Test Result Person 1 and Person 3 = " + (person1.equals(person3) ? "Equal\n" : "Not Equal\n"));
            sb.append("Test Result Person 2 and Person 3 = " + (person2.equals(person3) ? "Equal\n" : "Not Equal\n\n"));

// Check if same Names
            sb.append("Test Result Person 1 and Person 2 = " + (person1.sameName(person2) ? "Have the Same Name\n" : "Does not Have the Same Name\n"));
            sb.append("Test Result Person 1 and Person 3 = " + (person1.sameName(person3) ? "Have the Same Name\n" : "Does not Have the Same Name\n"));
            sb.append("Test Result Person 2 and Person 3 = " + (person2.sameName(person3) ? "Have the Same Name\n" : "Does not Have the Same Name\n"));

//Check if same Ages
            sb.append("Test Result Person 1 and Person 2 = " + (person1.sameAge(person2) ? "Have the Same Age\n" : "Does not Have the Same Age\n"));
            sb.append("Test Result Person 1 and Person 3 = " + (person1.sameAge(person3) ? "Have the Same Age\n" : "Does not Have the Same Age\n"));
            sb.append("Test Result Person 2 and Person 3 = " + (person2.sameAge(person3) ? "Have the Same Age\n" : "Does not Have the Same Age\n\n  "));

// Younger or Older
            sb.append("Test Result Person 1 and Person 2 = " + (person1.youngerThan(person2) ? "Person 1 is Younger than Person 2\n" :
                    person1.olderThan(person2) ? "Person 1 is Older than Person 2\n" :
                            "They are the Same Age\n"));

            sb.append("Test Result Person 1 and Person 3 = " + (person1.youngerThan(person3) ? "Person 1 is Younger than Person 3\n" :
                    person1.olderThan(person3) ? "Person 1 is Older than Person 3\n" :
                            "They are the Same Age\n"));

            sb.append("Test Result Person 2 and Person 3 = " + (person2.youngerThan(person3) ? "Person 2 is Younger than Person 3\n" :
                    person2.olderThan(person3) ? "Person 2 is Older than Person 3\n" :
                            "They are the Same Age\n"));


            sb.append("\nExtra:\n");
            if (person1.youngerThan(person2)) sb.append("Person 1 is Younger than Person 2\n");
            if (person1.olderThan(person2)) sb.append("Person 1 is Older than Person 2\n");

            if (person1.youngerThan(person3)) sb.append("Person 1 is Younger than Person 3\n");
            if (person1.olderThan(person3)) sb.append("Person 1 is Older than Person 3\n");

            if (person2.youngerThan(person3)) sb.append("Person 2 is Younger than Person 3\n");
            if (person2.olderThan(person3)) sb.append("Person 2 is Older than Person 3\n");

            resultArea.setText(sb.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid ages!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PersonAppGUI().setVisible(true);
        });
    }
}
