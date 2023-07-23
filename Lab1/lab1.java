package Lab1;

import javax.swing.*;
import java.awt.*;

public class lab1 extends JPanel {

    private final int[] data;
    private final String[] labels;
    private final Color[] colors;

    public lab1(int[] data, String[] labels, Color[] colors) {
        this.data = data;
        this.labels = labels;
        this.colors = colors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPieChart(g);
    }

    private void drawPieChart(Graphics g) {
        int total = 0;
        for (int value : data) {
            total += value;
        }

        int startAngle = 0;
        int arcAngle;
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(width, height) / 3;

        for (int i = 0; i < data.length; i++) {
            arcAngle = (int) ((double) data[i] / total * 360);
            g.setColor(colors[i]);
            g.fillArc(centerX - radius, centerY - radius, 2 * radius, 2 * radius, startAngle, arcAngle);
            startAngle += arcAngle;
        }

        int legendX = centerX + radius + 20;
        int legendY = centerY - data.length * 20 / 2;

        for (int i = 0; i < data.length; i++) {
            g.setColor(colors[i]);
            g.fillRect(legendX, legendY + i * 20, 15, 15);
            g.setColor(Color.BLACK);
            g.drawString(labels[i], legendX + 20, legendY + i * 20 + 12);
        }
    }

    public static void main(String[] args) {
        int[] data = { 40, 40, 20 };
        String[] labels = { "Slice 1", "Slice 2", "Slice 3" };
        Color[] colors = { Color.CYAN, Color.DARK_GRAY, Color.MAGENTA };

        JFrame frame = new JFrame("Lab1 Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new lab1(data, labels, colors));
        frame.setVisible(true);
    }
}
