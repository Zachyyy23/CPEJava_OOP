import javax.swing.*;
import java.awt.*;
import model.PinMapper;
import model.ChallengeResponse;

public class PinGUI extends JFrame {

    private JTextArea mappingArea;
    private JTextField inputField;
    private JLabel resultLabel;

    private String actualPIN = "12345";
    private PinMapper mapper;
    private ChallengeResponse cr;

    public PinGUI() {
        setTitle("Randomized Challenge-Response Login");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mappingArea = new JTextArea();
        mappingArea.setEditable(false);
        mappingArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(mappingArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        bottomPanel.add(new JLabel("Enter the NUM values for your PIN:"));
        bottomPanel.add(inputField);

        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton newMapButton = new JButton("New Mapping");

        buttonPanel.add(loginButton);
        buttonPanel.add(newMapButton);

        bottomPanel.add(buttonPanel);

        add(bottomPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel(" ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel, BorderLayout.NORTH);

        loginButton.addActionListener(e -> handleLogin());
        newMapButton.addActionListener(e -> generateNewMapping());

        generateNewMapping();
        setVisible(true);
    }

    private void generateNewMapping() {
        mapper = new PinMapper();
        cr = new ChallengeResponse(actualPIN, mapper);

        int[] map = mapper.getMapping();
        StringBuilder sb = new StringBuilder();

        sb.append(" PIN:  ");
        for (int i = 0; i < 10; i++) sb.append(i + " ");
        sb.append("\n NUM:  ");
        for (int value : map) sb.append(value + " ");

        mappingArea.setText(sb.toString());
        resultLabel.setText("New randomized mapping generated.");
        inputField.setText("");
    }

    private void handleLogin() {
        String userEntry = inputField.getText().trim();

        if (cr.authenticate(userEntry)) {
            resultLabel.setText("✔ Access Granted!");
            resultLabel.setForeground(new Color(0, 128, 0));
        } else {
            resultLabel.setText("✘ Access Denied!");
            resultLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        new PinGUI();
    }
}
