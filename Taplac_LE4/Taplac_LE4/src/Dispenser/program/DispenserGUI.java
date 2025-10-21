package Dispenser.program;

import javax.swing.*;
import java.awt.*;
import CashRegister.model.CashReg;
import Dispenser.model.DispenserObj;

public class DispenserGUI extends JFrame {
    private DispenserObj apple, orange, mango, punch;
    private CashReg cashRegister;

    private JTextArea outputArea;
    private JTextField paymentField;
    private JPasswordField adminPassField;
    private JLabel appleLabel, orangeLabel, mangoLabel, punchLabel;
    private JLabel balanceLabel;

    private static final String ADMIN_PASSWORD = "iloveCPE";

    public DispenserGUI() {
        cashRegister = new CashReg();

        apple = new DispenserObj(10, 30);
        orange = new DispenserObj(10, 25);
        mango = new DispenserObj(10, 45);
        punch = new DispenserObj(10, 40);

        initGUI();
    }

    private void initGUI() {
        setTitle("🍊 Fruit Juice Vending Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(8, 8));

        JPanel left = new JPanel(new BorderLayout(4, 4));
        left.setBorder(BorderFactory.createTitledBorder("Menu & Stock"));

        JPanel listPanel = new JPanel(new GridLayout(4, 1, 4, 4));
        appleLabel = new JLabel(makeItemText("Apple Juice", apple));
        orangeLabel = new JLabel(makeItemText("Orange Juice", orange));
        mangoLabel = new JLabel(makeItemText("Mango Lassi", mango));
        punchLabel = new JLabel(makeItemText("Fruit Punch", punch));
        listPanel.add(appleLabel);
        listPanel.add(orangeLabel);
        listPanel.add(mangoLabel);
        listPanel.add(punchLabel);
        left.add(listPanel, BorderLayout.CENTER);

        JPanel paymentPanel = new JPanel(new BorderLayout(4, 4));
        paymentPanel.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
        paymentPanel.add(new JLabel("Enter payment (₱):"), BorderLayout.NORTH);
        paymentField = new JTextField();
        paymentPanel.add(paymentField, BorderLayout.CENTER);
        left.add(paymentPanel, BorderLayout.SOUTH);

        JPanel center = new JPanel(new GridLayout(4, 1, 6, 6));
        center.setBorder(BorderFactory.createTitledBorder("Buy Drinks"));
        JButton btnApple = new JButton("Buy Apple Juice");
        JButton btnOrange = new JButton("Buy Orange Juice");
        JButton btnMango = new JButton("Buy Mango Lassi");
        JButton btnPunch = new JButton("Buy Fruit Punch");
        center.add(btnApple);
        center.add(btnOrange);
        center.add(btnMango);
        center.add(btnPunch);

        JPanel right = new JPanel(new BorderLayout(6, 6));
        right.setBorder(BorderFactory.createTitledBorder("Admin"));
        JPanel adminTop = new JPanel(new GridLayout(3, 1, 4, 4));
        adminTop.add(new JLabel("Password:"));
        adminPassField = new JPasswordField();
        adminTop.add(adminPassField);
        JButton loginBtn = new JButton("Login");
        adminTop.add(loginBtn);
        right.add(adminTop, BorderLayout.NORTH);
        balanceLabel = new JLabel("Balance: Hidden");
        right.add(balanceLabel, BorderLayout.CENTER);
        JButton exitBtn = new JButton("Exit");
        right.add(exitBtn, BorderLayout.SOUTH);

        outputArea = new JTextArea(6, 40);
        outputArea.setEditable(false);
        JScrollPane outScroll = new JScrollPane(outputArea);
        outScroll.setBorder(BorderFactory.createTitledBorder("Messages"));

        add(left, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
        add(outScroll, BorderLayout.SOUTH);

        btnApple.addActionListener(e -> handlePurchase(apple, "Apple Juice", appleLabel));
        btnOrange.addActionListener(e -> handlePurchase(orange, "Orange Juice", orangeLabel));
        btnMango.addActionListener(e -> handlePurchase(mango, "Mango Lassi", mangoLabel));
        btnPunch.addActionListener(e -> handlePurchase(punch, "Fruit Punch", punchLabel));

        loginBtn.addActionListener(e -> {
            String entered = new String(adminPassField.getPassword());
            if (entered.equals(ADMIN_PASSWORD)) {
                balanceLabel.setText("Balance: ₱" + cashRegister.getCurrentBalance());
                outputArea.append("Admin login successful.\n");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid password.", "Access denied", JOptionPane.ERROR_MESSAGE);
                outputArea.append("Failed admin login.\n");
            }
            adminPassField.setText("");
        });

        exitBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Exit program?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        });

        setVisible(true);
    }

    private void handlePurchase(DispenserObj item, String name, JLabel label) {
        if (item.getNoOfItems() <= 0) {
            outputArea.append("Sorry, " + name + " is sold out.\n");
            return;
        }

        String text = paymentField.getText().trim();
        if (text.isEmpty()) {
            outputArea.append("Please enter payment amount in pesos.\n");
            return;
        }

        double payment;
        try {
            payment = Double.parseDouble(text);
            if (payment < 0) {
                outputArea.append("Payment cannot be negative.\n");
                return;
            }
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid payment.\n");
            return;
        }

        double cost = item.getCost(); // widens int to double automatically
        outputArea.append(name + " costs ₱" + String.format("%.2f", cost) + ". You inserted ₱" + String.format("%.2f", payment) + ".\n");

        if (payment < cost) {
            outputArea.append("Not enough money. Returning ₱" + String.format("%.2f", payment) + ".\n");
        } else {
            cashRegister.acceptAmount((int) cost);
            item.makeSale();
            double change = payment - cost;
            if (change > 0) outputArea.append("Here is your change: ₱" + String.format("%.2f", change) + ".\n");
            outputArea.append("Dispensing " + name + ". Enjoy!\n");
            label.setText(makeItemText(name, item));
        }

        paymentField.setText("");
    }

    private String makeItemText(String name, DispenserObj item) {
        double cost = item.getCost();
        return String.format("%s - ₱%.2f (%d left)", name, cost, item.getNoOfItems());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DispenserGUI());
    }
}
