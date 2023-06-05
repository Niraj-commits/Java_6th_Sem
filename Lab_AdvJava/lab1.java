package Lab_AdvJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import javax.swing.JFrame;

import javax.swing.JPanel;

public class lab1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private double[] values;
    private String[] labels;
    private Color[] colors;

    public lab1() {
        values = new double[] { 30, 20, 25, 15, 10 };
        labels = new String[] { "Apples", "Bananas", "Oranges", "Grapes", "Pears" };
        colors = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA };
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(centerX, centerY);

        double total = 0;
        for (double value : values) {
            total += value;
        }

        double angle1 = 0;
        for (int i = 0; i < values.length; i++) {
            double angle2 = angle1 + values[i] * 360 / total;
            g2.setColor(colors[i]);
            g2.fill(new Arc2D.Double(centerX - radius, centerY - radius, radius * 2, radius * 2, angle1,
                    angle2 - angle1, Arc2D.PIE));
            angle1 = angle2;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pie Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        lab1 panel = new lab1();
        frame.add(panel);

        frame.setVisible(true);
    }
}
