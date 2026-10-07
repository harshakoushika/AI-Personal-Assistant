import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;

public class AIPersonalAssistant extends JFrame
        implements ActionListener {

    JLabel titleLabel;

    JTextField commandField;

    JButton executeButton,
            clearButton;

    JTextArea resultArea;

    public AIPersonalAssistant() {
        setTitle("AI Personal Assistant");

        setSize(750, 600);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(
                new Color(230, 240, 255));

        titleLabel = new JLabel(
                "AI PERSONAL ASSISTANT");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28));

        titleLabel.setBounds(180, 20, 400, 40);

        add(titleLabel);
        JLabel commandLabel =
                new JLabel("Enter Command:");

        commandLabel.setFont(
                new Font("Arial", Font.PLAIN, 18));

        commandLabel.setBounds(60, 100, 180, 30);

        add(commandLabel);
        commandField = new JTextField();

        commandField.setBounds(230, 100, 350, 35);

        commandField.setFont(
                new Font("Arial", Font.PLAIN, 16));

        add(commandField);
        executeButton = new JButton("Execute");

        executeButton.setBounds(150, 180, 160, 45);

        executeButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        executeButton.addActionListener(this);

        add(executeButton);
        clearButton = new JButton("Clear");

        clearButton.setBounds(400, 180, 160, 45);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 16));

        clearButton.addActionListener(this);

        add(clearButton);
        resultArea = new JTextArea();

        resultArea.setBounds(70, 280, 580, 220);

        resultArea.setFont(
                new Font("Monospaced",
                        Font.BOLD, 16));

        resultArea.setEditable(false);

        add(resultArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == clearButton) {

            commandField.setText("");

            resultArea.setText("");

            return;
        }

        String command =
                commandField.getText().toLowerCase();

        try {
            if(command.contains("open notepad")) {

                Runtime.getRuntime().exec("notepad");

                resultArea.setText(
                        "Opening Notepad...");
            }
            else if(command.contains("open calculator")) {

                Runtime.getRuntime().exec("calc");

                resultArea.setText(
                        "Opening Calculator...");
            }

            else if(command.contains("open chrome")) {

                Runtime.getRuntime().exec(
                        "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

                resultArea.setText(
                        "Opening Google Chrome...");
            }
            else if(command.contains("search")) {

                String searchQuery =
                        command.replace("search", "");

                Runtime.getRuntime().exec(
                        "rundll32 url.dll,FileProtocolHandler "
                        + "https://www.google.com/search?q="
                        + searchQuery);

                resultArea.setText(
                        "Searching Google for: "
                        + searchQuery);
            }

            else if(command.contains("time")) {

                LocalTime time =
                        LocalTime.now();

                resultArea.setText(
                        "Current Time: " + time);
            }
            else if(command.contains("hello")
                    || command.contains("hi")) {

                resultArea.setText(
                        "Hello! How can I help you?");
            }

            else if(command.contains("exit")) {

                resultArea.setText(
                        "Closing Assistant...");

                System.exit(0);
            }

            else {

                resultArea.setText(
                        "Sorry! Command Not Recognized.");
            }

        } catch(Exception ex) {

            resultArea.setText(
                    "Error Executing Command!");
        }
    }
    public static void main(String[] args) {

        new AIPersonalAssistant();
    }
}