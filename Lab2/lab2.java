package Lab2;

import javax.swing.*;
import java.awt.*;

public class lab2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Styled Label Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel styledLabel = createStyledLabel("This is an italic text!", Font.ITALIC, 18, Color.BLUE);

        frame.add(styledLabel);

        frame.setVisible(true);
    }

    private static JLabel createStyledLabel(String text, int fontStyle, int fontSize, Color textColor) {
        JLabel label = new JLabel(text);
        Font font = label.getFont();
        Font styledFont = new Font(font.getName(), fontStyle, fontSize);
        label.setFont(styledFont);
        label.setForeground(textColor);
        return label;
    }
}
