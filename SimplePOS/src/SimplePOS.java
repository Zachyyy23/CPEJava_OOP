import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimplePOS extends JFrame {
    private JPanel categoryPanel;
    private JPanel itemPanel;
    private JPanel orderSummaryPanel;
    private JTextArea orderSummaryArea;
    private JButton sendButton;

    private ArrayList<String> currentOrder = new ArrayList<>();

    public SimplePOS() {
        setTitle("Mini POS Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout());

        // LEFT PANEL – CATEGORY BUTTONS
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(4, 1, 5, 5));
        String[] categories = {"APPETIZER", "ENTRÉ", "DRINKS", "DESSERTS"};
        for (String cat : categories) {
            JButton btn = new JButton(cat);
            btn.addActionListener(e -> loadItems(cat));
            categoryPanel.add(btn);
        }
        add(categoryPanel, BorderLayout.WEST);

        // CENTER PANEL – ITEM CHOICES
        itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(3, 3, 5, 5));
        loadItems("APPETIZER"); // default
        add(itemPanel, BorderLayout.CENTER);

        // RIGHT PANEL – ORDER SUMMARY
        orderSummaryPanel = new JPanel();
        orderSummaryPanel.setLayout(new BorderLayout());
        orderSummaryArea = new JTextArea();
        orderSummaryArea.setEditable(false);
        orderSummaryPanel.add(new JLabel("Order Summary", SwingConstants.CENTER), BorderLayout.NORTH);
        orderSummaryPanel.add(new JScrollPane(orderSummaryArea), BorderLayout.CENTER);

        sendButton = new JButton("SEND TO KITCHEN ➤");
        sendButton.setBackground(new Color(180, 255, 180));
        sendButton.addActionListener(e -> sendToKitchen());
        orderSummaryPanel.add(sendButton, BorderLayout.SOUTH);

        add(orderSummaryPanel, BorderLayout.EAST);
    }

    private void loadItems(String category) {
        itemPanel.removeAll();
        for (int i = 1; i <= 9; i++) {
            String itemName = category + " " + i;
            JButton itemBtn = new JButton(itemName);
            itemBtn.addActionListener(e -> addItemToOrder(itemName));
            itemPanel.add(itemBtn);
        }
        itemPanel.revalidate();
        itemPanel.repaint();
    }

    private void addItemToOrder(String item) {
        currentOrder.add(item);
        refreshOrderSummary();
    }

    private void refreshOrderSummary() {
        StringBuilder sb = new StringBuilder();
        for (String s : currentOrder) {
            sb.append(s).append("\n");
        }
        orderSummaryArea.setText(sb.toString());
    }

    private void sendToKitchen() {
        if (currentOrder.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No items in the order!");
            return;
        }
        // 👉 Later: this is where you'll send the order to KDS
        System.out.println("Order sent to kitchen: " + currentOrder);

        JOptionPane.showMessageDialog(this, "Order sent to kitchen!");
        currentOrder.clear();
        refreshOrderSummary();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimplePOS frame = new SimplePOS();
            frame.setVisible(true);
        });
    }
}
