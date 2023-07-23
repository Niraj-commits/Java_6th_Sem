package exam;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouse extends JFrame {

    JTextField sum, diff;
    JLabel output;

    public mouse() {
        setTitle("Mouse Events");
        setSize(300, 200);
        setLayout(null);

        sum = new JTextField();
        sum.setBounds(20, 20, 100, 30);
        add(sum);

        diff = new JTextField();
        diff.setBounds(20, 60, 100, 30);
        add(diff);

        output = new JLabel();
        output.setBounds(20, 100, 200, 30);
        add(output);

        diff.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        });
    }

    private void calculateSum() {
        try {
            int num1 = Integer.parseInt(sum.getText());
            int num2 = Integer.parseInt(diff.getText());
            int result = num1 + num2;
            output.setText("Sum: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void calculateDifference() {
        try {
            int num1 = Integer.parseInt(sum.getText());
            int num2 = Integer.parseInt(diff.getText());
            int result = num1 - num2;
            output.setText("Difference: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mouse calculator = new mouse();
                calculator.setVisible(true);
            }
        });
    }
}
