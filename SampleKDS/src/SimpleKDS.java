import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * SimpleKDS.java
 *
 * A single-file, basic Kitchen Display System using Java Swing.
 * - Add orders (simulate POS)
 * - Display orders in a table with elapsed time
 * - Select an order and change its status: Preparing, Ready, Completed, Cancelled
 * - Color-coded rows based on status / elapsed time
 * - Auto-updates elapsed time using a Swing Timer
 *
 * Drop this file into an IntelliJ Java project (src/) and run.
 */
public class SimpleKDS {
    public static void main(String[] args) {
        // Use system look & feel for nicer appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(() -> new KDSFrame().setVisible(true));
    }
}

class KDSFrame extends JFrame {
    private final OrderTableModel model = new OrderTableModel();
    private final JTable table = new JTable(model);
    private final JLabel statusLabel = new JLabel("Ready");

    public KDSFrame() {
        super("Simple Kitchen Display System (KDS)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(8, 8));

        // Top: controls to add orders
        add(createTopPanel(), BorderLayout.NORTH);

        // Center: table
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        // Bottom: action buttons and status
        add(createBottomPanel(), BorderLayout.SOUTH);

        // Table configuration
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(28);

        // Sorter
        TableRowSorter<OrderTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Renderer for coloring
        table.setDefaultRenderer(Object.class, new KDSCellRenderer(model));

        // Add some demo/sample orders
        model.addOrder(new Order("Table 1", "Cheeseburger x1, Fries x1", "Grill"));
        model.addOrder(new Order("Table 2", "Caesar Salad", "Salad"));
        model.addOrder(new Order("Takeaway #12", "Chicken Rice", "Hotline"));

        // Timer to refresh elapsed column every second without losing selection
        Timer refreshTimer = new Timer(1000, e -> {
            int rowCount = model.getRowCount();
            if (rowCount > 0) {
                model.fireTableRowsUpdated(0, rowCount - 1);
            }
        });
        refreshTimer.start();
    }

    private JPanel createTopPanel() {
        JPanel p = new JPanel(new BorderLayout(6, 6));

        // Form panel
        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JTextField tableField = new JTextField(10);
        tableField.setToolTipText("Table number or customer name");
        JTextField stationField = new JTextField(8);
        stationField.setToolTipText("Station (e.g., Grill, Fryer, Salad)");
        JTextArea itemsArea = new JTextArea(3, 30);
        itemsArea.setLineWrap(true);
        itemsArea.setWrapStyleWord(true);
        JScrollPane itemsScroll = new JScrollPane(itemsArea);
        JButton addBtn = new JButton("Add Order (Send)");

        form.add(new JLabel("Table/Name:"));
        form.add(tableField);
        form.add(new JLabel("Station:"));
        form.add(stationField);
        form.add(addBtn);

        p.add(form, BorderLayout.NORTH);
        p.add(itemsScroll, BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            String tbl = tableField.getText().trim();
            String station = stationField.getText().trim();
            String items = itemsArea.getText().trim();
            if (tbl.isEmpty() || station.isEmpty() || items.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill Table/Name, Station and Items.", "Missing info", JOptionPane.WARNING_MESSAGE);
                return;
            }
            model.addOrder(new Order(tbl, items, station));
            tableField.setText("");
            stationField.setText("");
            itemsArea.setText("");
            statusLabel.setText("Last action: order added");
        });

        return p;
    }

