package projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlamesSwing extends JFrame {

    JTextField name1Field, name2Field;
    JTextArea resultArea;

    public FlamesSwing() {

        // Window Title
        setTitle("FLAMES Game - Attractive Swing UI");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(null);
        getContentPane().setBackground(new Color(230, 240, 255));

        // Title Label
        JLabel title = new JLabel("FLAMES GAME", SwingConstants.CENTER);
        title.setBounds(50, 20, 330, 40);
        title.setFont(new Font("Verdana", Font.BOLD, 28));
        title.setForeground(new Color(0, 70, 140));
        add(title);

        // First Name Label
        JLabel l1 = new JLabel("Enter First Name:");
        l1.setBounds(50, 100, 200, 30);
        l1.setFont(new Font("Arial", Font.PLAIN, 18));
        add(l1);

        // First Name Input
        name1Field = new JTextField();
        name1Field.setBounds(220, 100, 160, 30);
        name1Field.setFont(new Font("Arial", Font.PLAIN, 16));
        add(name1Field);

        // Second Name Label
        JLabel l2 = new JLabel("Enter Second Name:");
        l2.setBounds(50, 160, 200, 30);
        l2.setFont(new Font("Arial", Font.PLAIN, 18));
        add(l2);

        // Second Name Input
        name2Field = new JTextField();
        name2Field.setBounds(220, 160, 160, 30);
        name2Field.setFont(new Font("Arial", Font.PLAIN, 16));
        add(name2Field);

        // Calculate Button
        JButton calcButton = new JButton("Calculate FLAMES");
        calcButton.setBounds(120, 230, 200, 40);
        calcButton.setFont(new Font("Arial", Font.BOLD, 18));
        calcButton.setBackground(new Color(0, 120, 215));
        calcButton.setForeground(Color.WHITE);
        calcButton.setFocusPainted(false);
        add(calcButton);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setBounds(70, 300, 300, 100);
        resultArea.setFont(new Font("Arial", Font.BOLD, 22));
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(240, 255, 240));
        resultArea.setForeground(new Color(0, 120, 80));
        resultArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(resultArea);

        // Button Action
        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name1 = name1Field.getText().trim().toLowerCase();
                String name2 = name2Field.getText().trim().toLowerCase();
                if (name1.equals("") || name2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter both names.");
                    return;
                }
                String flamesResult = calculateFLAMES(name1, name2);
                resultArea.setText("Result: " + flamesResult);
            }
        });
    }

   
    public String calculateFLAMES(String name1, String name2) {
        StringBuilder n1 = new StringBuilder(name1);
        StringBuilder n2 = new StringBuilder(name2);

        for (int i = 0; i < n1.length(); i++) {
            char ch = n1.charAt(i);
            for (int j = 0; j < n2.length(); j++) {
                if (ch == n2.charAt(j)) {
                    n1.deleteCharAt(i);
                    n2.deleteCharAt(j);
                    i--;
                    break;
                }
            }
        }

        int count = n1.length() + n2.length();
        String flames = "FLAMES";
        StringBuilder f = new StringBuilder(flames);

        while (f.length() > 1) {
            int index = (count % f.length()) - 1;
            if (index >= 0) {
                f.deleteCharAt(index);
            } else {
                f.deleteCharAt(f.length() - 1);
            }
        }

        char result = f.charAt(0);

        switch (result) {
            case 'F': return "Friendship";
            case 'L': return "Love";
            case 'A': return "Affection";
            case 'M': return "Marriage";
            case 'E': return "Enemy";
            case 'S': return "Siblings";
        }
        return "";
    }

    // Main Method
    public static void main(String[] args) {
        new FlamesSwing().setVisible(true);
    }
}
