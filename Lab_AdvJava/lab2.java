package Lab_AdvJava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class lab2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Hi  its in Italic");
        label.setFont(new Font("Serif", Font.ITALIC, 24));
        label.setForeground(Color.BLUE);

        frame.add(label);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