    private JPanel createBottomPanel() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));

        JButton prepBtn = new JButton("Mark Preparing");
        JButton readyBtn = new JButton("Mark Ready");
        JButton compBtn = new JButton("Mark Completed");
        JButton cancelBtn = new JButton("Cancel Order");
        JButton detailsBtn = new JButton("View Details");

        actions.add(prepBtn);
        actions.add(readyBtn);
        actions.add(compBtn);
        actions.add(cancelBtn);
        actions.add(detailsBtn);

        p.add(actions, BorderLayout.WEST);
        p.add(statusLabel, BorderLayout.CENTER);

        prepBtn.addActionListener(e -> changeSelectedStatus(Status.PREPARING, "Preparing"));
        readyBtn.addActionListener(e -> changeSelectedStatus(Status.READY, "Ready"));
        compBtn.addActionListener(e -> changeSelectedStatus(Status.COMPLETED, "Completed"));
        cancelBtn.addActionListener(e -> changeSelectedStatus(Status.CANCELLED, "Cancelled"));

        detailsBtn.addActionListener(e -> {
            int r = table.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Select an order first.", "No selection", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int modelRow = table.convertRowIndexToModel(r);
            Order o = model.getOrderAt(modelRow);
            String info = String.format("ID: %s\nTable/Name: %s\nStation: %s\nStatus: %s\nPlaced: %s\nItems:\n%s",
                    o.id, o.table, o.station, o.status, o.placedAtFormatted(), o.items);
            JOptionPane.showMessageDialog(this, info, "Order Details", JOptionPane.INFORMATION_MESSAGE);
        });

        return p;
    }

    private void changeSelectedStatus(Status newStatus, String human) {
        int r = table.getSelectedRow();
        if (r == -1) {
            JOptionPane.showMessageDialog(this, "Select an order first.", "No selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int modelRow = table.convertRowIndexToModel(r);
        Order o = model.getOrderAt(modelRow);
        o.status = newStatus;
        if (newStatus == Status.PREPARING) o.startedAt = Instant.now();
        model.fireTableRowsUpdated(modelRow, modelRow);
        statusLabel.setText("Last action: order " + human + " (" + o.id + ")");
    }
}

enum Status {
    NEW, PREPARING, READY, COMPLETED, CANCELLED
}

class Order {
    final String id;
    final String table;
    final String items;
    final String station;
    final Instant placedAt;
    Instant startedAt; // when status became PREPARING
    Status status;

    Order(String table, String items, String station) {
        this.id = generateShortId();
        this.table = table;
        this.items = items;
        this.station = station;
        this.placedAt = Instant.now();
        this.startedAt = null;
        this.status = Status.NEW;
    }

    private String generateShortId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    String placedAtFormatted() {
        return DateTimeFormatter.ISO_LOCAL_TIME.format(placedAt.atZone(java.time.ZoneId.systemDefault()));
    }

    long elapsedSeconds() {
        Instant end = (status == Status.COMPLETED || status == Status.CANCELLED) ? (startedAt == null ? placedAt : startedAt) : Instant.now();
        Instant from = (status == Status.PREPARING && startedAt != null) ? startedAt : placedAt;
        return Duration.between(from, end).getSeconds();
    }
}

class OrderTableModel extends AbstractTableModel {
    private final String[] columns = {"ID", "Table/Name", "Station", "Status", "Placed At", "Elapsed", "Items"};
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order o) {
        orders.add(0, o); // newest at top
        fireTableRowsInserted(0, 0);
    }

    public Order getOrderAt(int row) {
        return orders.get(row);
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Order o = orders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.id;
            case 1:
                return o.table;
            case 2:
                return o.station;
            case 3:
                return o.status;
            case 4:
                return o.placedAtFormatted();
            case 5:
                return formatElapsed(o.elapsedSeconds());
            case 6:
                return summaryItems(o.items);
            default:
                return "";
        }
    }

    private String formatElapsed(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = seconds / 3600;
        if (h > 0) return String.format("%dh %02dm %02ds", h, m, s);
        return String.format("%02dm %02ds", m, s);
    }

    private String summaryItems(String items) {
        String s = items.replaceAll("\n", " ");
        if (s.length() > 30) return s.substring(0, 27) + "...";
        return s;
    }
}

class KDSCellRenderer extends DefaultTableCellRenderer {
    private final OrderTableModel model;

    public KDSCellRenderer(OrderTableModel model) {
        this.model = model;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int modelRow = table.convertRowIndexToModel(row);
        Order o = model.getOrderAt(modelRow);

        // Default background
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
        } else {
            // Color by status
            switch (o.status) {
                case NEW:
                    c.setBackground(new Color(230, 240, 255)); // light blue
                    c.setForeground(Color.BLACK);
                    break;
                case PREPARING:
                    c.setBackground(new Color(255, 243, 205)); // light yellow
                    c.setForeground(Color.BLACK);
                    break;
                case READY:
                    c.setBackground(new Color(200, 255, 200)); // light green
                    c.setForeground(Color.BLACK);
                    break;
                case COMPLETED:
                    c.setBackground(new Color(220, 220, 220)); // grey
                    c.setForeground(Color.DARK_GRAY);
                    break;
                case CANCELLED:
                    c.setBackground(new Color(255, 210, 210)); // light red
                    c.setForeground(Color.DARK_GRAY);
                    break;
                default:
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
            }

            // Override if elapsed time long and not completed/cancelled
            long sec = o.elapsedSeconds();
            if ((o.status == Status.NEW || o.status == Status.PREPARING) && sec >= 600) { // 10 minutes urgent
                c.setBackground(new Color(255, 160, 160)); // urgent red
                c.setForeground(Color.BLACK);
            } else if ((o.status == Status.NEW || o.status == Status.PREPARING) && sec >= 300) { // 5 minutes warning
                c.setBackground(new Color(255, 220, 150)); // orange-ish
                c.setForeground(Color.BLACK);
            }
        }

        // Make elapsed column bold
        if (column == 5) {
            c.setFont(c.getFont().deriveFont(Font.BOLD));
        } else {
            c.setFont(c.getFont().deriveFont(Font.PLAIN));
        }

        return c;
    }
}
